import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

	private BinaryTreeInOrderIterator<BankAccount> iterator;
	private Filter<BankAccount> filter;
    private BankAccount current;
    
    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree, Filter<BankAccount> filter) {
        this.filter = filter;
        this.iterator = (BinaryTreeInOrderIterator<BankAccount>)bankAccountsTree.iterator();
        current = findNext();
    }

    //Complete the following method
    @Override
    public boolean hasNext() {
        return current!=null;
    }

    //Complete the following method
    @Override
    public BankAccount next() {
        if (!hasNext())
        	throw new NoSuchElementException();
        BankAccount curr = current;
        current = findNext();
        return curr;
    }
    // A method that generates our next valid BankAccount that has passed the filter.
    private BankAccount findNext() {
    	BankAccount nextAcc = null;
    	while(iterator.hasNext() & nextAcc == null) {
    		BankAccount checkedAcc = iterator.next();
    		if(filter.accept(checkedAcc))
    			nextAcc = checkedAcc;
    	}
    	return nextAcc;
    }
}
