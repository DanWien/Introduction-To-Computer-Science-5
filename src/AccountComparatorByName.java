import java.util.Comparator;

public class AccountComparatorByName implements Comparator<BankAccount>{

	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		// Using the Lexicographic string comparator.
		return account1.getName().compareTo(account2.getName());
	}
}
