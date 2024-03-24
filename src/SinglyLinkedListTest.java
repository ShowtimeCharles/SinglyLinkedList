import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    private SinglyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList();
    }

    @Test
    void testAddFirst() {
        //Multiple values
        int [] array = new int[] {3, 2, 5, 2, 6};
        list.createList(array);
        list.addFirst(1);
        assertEquals(1, list.getFirst());
        assertEquals(6, list.size());

        //No values
        list.clear();
        list.addFirst(9);
        assertEquals(9, list.getFirst());
        assertEquals(1, list.size());

        //One value
        list.clear();
        int [] array2 = new int[] {3};
        list.createList(array2);
        list.addFirst(6);
        assertEquals(6, list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    void testAddLast() {
        //Multiple values
        int [] array = new int[] {3, 2, 5, 2, 6};
        list.createList(array);
        list.addLast(5);
        assertEquals(5, list.getLast());
        assertEquals(6, list.size());

        //No values
        list.clear();
        list.addLast(9);
        assertEquals(9, list.getLast());
        assertEquals(1, list.size());

        //One value
        list.clear();
        int [] array2 = new int[] {3};
        list.createList(array2);
        list.addLast(6);
        assertEquals(6, list.getLast());
        assertEquals(2, list.size());
    }

    @Test
    void testAddAtIndex() {
        //add at front
        int [] array = new int[] {3, 2, 5, 2, 6};
        list.createList(array);
        list.addAtIndex(0, 1);
        assertEquals(1, list.getFirst());

        //add in middle
        list.clear();
        int [] array2 = new int[] {3, 2, 5, 2, 6};
        list.createList(array2);
        list.addAtIndex(2, 2);
        assertEquals(2, list.getAtIndex(2));
        assertEquals(5, list.getAtIndex(3));

        //add at end
        list.clear();
        int [] array3 = new int[] {3, 2, 5, 2, 6};
        list.createList(array3);
        list.addAtIndex(list.size - 1, 2);
        assertEquals(2, list.getAtIndex(4));
        assertEquals(6, list.getLast());

        //with empty list
        list.clear();
        int [] array4 = new int[] {};
        list.createList(array4);
        list.addAtIndex(0, 5);
        assertEquals(5, list.getAtIndex(0));
        assertEquals(5, list.getFirst());
        assertEquals(5, list.getLast());

        //out of bounds
        list.clear();
        int [] array5 = new int[] {3, 2, 5, 2, 6};
        list.createList(array5);
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAtIndex(list.size, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAtIndex(-1, 3));
    }

    @Test
    void testRemoveFirst() {
        //remove with multiple valuse
        int [] array = new int[] {3, 2, 5, 2, 6};
        list.createList(array);
        list.removeFirst();
        assertEquals(2, list.getFirst());
        assertEquals(2, list.head.value);

        //remove with no values
        list.clear();
        int [] array2 = new int[] {};
        list.createList(array2);
        list.removeFirst();
        assertNull(list.head);
    }

    @Test
    void testRemoveLast() {
        //remove with multiple valuse
        int [] array = new int[] {3, 2, 5, 7, 6};
        list.createList(array);
        list.removeLast();
        assertEquals(7, list.getLast());
        assertEquals(7, list.tail.value);

        //remove with no values
        list.clear();
        int [] array2 = new int[] {};
        list.createList(array2);
        list.removeLast();
        assertNull(list.tail);
    }

    @Test
    void testRemoveAtIndex() {
        //remove with multiple valuse
        int [] array = new int[] {3, 2, 5, 7, 6};
        list.createList(array);
        list.removeAtIndex(1);
        assertEquals(5, list.getAtIndex(1));

        //remove with no values
        list.clear();
        int [] array2 = new int[] {};
        list.createList(array2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAtIndex(0));
        assertNull(list.tail);

        //remove at index 0
        int [] array3 = new int[] {3, 2, 5, 7, 6};
        list.createList(array3);
        list.removeAtIndex(0);
        assertEquals(2, list.getFirst());
        assertEquals(2, list.head.value);

        //remove at last index
        int [] array4 = new int[] {3, 2, 5, 7, 6};
        list.createList(array4);
        list.removeAtIndex(list.size - 1);
        assertEquals(7, list.getLast());
        assertEquals(7, list.tail.value);
    }

    @Test
    void testRemoveElement() {
        //remove with multiple values
        int [] array = new int[] {3, 2, 5, 7, 6};
        list.createList(array);
        assertTrue(list.removeElement(2));
        assertEquals(5, list.getAtIndex(1));

        //remove with no values
        list.clear();
        int [] array2 = new int[] {};
        list.createList(array2);
        assertFalse(list.removeElement(2));

        //remove at index 0
        list.clear();
        int [] array3 = new int[] {3, 2, 5, 7, 6};
        list.createList(array3);
        assertTrue(list.removeElement(3));
        assertEquals(2, list.getFirst());
        assertEquals(2, list.head.value);

        //remove with only 1 value
        list.clear();
        int [] array4 = new int[] {4};
        list.createList(array4);
        assertTrue(list.removeElement(4));
        assertTrue(list.isEmpty());
        assertNull(list.head);

        //remove at last index
        list.clear();
        int [] array5 = new int[] {3, 2, 5, 7, 6};
        list.createList(array5);
        assertTrue(list.removeElement(6));
        assertEquals(7, list.getLast());
        assertEquals(7, list.tail.value);

        //remove first occurrence
        list.clear();
        int [] array6 = new int[] {3, 2, 2, 7, 6};
        list.createList(array6);
        assertTrue(list.removeElement(2));
        assertEquals(2, list.getAtIndex(1));
    }

    @Test
    void testGetFirst() {
        list.addFirst(1);
        assertEquals(1, list.getFirst());
        assertEquals(1, list.size()); // Ensures size is updated correctly
        // Indirectly checks that head is correctly set by verifying the value
    }

    @Test
    void testGetLast() {
        list.addLast(1);
        assertEquals(1, list.getLast());
        assertEquals(1, list.size()); // Ensures size is updated correctly
        // Indirectly checks that tail is correctly set by verifying the value
    }

    @Test
    void testGetAtIndex() {
        list.addLast(1);
        list.addLast(2);
        assertEquals(1, list.getAtIndex(0));
        assertEquals(2, list.getAtIndex(1));
        assertEquals(2, list.size()); // Ensures size is correctly updated
        // Indirect verification of list integrity through expected values
    }

    @Test
    void testIndexOf() {
        //index first with multiple values
        int [] array = new int[] {3, 2, 5, 7, 6};
        list.createList(array);
        assertEquals(0, list.indexOf(3));

        //index middle with multiple values
        list.clear();
        int [] array2 = new int[] {3, 2, 5, 7, 6};
        list.createList(array2);
        assertEquals(2, list.indexOf(5));

        //index last with multiple values
        list.clear();
        int [] array3 = new int[] {3, 2, 5, 7, 6};
        list.createList(array3);
        assertEquals(4, list.indexOf(6));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size()); // Check size on a new list
        list.addFirst(1);
        assertEquals(1, list.size()); // Check size after adding an item
        list.addLast(2);
        assertEquals(2, list.size()); // Check size after adding another item
        // Direct test of size functionality
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.addFirst(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void testClear() {
        list.addFirst(1);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testToArray() {
        list.addFirst(1);
        list.addLast(2);
        assertArrayEquals(new int[]{1, 2}, list.toArray());

        list.clear();
        int [] array = new int[] {3, 2, 5, 7, 6};
        list.createList(array);
        assertArrayEquals(array, list.toArray());
    }
}