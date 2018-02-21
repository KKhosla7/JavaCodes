package linkedlist;

public class LinkedList {
	private int value;
	private LinkedList nextNode;
	private static int size;

	public LinkedList(int value) {
		this.value = value;
		nextNode = null;
		size++;
	}
	
	public LinkedList(int value, LinkedList nextNode) {
		this(value);
		this.nextNode = nextNode;
	}

	public int getValue() {
		return value;
	}

	public LinkedList getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkedList linkedList) {
		nextNode = linkedList;
	}

	public LinkedList firstNode() {
		return this;
	}

	public LinkedList lastNode() {
		LinkedList linkedList = this;
		LinkedList previous = null;
		while (linkedList != null) {
			previous = linkedList;
			linkedList = linkedList.getNextNode();
		}
		return previous;
	}

	public boolean find(int value) {
		boolean result = false;
		LinkedList linkedList = this;
		while (linkedList != null) {
			if (linkedList.getValue() == value) {
				result = true;
			}
			linkedList = linkedList.getNextNode();
		}
		return result;
	}

	public void delete(int value) {
		LinkedList linkedList = this;
		LinkedList previous = null;
		while (linkedList != null) {
			if (linkedList.getValue() == value) {
				size--;
				previous.setNextNode(linkedList.getNextNode());
			}
			previous = linkedList;
			linkedList = linkedList.getNextNode();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		LinkedList linkedList = this;
		while (linkedList != null) {
			builder.append(linkedList.getValue());
			linkedList = linkedList.getNextNode();
			if (linkedList != null) {
				builder.append(", ");
			}
		}
		return builder.toString();
	}

	public static LinkedList of(int... elements) {
		LinkedList result = null;
		for (int i = 0; i < elements.length; i++) {
			if (result == null) {
				result = new LinkedList(elements[i]);
			} else {
				result.add(new LinkedList(elements[i]));
			}
		}
		return result;
	}

	private void add(LinkedList element) {
		LinkedList head = this;
		LinkedList previous = null;
		while (head != null) {
			previous = head;
			head = head.getNextNode();
		}
		previous.setNextNode(element);
	}

	public int size() {
		return size;
	}

	public void findANodeAndInsertNewNodeAfterKeyNode(int key, int value) {
		LinkedList head = this;
		LinkedList next = null;
		while (head != null) {
			if (head.getValue() == key) {
				next = head.getNextNode();
				LinkedList newNode = new LinkedList(value);
				head.setNextNode(newNode);
				head.add(next);
				break;
			}
			head = head.getNextNode();
		}
	}
	
	public void findANodeAndInsertNewNodeBeforeKeyNode(int key, int value) {
		LinkedList head = this;
		LinkedList previous = null;
		while (head != null) {
			if (head.getValue() == key) {
				LinkedList newNode = new LinkedList(value);
				previous.setNextNode(newNode);
				previous.add(head);
				break;
			}
			previous = head;
			head = head.getNextNode();
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
