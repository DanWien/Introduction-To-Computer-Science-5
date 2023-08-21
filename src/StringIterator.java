import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringIterator implements Iterator<String> {
	private String next;

	// Complete the following methods
	public StringIterator(String start) {
		next = start;
	}

	public boolean hasNext() {
		return (next.length() < Integer.MAX_VALUE);
	}

	public String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		// Saving the current string , calculating the next one , then returning current.
		String curr = next;
		if (next.length() == 0)
			next = "a";
		else {
			// Entering this means the string length is bigger than 0.
			char last = next.charAt(next.length() - 1);
			// Basic case where we don't meet Z or z.
			if (last != 'z' & last != 'Z')
				next = next.substring(0, next.length() - 1) + (char) (last + 1);
			// Counting the numbers of Z's in the input string to know how many a's to return.
			else if (last == 'Z') {
				int counterZ = 0;
				while (last == 'Z' & next.length() > 0) {
					next = next.substring(0, next.length() - 1);
					counterZ = counterZ + 1;
					// Updating last accordingly.
					if (next.length() > 0)
						last = next.charAt(next.length() - 1);
				}
				if (next.length() > 0) {
					if (last != 'z')
						next = next.substring(0, next.length() - 1) + (char) (last + 1);
					// Edge case of a z followed by Z's.
					else
						next = next.substring(0,next.length()-1) + "A";
				}
				// Edge case of a string consisting only of Z's , and an increment to the counter.
				if (next.length() == 0)
					counterZ = counterZ + 1;
				while (counterZ > 0) {
					next = next + "a";
					counterZ = counterZ - 1;
				}
			} 
			else if (last == 'z') {
				next = next.substring(0, next.length() - 1) + "A";
			}
		}
		return curr;
	}
}
