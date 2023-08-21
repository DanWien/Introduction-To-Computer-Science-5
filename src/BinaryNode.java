
public class BinaryNode<T> {

	protected T data;
	protected BinaryNode<T> left;
	protected BinaryNode<T> right;

	public BinaryNode(T element) {
		if (element == null)
			throw new IllegalArgumentException();
		this.data = element;
		left = null;
		right = null;
	}

	public void insert(T element) {
		if (Math.random() < 0.5) {
			if (left == null)
				left = new BinaryNode<T>(element);
			else
				left.insert(element);
		} else {
			if (right == null)
				right = new BinaryNode<T>(element);
			else
				right.insert(element);
		}
	}

	public BinaryNode<T> remove(T toRemove) {
		BinaryNode<T> output = this;

		if (data.equals(toRemove)) {
			if (left != null) {
				data = left.data;
				left = left.remove(data);
			} else if (right != null) {
				data = right.data;
				right = right.remove(data);
			} else
				output = null;
		} else {
			if (left != null && left.contains(toRemove))
				left = left.remove(toRemove);
			else if (right != null)
				right = right.remove(toRemove);
		}
		return output;
	}

	public boolean contains(T element) {
		boolean found = false;
		if (data.equals(element))
			found = true;
		else if (left != null && left.contains(element))
			found = true;
		else if (right != null && right.contains(element))
			found = true;
		return found;
	}

	public int height() {
		int leftH = -1, rightH = -1;
		if (left != null)
			leftH = left.height();
		if (right != null)
			rightH = right.height();
		return Math.max(leftH, rightH) + 1;
	}

	public int size() {
		int leftS = 0, rightS = 0;
		if (left != null)
			leftS = left.size();
		if (right != null)
			rightS = right.size();
		return leftS + rightS + 1;
	}

	public boolean equals(Object other) {
		boolean isEqual = true;
		// Check type
		if (!(other instanceof BinaryNode<?>))
			isEqual = false;
		else {
			BinaryNode<?> otherNode = (BinaryNode<?>) other;
			// Check data
			if (!data.equals(otherNode.data))
				isEqual = false;
			// Check left
			else if (((left == null) | (otherNode.left == null)) & (left != otherNode.left))
				isEqual = false;
			else if ((left != null) && !left.equals(otherNode.left))
				isEqual = false;
			// Check right
			else if (((right == null) | (otherNode.right == null)) & (right != otherNode.right))
				isEqual = false;
			else if ((right != null) && !right.equals(otherNode.right))
				isEqual = false;
		}
		return isEqual;
	}

	// Complete the following method
	public String toString() {
		return this.toString("", 0);
	}

	private String toString(String acc, int depth) {
		// Traverse left
		if (this.left != null)
			acc = this.left.toString(acc, depth + 1);
		// Building our string using a spacing method and concatenation.
		acc = spaces(acc, depth);
		acc = acc + this.data + "\n";
		// Traverse right
		if (this.right != null)
			acc = this.right.toString(acc, depth + 1);
		return acc;
	}
	// Calculates the amount of spaces to add determined by the input depth.
	private static String spaces(String acc, int depth) {
		for (int i = 0; i < depth * 2; i = i + 1)
			acc = acc + " ";
		return acc;
	}
}