package linkedlist;

public class LinkedList {
    private int value;
    private LinkedList nextNode;

    public LinkedList(int value) {
        this.value = value;
        nextNode = null;
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
                previous.setNextNode(linkedList.getNextNode());
            }
            previous = linkedList;
            linkedList = linkedList.getNextNode();
        }
    }

    private static class IllegalLinkedListException extends RuntimeException {
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
}
