package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Laith Al-Masri (laith21)
 * @author Sai Balusu (saib)
 * @author Harsha Paladugu (harshanba34)
 * @version 18th of November
 * @param <E>
 *            Represents the type of object
 */
public class SLList<E> {
    
    private int size;
    private Node<E> head;

    /**
     * This is the constructor for the
     * class, where certain objects
     * get instantiated to their wanted
     * values.
     */
    public SLList() {
        size = 0;
        head = null;
    }


    /**
     * Method to the set the Head of the list
     * 
     * @param entry
     *            Represents a node
     */
    public void setHead(Node<E> entry) {
        this.head = entry;
    }


    /**
     * Method to get the head to the list
     * 
     * @return the head
     */
    public Node<E> getHead() {
        return this.head;
    }


    /**
     * This is a getter method
     * for the size of the linked
     * list.
     * 
     * @return The size of the list.
     */
    public int getSize() {
        return size;
    }


    /**
     * A method to get the object specified at the index in the linked list
     * 
     * @param position
     *            represents the index
     * @return an object found at the specified index
     */
    public E get(int position) {
        if ((position < 0) || (position >= getSize())) {
            throw new IndexOutOfBoundsException("No such index.");
        }
        Node<E> currentNode = head;
        E nodeData = null;
        for (int trace = 0; trace < getSize(); trace++) {
            if (trace == position) {
                nodeData = currentNode.getData();
            }
            currentNode = currentNode.next;
        }
        return nodeData;
    }


    /**
     * Method to get the last index of a certain object
     * 
     * @param entry
     *            represents an object
     * @return the last index of the entry
     */
    public int lastIndexOf(E entry) {
        if (entry == null) {
            return -1;
        }
        Node<E> currentNode = head;
        int index = 0;
        int lastIndex = -1;
        while (currentNode != null) {
            if ((currentNode.data).equals(entry)) {
                lastIndex = index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return lastIndex;
    }


    /**
     * Method to check if the linked list contains the object stated
     * 
     * @param entry
     *            represents an object
     * @return true if the object is found.
     */
    public boolean contains(E entry) {
        return lastIndexOf(entry) != -1;
    }


    /**
     * This method checks if the list
     * is empty.
     * 
     * @return True if the list was empty
     *         or false if it was not empty
     */
    public boolean isEmpty() {
        return (getSize() == 0);
    }

    /**
     * Method to clear the whole linked list
     */
    public void clear() {
        if (!isEmpty()) {
            size = 0;
            head = null;
        }
    }


    /**
     * Method to add a object to a curtain position in the linked list
     * 
     * @param position
     *            represents the index
     * @param entry
     *            represents an object
     */
    public void add(int position, E entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null entry");
        }
        if (position > getSize() || position < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        if (isEmpty()) {
            head = new Node<E>(entry);
        }
        else if (position == 0) {
            Node<E> node = new Node<E>(entry);
            node.setNext(head);
            head = node;
        }
        else {
            Node<E> currentNode = head;
            for (int index = 0; index < getSize(); index++) {
                if ((index + 1) == position) {
                    Node<E> nextNext = currentNode.next;
                    Node<E> node = new Node<E>(entry);
                    currentNode.setNext(node);
                    node.setNext(nextNext);
                }
            }
        }
        size++;
    }


    /**
     * Method to just add the object stated to the end of the linked list
     * 
     * @param entry
     *            represents an object
     */
    public void add(E entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null entry");
        }
        if (isEmpty()) {
            head = new Node<E>(entry);
        }
        else {
            Node<E> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next();
            }
            currentNode.setNext(new Node<E>(entry));
        }
        size++;
    }


    /**
     * Method to remove a object from the specified index in the linked list
     * 
     * @param position
     *            represents the index
     * @return true if the object has been removed
     */
    public boolean remove(int position) {

        if (isEmpty()) {
            return false;
        }
        if (position < 0) {
            return false;
        }
        if (position >= getSize()) {
            return false;
        }
        if (position == 0) {
            head = head.next;
            size--;
            return true;
        }
        else {
            Node<E> currentNode = head;
            for (int index = 0; index < getSize(); index++) {
                if ((index + 1) == position) {
                    currentNode.setNext(currentNode.next.next);
                    size--;
                }
                currentNode = currentNode.next;
            }
        }
        return true;
    }


