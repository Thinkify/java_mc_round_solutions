import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class DigitalWalletException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param string
	 */

	private String message;

	public DigitalWalletException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DigitalWalletException = " + message + " [getMessage()=" + getMessage() + "]";

	}

}

public class DigitalWallet {

	/*
	 * Data structure to store the account holder's name as key and value as the
	 * amount
	 */
	private Map<String, Double> accountWallet;

	/*
	 * Store the account holder's name as key and statement as the value
	 */
	private Map<String, List<String>> accountStatement;

	private static final double MINIMUM_AMOUNT = 0.0001;

	private static final String DEBIT = "debit";
	private static final String CREDIT = "credit";
	private static final String OFFER1 = "offer1";
	private static final String OFFER2 = "offer2";
	private static final double OFFER1Amount = 10.0;

	// Initialize the data structure
	public DigitalWallet() {
		accountWallet = new LinkedHashMap<String, Double>();
		accountStatement = new LinkedHashMap<String, List<String>>();
	}

	/**
	 * @param accountHolderName - name of the account holder
	 * @param amount            - wallet initial amount
	 * @throws DigitalWalletException
	 */
	private void createWallet(String accountHolderName, Double amount)
			throws IllegalArgumentException, DigitalWalletException {

		if (accountWallet.containsKey(accountHolderName) || amount < MINIMUM_AMOUNT) {
			throw new DigitalWalletException("Already present");
		}

		accountWallet.put(accountHolderName, amount);
	}

	/**
	 * @param sender   - sender's name
	 * @param receiver - receiver's name
	 * @param amount   - transfer amount
	 * @throws DigitalWalletException
	 */
	private void tranferMoney(String sender, String receiver, Double amount) throws DigitalWalletException {

		// check for 2 cases
		// 1. check if amount is lesser than the minimum amount
		// 2. check if the sender or receiver are there in the memory
		if (amount < MINIMUM_AMOUNT || !accountWallet.containsKey(sender) || !accountWallet.containsKey(receiver)) {
			throw new DigitalWalletException("Operation is not valid for user = " + sender);
		}

		double senderCurrentBalance = accountWallet.get(sender);
		double receiverCurrentBalance = accountWallet.get(receiver);
		if (senderCurrentBalance - amount < 0) {
			throw new DigitalWalletException("Balance less than zero");
		}

		// Debit the amount from the sender
		accountWallet.put(sender, senderCurrentBalance - amount);

		// Credit the amount to receiver
		accountWallet.put(receiver, receiverCurrentBalance + amount);

		addStatement(sender, receiver, amount, DEBIT);
		// System.out.println(accountStatement.get(receiver));
		addStatement(receiver, sender, amount, CREDIT);
		if (accountWallet.get(sender).equals(accountWallet.get(receiver))) {
			accountWallet.put(receiver, accountWallet.get(receiver) + OFFER1Amount);
			accountWallet.put(sender, accountWallet.get(sender) + OFFER1Amount);
			addStatement(OFFER1, sender, OFFER1Amount, CREDIT);
			addStatement(OFFER1, receiver, OFFER1Amount, CREDIT);
		}

		// System.out.println(accountStatement.get(sender));
		// System.out.println(accountStatement.get(receiver));
	}

	/**
	 * @param sender   - name of the account holder sending the payment
	 * @param receiver - name if the account holder recieving the payment
	 * @param amount   - amount that needs to be debited/ credited
	 * @param mode     - mode of payment
	 */
	private void addStatement(String sender, String receiver, Double amount, String mode) {

		// 1. statement = sender' name
		// 2. receiver's name update

		String statement = sender + " " + mode + " " + amount;
		if (accountStatement.containsKey(receiver)) {
			List<String> list = accountStatement.get(receiver);
			list.add(statement);
			accountStatement.put(receiver, list);
		} else {
			List<String> list = new ArrayList<>();
			list.add(statement);
			accountStatement.put(receiver, list);
		}
	}

	/**
	 * Displays the current balance of all the accounts
	 * 
	 * @throws DigitalWalletException
	 */
	private void overview() throws DigitalWalletException {
		if (accountWallet.size() == 0) {
			throw new DigitalWalletException("Wallet is Empty");
		}

		for (String key : accountWallet.keySet()) {
			System.out.println(key + " " + accountWallet.get(key));
		}
	}

	/**
	 * @param name - Account Holder name
	 * @throws DigitalWalletException
	 */
	private void statement(String name) throws DigitalWalletException {
		if (!accountStatement.containsKey(name)) {
			throw new DigitalWalletException("No statement for user = " + name);
		}

		System.out.println(accountStatement.get(name));

	}

	public static void main(String[] args) {
		DigitalWallet wallet = new DigitalWallet();
		try {
			wallet.createWallet("Harry", 100.0);
			wallet.createWallet("Ron", 95.7);
			wallet.createWallet("Hermione", 104.0);
			wallet.createWallet("Albus", 200.0);
			wallet.createWallet("Draco", 500.0);
			// wallet.createWallet("Ron", 95.8);
			// wallet.overview();
			wallet.tranferMoney("Albus", "Draco", 30.0);
			wallet.tranferMoney("Hermione", "Harry", 2.0);
			wallet.tranferMoney("Albus", "Ron", (double) 1 / 100000);
			// wallet.tranferMoney("Albus", "Hardik", 5.0);
			wallet.overview();
			wallet.statement("Hardik");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
