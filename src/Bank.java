public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	
	// END OF Given code -----------------------------------
	
	// Complete the methods from here on
	
	// For all of the methods below , we first make sure the input accounts exist if we want to implement
	// Actions on them , and if we want to add a new account , we make sure the input account
	// Is unique.

	public boolean add(BankAccount newAccount) {
		if (lookUp(newAccount.getName()) != null)
			return false;
		if (lookUp(newAccount.getAccountNumber()) != null)
			return false;
		namesTree.insert(newAccount);
		accountNumbersTree.insert(newAccount);
		return true;		
	}

	public boolean delete(String name){
		BankAccount toRemove = lookUp(name);
		if (toRemove == null)
			return false;
		namesTree.remove(toRemove);
		accountNumbersTree.remove(toRemove);
		return true;
	}
	
	public boolean delete(int accountNumber){
		BankAccount toRemove = lookUp(accountNumber);
		if (toRemove == null)
			return false;
		namesTree.remove(toRemove);
		accountNumbersTree.remove(toRemove);
		return true;
	}

	public boolean depositMoney(int amount, int accountNumber){
		BankAccount curr = lookUp(accountNumber);
		if (curr == null)
			return false;
		return curr.depositMoney(amount);
	}

	public boolean withdrawMoney(int amount, int accountNumber){
		BankAccount curr = lookUp(accountNumber);
		if (curr == null)
			return false;
		return curr.withdrawMoney(amount);
	}	
	
	public boolean transferMoney(int amount, int accountNumber1, int accountNumber2) {
		BankAccount account1 = lookUp(accountNumber1);
		BankAccount account2 = lookUp(accountNumber2);
		if (account1 == null || account2 == null | account1.getBalance() < amount)
			return false;
		account1.withdrawMoney(amount);
		account2.depositMoney(amount);
		return true;
	}	
	public boolean transferMoney(int amount, int accountNumber, String name) {
		BankAccount account1 = lookUp(accountNumber);
		BankAccount account2 = lookUp(name);
		if (account1 == null || account2 == null | account1.getBalance() < amount)
			return false;
		account1.withdrawMoney(amount);
		account2.depositMoney(amount);
		return true;
	}	
}
