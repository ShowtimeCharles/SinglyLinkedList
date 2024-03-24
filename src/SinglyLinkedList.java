public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;


    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("[]");
        }
        else {
            Node tempNode = head;

            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }

            System.out.print("]");
        }
        System.out.println();
    }

    public void createList(int data) {
        Node node = new Node();
        node.value = data;
        head = node;
        tail = node;
        size = 1;
    }

    public void createList(int [] array){
        if (array.length == 0){
            return;
        }
        Node node = new Node();
        node.value = array[0];
        head = node;

        Node tempNode = head;

        for (int i = 1; i < array.length; i++) {
            Node newNode = new Node();
            newNode.value = array[i];

            tempNode.next = newNode;
            tempNode = newNode;
        }

        tail = tempNode;
        size = array.length;
    }

    public void addFirst(int data) {
        if (head == null) {
            createList(data);
            return;
        }

        Node node = new Node();
        node.value = data;

        node.next = head;
        head = node;
        size++;
    }

    public void addLast(int data) {
        if (head == null) {
            createList(data);
            return;
        }

        Node node = new Node();
        node.value = data;

        tail.next = node;
        tail = node;
        size++;
    }

    public void addAtIndex(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node node = new Node();
        node.value = data;

        Node tempNode = head;

        for (int i = 0; i < index - 1; i++) {
            tempNode = tempNode.next;
        }

        node.next = tempNode.next;
        tempNode.next = node;
        size++;
    }

    public void removeFirst() {
        if (isEmpty()){
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()){
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            Node tempNode = head;

            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.next;
            }

            tempNode.next = null;
            tail = tempNode;
        }
        size--;
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        else if (index == 0) {
            removeFirst();
        }
        else if (index == size - 1){
            removeLast();
        }
        else {
            Node tempNode = head;

            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }

            tempNode.next = tempNode.next.next;

        }
        size--;
    }

    public boolean removeElement(int data) {
        if (isEmpty()){
            return false;
        }
        if (head.value == data) {
            removeFirst();
            return true;
        }
        else {
            Node tempNode = head;

            while (tempNode.next != null) {
                if (tempNode.next.value == data) {
                    if (tempNode.next == tail) {
                        tail = tempNode;
                    }
                    tempNode.next = tempNode.next.next;
                    size--;
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    public int getFirst() {
        return head.value;
    }

    public int getLast() {
        return tail.value;
    }

    public int getAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node tempNode = head;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }

        return tempNode.value;
    }

    public int indexOf(int data) {
        if (isEmpty()){
            return -1;
        }
        if (head.value == data) {
            return 0;
        }
        else {
            Node tempNode = head;

            for (int i = 0; i < size; i++) {
                if (tempNode.value == data) {
                    return i;
                }
                tempNode = tempNode.next;
            }

        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int[] toArray() {
        if (isEmpty()){
            return new int[0];
        }
        else {
            int [] array = new int[size];
            Node tempNode = head;

            for (int i = 0; i < size; i++) {
                array[i] = tempNode.value;
                tempNode = tempNode.next;
            }
            return array;
        }
    }
}