import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount> {

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}

	// Complete the following methods
	public void balance() {
		List<BankAccount> myArray = new DynamicArray<BankAccount>();
		for (BankAccount a : this)
			myArray.add(a);
		// Setting the root to null "resets" our tree.
		this.root = null;
		this.buildBalancedTree(myArray, 0, myArray.size()-1);
	}

	private void buildBalancedTree(List<BankAccount> list, int low, int high) {
		// Inserting the average value to the root , and then the left side of the tree consists of values
		// That are smaller , and by taking the average every time we maintain the balance , while doing the
		// Same for the right side (with bigger values than root).
		int mid = (low+high)/2;
		if(low <= high) {
			this.insert(list.get(mid));
			this.buildBalancedTree(list, low, mid-1);
			this.buildBalancedTree(list, mid+1, high);
		}
	}
}
