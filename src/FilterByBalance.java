public class FilterByBalance implements Filter<BankAccount>{
	private int balanceThreshold;
	public FilterByBalance(int balanceThreshold) {
        // task 5c
        this.balanceThreshold = balanceThreshold;
	}
	@Override
	public boolean accept(BankAccount elem) {
		// Making sure we don't invoke methods on a null value.
		if (elem == null)
			return false;
		return elem.getBalance() >= this.balanceThreshold;
	}
}