    /**
     * Method to remove a specify object from the linked list
     * 
     * @param entry
     *            represents an object
     * @return true if the object has been removed
     */
    public boolean remove(E entry) {
        if ((entry == null) || (isEmpty())) {
            return false;
        }
        Node<E> currentNode = head;
        if ((currentNode.data).equals(entry)) {
            head = head.next;
            size--;
            return true;
        }

        while (currentNode.next != null) {
            if ((currentNode.next.data).equals(entry)) {
                if (currentNode.next.next == null) {
                    currentNode.setNext(null);
                }
                else {
                    currentNode.setNext(currentNode.next.next);
                }
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }


    /**
     * Method to create a array of the linked list
     * 
     * @return an array
     */
    public Object[] toArray() {
        Object[] newArray = new Object[getSize()];
        Node<E> currentNode = head;
        int trace = 0;
        while (currentNode != null) {
            newArray[trace] = currentNode.getData();
            currentNode = currentNode.next;
            trace++;
        }

        return newArray;
    }


    /**
     * Method to return a String with all the object in the linked list
     * 
     * @return a string
     */
    public String toString() {
        String string = "{";
        Node<E> currentNode = head;
        while (currentNode != null) {
            string = string + currentNode.data;
            currentNode = currentNode.next;
            if (currentNode != null) {
                string = string + ", ";
            }
        }
        string = string + "}";
        return string;
    }


    /**
     * Method to check if the linked lists are the same
     * 
     * @param object
     *            represents an object
     * @return true if both objects are equal
     */
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            @SuppressWarnings("unchecked")
            SLList<E> other = ((SLList<E>)object);
            if (other.getSize() == getSize()) {
                Node<E> currentNode = head;
                Node<E> otherCurrent = other.head;
                while (currentNode != null) {
                    if (!currentNode.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    currentNode = currentNode.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }
        return false;
    }


    /**
     * Method to call the iterator class
     * 
     * @return an iterator object
     */
    public Iterator<E> iterator() {
        return new SLListIterator<E>();
    }


    /**
     * Method to get the next node from the current node in the linked list
     * 
     * @param currentNode
     *            represents the current node
     * @return a node object
     */
    public Node<E> getNextNode(Node<E> currentNode) {
        if (currentNode.next != null) {
            return currentNode.next;
        }
        return null;
    }

    /**
     * This is a Node class that is built in
     * the SLList class.
     * 
     * @author laithalmasri
     * @version 14th of November
     * 
     * @param <E>
     *            Represents the type of object in which
     *            the class will be storing.
     */
    public static class Node<E> {
        private Node<E> next;
        private E data;

        /**
         * This is the constructor
         * for the Node class, where
         * it creates a new node and
         * provides it with the wanted
         * data.
         * 
         * @param info
         *            Represents the
         *            data of the node.
         */
        public Node(E info) {
            data = info;
        }


        /**
         * This is a getter method
         * that gets the next node.
         * 
         * @return The next node.
         */
        public Node<E> next() {
            return next;
        }


        /**
         * This is a setter method
         * that sets the next node
         * to the wanted node.
         * 
         * @param nextNode
         *            Represents the node
         *            that will be set as next.
         */
        public void setNext(Node<E> nextNode) {
            next = nextNode;
        }


        /**
         * This is a getter method for
         * the data of the node.
         * 
         * @return The data if the node.
         */
        public E getData() {
            return data;
        }


        /**
         * 
         * This is a setter method for
         * the data of the node.
         * 
         * @param entry
         *            represents an object
         */
        public void setData(E entry) {
            this.data = entry;
        }

    }


    /**
     * 
     * @authors Laith Al-Masri (laith21), Sai Balusu (saib), Harsha Palagu
     * @version 18th of November
     *
     *
     * @param <A>
     */
    private class SLListIterator<A> implements Iterator<E> {

        private Node<E> next;
        private int index;

        /**
         * Creates a new DLListIterator
         */
        public SLListIterator() {
            next = head;
            index = 0;
        }


        /**
         * Method to check if another element exists or not
         * 
         * @return if there is a element next or not
         */
        public boolean hasNext() {
            return (index < getSize());
        }


        /**
         * Method to get the next element in linked list
         * 
         * @return The next element in the list
         */
        public E next() {
            if (hasNext()) {
                index++;
                E temp = next.getData();
                next = next.next();
                return temp;
            }
            throw new NoSuchElementException("No more nodes.");
        }

    }
}