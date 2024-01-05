package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import prj5.SLList.Node;
import student.TestCase;

/**
 * 
 * @author Laith Al-Masri (laith21)
 * @author Sai Balusu (saib)
 * @author Harsha Paladugu (harshanba34)
 * @version 18th of November
 */
public class SLListTest extends TestCase {

    private SLList<String> list01;
    private SLList<String> list02;
    private SLList<String> list03;
    private SLList<Integer> list04;
    private Node<Integer> one;
    private Node<Integer> two;
    private Node<String> three;

    /**
     * The setUp method for the tests for the SLList class
     */
    public void setUp() {
        list01 = new SLList<String>();
        list02 = new SLList<String>();
        list03 = new SLList<String>();
        list04 = new SLList<Integer>();
        one = new Node<Integer>(1);
        two = new Node<Integer>(2);
        three = new Node<String>("Hi");
    }


    /**
     * Testing method for the getHead in the SLList class
     */
    public void testGetHead() {
        assertEquals(list04.getHead(), null);
    }


    /**
     * Testing method for the setHead in the SLList class
     */
    public void testSetHead() {
        list04.setHead(one);
        assertEquals(list04.getHead(), one);
    }


    /**
     * Testing method for the getSize in the SLList class
     */
    public void testGetSize() {
        assertEquals(0, list01.getSize());
        assertEquals(0, list02.getSize());
        assertEquals(0, list03.getSize());
    }


