import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		// Using the Integer comparator.
		Integer a = account1.getAccountNumber();
		Integer b = account2.getAccountNumber();
		return a.compareTo(b);
	}
}
