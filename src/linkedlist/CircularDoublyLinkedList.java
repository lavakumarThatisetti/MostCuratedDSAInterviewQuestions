package linkedlist;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class CircularDoublyLinkedList {
    Node head;
    Node tail;

    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Insert a new node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }

    // Delete the last node from the list
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) {
            head = null;
            tail = null;
        } else {
            Node last = tail;
            Node secondLast = last.prev;
            secondLast.next = head;
            head.prev = secondLast;
            tail = secondLast;
        }
    }

    // Delete the first node from the list
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) {
            head = null;
            tail = null;
        } else {
            Node second = head.next;
            Node last = tail;
            second.prev = last;
            last.next = second;
            head = second;
        }
    }

    // Display the elements of the circular doubly linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        System.out.println("Circular Doubly Linked List:");
        list.display();

        list.deleteAtEnd();

        System.out.println("After deleting at the end:");
        list.display();

        list.deleteAtBeginning();

        System.out.println("After deleting at the beginning:");
        list.display();
    }
}
