package linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void createLinkedList_withSingleElement() {
        LinkedList linkedList = new LinkedList(10);
        assertEquals(10, linkedList.getValue());
        assertNull(linkedList.getNextNode());
    }

    @Test
    public void createLinkedList_withTwoElement() {
        LinkedList linkedList = new LinkedList(10);
        LinkedList second = new LinkedList(20);
        linkedList.setNextNode(second);
        assertEquals(10, linkedList.getValue());
        assertEquals(20, linkedList.getNextNode().getValue());
    }

    @Test
    public void createLinkedList_withThreeElement() {
        LinkedList linkedList = new LinkedList(10);
        LinkedList second = new LinkedList(20);
        linkedList.setNextNode(second);
        LinkedList third = new LinkedList(30);
        second.setNextNode(third);
        assertEquals(10, linkedList.getValue());
        assertEquals(20, linkedList.getNextNode().getValue());
        assertEquals(30, linkedList.getNextNode().getNextNode().getValue());
    }

    @Test
    public void createdLinkedList_withElements_printValues() {
        LinkedList linkedList = new LinkedList(10);
        LinkedList second = new LinkedList(20);
        linkedList.setNextNode(second);
        LinkedList third = new LinkedList(30);
        second.setNextNode(third);
        assertEquals(10, linkedList.getValue());
        assertEquals(20, linkedList.getNextNode().getValue());
        assertEquals(30, linkedList.getNextNode().getNextNode().getValue());
        assertEquals("10, 20, 30", linkedList.toString());
    }

    @Test
    public void createLinkedList_withElements_getFirstAndLastElementInList() {
        LinkedList linkedList = new LinkedList(10);
        LinkedList second = new LinkedList(20);
        linkedList.setNextNode(second);
        LinkedList third = new LinkedList(30);
        second.setNextNode(third);
        assertEquals(10, linkedList.firstNode().getValue());
        assertEquals(30, linkedList.lastNode().getValue());
    }

    @Test
    public void createLinkedList_withElements_findAnElement() {
        LinkedList linkedList = new LinkedList(10);
        LinkedList second = new LinkedList(20);
        linkedList.setNextNode(second);
        LinkedList third = new LinkedList(30);
        second.setNextNode(third);
        assertTrue(linkedList.find(30));
    }

    @Test
    public void createLinkedList_withElements_deleteAnElement() {
        LinkedList linkedList = new LinkedList(10);
        LinkedList second = new LinkedList(20);
        linkedList.setNextNode(second);
        LinkedList third = new LinkedList(30);
        second.setNextNode(third);
        linkedList.delete(20);
        assertEquals("10, 30", linkedList.toString());
    }
}
