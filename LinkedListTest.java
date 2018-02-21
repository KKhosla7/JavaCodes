package linkedlist;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void createLinkedList_withSingleElement() {
        LinkedList linkedList = LinkedList.of(10);
        assertEquals(10, linkedList.getValue());
        assertNull(linkedList.getNextNode());
    }
    
    @Test
    public void createLinkedList_withNoElements_returnsEmpty() {
        LinkedList linkedList = LinkedList.of(10);
        linkedList.delete(10);
        assertEquals(true, linkedList.isEmpty());
    }
    
    @Test
    public void createLinkedList_withMultipleElements_performAddAndDelete_returnsCorrectSize() {
        LinkedList linkedList = LinkedList.of(10, 20, 30, 40, 50, 60, 70, 80, 90);
        assertEquals(9, linkedList.size());
        linkedList.delete(40);
        assertEquals(8, linkedList.size());
    }

    @Test
    public void createLinkedList_withTwoElement() {
        LinkedList linkedList = LinkedList.of(10, 20);
        assertEquals(10, linkedList.getValue());
        assertEquals(20, linkedList.getNextNode().getValue());
    }

    @Test
    public void createLinkedList_withThreeElement() {
    	LinkedList linkedList = LinkedList.of(10, 20, 30);
        assertEquals(10, linkedList.getValue());
        assertEquals(20, linkedList.getNextNode().getValue());
        assertEquals(30, linkedList.getNextNode().getNextNode().getValue());
    }

    @Test
    public void createdLinkedList_withElements_prettyPrintValues() {
        /*LinkedList linkedList = new LinkedList(10);
        LinkedList second = new LinkedList(20);
        linkedList.setNextNode(second);
        LinkedList third = new LinkedList(30);
        second.setNextNode(third);*/
    	LinkedList linkedList = LinkedList.of(10, 20, 30);
        assertEquals("10, 20, 30", linkedList.toString());
    }

    @Test
    public void createLinkedList_withElements_getFirstAndLastElementInList() {
    	LinkedList linkedList = LinkedList.of(10, 20, 30);
        assertEquals(10, linkedList.firstNode().getValue());
        assertEquals(30, linkedList.lastNode().getValue());
    }

    @Test
    public void createLinkedList_withElements_findAnElement() {
    	LinkedList linkedList = LinkedList.of(10, 20, 30);
        assertTrue(linkedList.find(30));
    }

    @Test
    public void createLinkedList_withElements_deleteAnElement() {
    	LinkedList linkedList = LinkedList.of(10, 20, 30, 40);
        linkedList.delete(20);
        assertEquals("10, 30, 40", linkedList.toString());
    }
    
    @Test
    public void createLinkedList_withElements_insertAfterNode() {
    	LinkedList linkedList = LinkedList.of(10, 20, 40, 50);
        linkedList.findANodeAndInsertNewNodeAfterKeyNode(20, 30);
        assertEquals("10, 20, 30, 40, 50", linkedList.toString());
        assertEquals(5, linkedList.size());
    }
    
    @Test
    public void createLinkedList_withElements_insertBeforeNode() {
    	LinkedList linkedList = LinkedList.of(10, 30, 40, 50);
        linkedList.findANodeAndInsertNewNodeBeforeKeyNode(30, 20);
        assertEquals("10, 20, 30, 40, 50", linkedList.toString());
    }
}