    /**
     * Testing method for the getExceptions in the SLList class
     */
    public void testGetExceptions() {
        Exception exception = null;
        try {
            list01.get(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        list01.add("0");
        exception = null;
        try {
            list01.get(1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        try {
            list01.get(-2);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        try {
            list01.get(6);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Testing method for the getWorking in the SLList class
     */
    public void testGetWorking() {
        list01.add("0");
        list01.add("1");
        assertEquals("1", list01.get(1));
    }


    /**
     * Testing method for the lastIndexOf in the SLList class
     */
    public void testLastIndexOf() {
        list01.add("0");
        list01.add("0");
        list01.add("0");
        list01.add("0");
        list01.add("0");
        list01.add("0");
        list01.add("1");
        list01.add("1");

        assertEquals(7, list01.lastIndexOf("1"));
        assertEquals(5, list01.lastIndexOf("0"));
        assertEquals(-1, list01.lastIndexOf(""));
        String nullString = null;
        assertEquals(-1, list01.lastIndexOf(nullString));
    }


    /**
     * Testing method for the contains in the SLList class
     */
    public void testContains() {
        assertFalse(list01.contains(""));
        list01.add("0");
        list01.add("1");
        list01.add("2");
        list01.add("3");
        assertTrue(list01.contains("0"));
        assertFalse(list01.contains("4"));
        String nullString = null;
        assertFalse(list01.contains(nullString));
    }


    /**
     * Testing method for the isEmpty in the SLList class
     */
    public void testIsEmpty() {
        assertTrue(list01.isEmpty());
        list01.add("0");
        assertFalse(list01.isEmpty());
    }


    /**
     * Testing method for the clear in the SLList class
     */
    public void testClear() {
        list01.clear();
        list01.add("0");
        list01.add("1");
        list01.add("2");
        list01.add("3");
        assertEquals("0", list01.get(0));
        assertFalse(list01.isEmpty());
        list01.clear();
        assertTrue(list01.isEmpty());
        Exception exception = null;
        try {
            list01.get(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Testing method for the toString in the SLList class
     */
    public void testToString() {
        list01.add("0");
        list01.add("1");
        list01.add("2");
        list01.add("3");
        assertEquals("{0, 1, 2, 3}", list01.toString());
    }


    /**
     * Testing method for the addWithPosition in the SLList class
     */
    public void testAddWithPosition() {
        list01.add(0, "0");
        assertEquals("{0}", list01.toString());
        list01.add("1");
        list01.add("2");
        list01.add("3");
        list01.add("4");
        assertEquals("{0, 1, 2, 3, 4}", list01.toString());
        list01.add(0, "newValue");
        assertEquals("{newValue, 0, 1, 2, 3, 4}", list01.toString());
        list01.add(1, "newValue02");
        assertEquals("{newValue, newValue02, 0, 1, 2, 3, 4}", list01
            .toString());
    }


    /**
     * Testing the exceptions with the addWithPosition method in SLList class
     */
    public void testAddWithPositionExceptions() {
        Exception exception = null;
        try {
            list01.add(1, "");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list01.add("0");
        list01.add("1");
        list01.add("2");
        list01.add("3");
        String nullString = null;
        try {
            list01.add(1, nullString);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        exception = null;
        try {
            list01.add(-1, "");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Testing the add in the SLList class
     */
    public void testAdd() {
        String nullString = null;
        Exception exception = null;
        try {
            list01.add(nullString);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * Testing method for the remove in the SLList class
     */
    public void testRemoveWithPositionFalse() {
        assertFalse(list01.remove(1));
        assertFalse(list01.remove(-2));
        list01.add("0");
        assertFalse(list01.remove(1));
        assertFalse(list01.remove(-2));
        assertFalse(list01.remove(5));
    }


    /**
     * Testing method for the remove in the SLList class
     */
    public void testRemoveWithPositionTrue() {
        list01.add("0");
        list01.add("1");
        list01.add("2");
        list01.add("3");
        assertTrue(list01.remove(0));
        assertEquals("{1, 2, 3}", list01.toString());
        assertTrue(list01.remove(2));
        assertFalse(list01.remove(10));
    }


    /**
     * Testing method for the remove in the SLList class
     */
    public void testRemoveFalse() {
        String nullString = null;
        assertFalse(list01.remove(nullString));
        assertFalse(list01.remove("0"));
        list01.add("1");
        assertFalse(list01.remove(nullString));
        assertFalse(list01.remove("0"));
    }


    /**
     * Testing method for the remove in the SLList class
     */
    public void testRemoveTrue() {
        list01.add("0");
        assertEquals("{0}", list01.toString());
        assertTrue(list01.remove("0"));
        assertEquals("{}", list01.toString());
        list01.add("1");
        list01.add("2");
        list01.add("3");
        assertTrue(list01.remove("1"));
        assertEquals("{2, 3}", list01.toString());
        assertTrue(list01.remove("3"));
        assertEquals("{2}", list01.toString());
        list01.remove("2");
        list01.add("1");
        list01.add("2");
        list01.add("3");
        assertFalse(list01.remove("10"));
        assertTrue(list01.remove("2"));
    }


    /**
     * Testing method for the toArray in the SLList class
     */
    public void testToArray() {
        Object[] emptyArray = {};
        assertTrue(Arrays.equals(list01.toArray(), emptyArray));
        assertTrue(Arrays.equals(list01.toArray(), list02.toArray()));
        list03.add("0");
        assertFalse(Arrays.equals(list01.toArray(), list03.toArray()));
        Object[] oneItemArray = { "one thing" };
        list01.add("one thing");
        assertTrue(Arrays.equals(list01.toArray(), oneItemArray));
    }


    /**
     * Testing method for the Equals in the SLList class
     */
    public void testEquals() {
        assertTrue(list01.equals(list01));
        assertTrue(list01.equals(list02));
        list01.add("0");
        list02.add("0");
        assertTrue(list01.equals(list02));
        String nullString = null;
        String string = "";
        assertFalse(list01.equals(nullString));
        assertFalse(list01.equals(string));
        assertFalse(list01.equals(list03));
        list03.add("1");
        assertFalse(list01.equals(list03));
    }


    /**
     * Testing method for the getNextNode in the SLList class
     */
    public void testGetNextNode() {

        list01.setHead(three);

        assertEquals(list01.getNextNode(list01.getHead()), null);

        Node<String> temp3 = new Node<String>("hii");

        three.setNext(temp3);

        assertEquals(list01.getNextNode(list01.getHead()), temp3);

    }


    /**
     * Testing method for the Iterator
     */
    public void testIterator() {
        Iterator<String> iter = list01.iterator();
        assertFalse(iter.hasNext());
        Exception exception = null;
        try {
            iter.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof NoSuchElementException);

        list01.add("0");
        list01.add("1");
        iter = list01.iterator();
        assertTrue(iter.hasNext());
        assertEquals("0", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("1", iter.next());
        assertFalse(iter.hasNext());
        exception = null;
        try {
            iter.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof NoSuchElementException);
    }

    /**
     * Testing the setData in the Node class
     */
    public void testSetData() {
        one.setData(23);
        assertEquals(one.getData(), 23, .01);
    }

    /**
     * Testing the getData in the Node class
     */
    public void testGetData() {
        assertEquals(one.getData(), 1, 0.01);
    }

    /**
     * Testing the setNext in the Node class
     */
    public void testSetNext() {
        one.setNext(two);
        assertEquals(one.next(), two);
    }

    /**
     * Testing the getNext in the Node class
     */
    public void testGetNext() {
        assertEquals(one.next(), null);
    }
}