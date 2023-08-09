package linkedlist;

public class CircularLinkedList {

    //this link always point to first Link
    private Node first;

    static class Node {
        int data;
        Node next;

        // constructor to initialize
        Node(int d) {
            data = d;
        }
    }

    // create an empty linked list
    public CircularLinkedList(){
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int length() {
        int length = 0;

        //if list is empty
        if(first == null){
            return 0;
        }

        Node current = first.next;

        while(current != first){
            length++;
            current = current.next;
        }
        return length;
    }

    //insert link at the First location
    public void insertAtFirst(int data){
        //create a link
        Node node = new Node(data);
        if (isEmpty()) {
            first  = node;
            node.next = first;
        }
        else{
            Node temp = first;

            while(temp.next != first)
                temp = temp.next;

            node.next = first;

            temp.next = node;
            //point first to new first node
            first = node;
        }
    }

    public void display(){
        //start from the beginning
        Node current = first;
        //navigate till the end of the list
        System.out.print("[ ");
        if(current != null){
            while(current.next != first){
                //print data
                System.out.print(current.data+" ");
                //move to next item
                current = current.next;
                System.out.print(" ");
            }
            System.out.print(current.data+" ");
        }
        System.out.print(" ]");
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.insertAtFirst(10);
        circularLinkedList.insertAtFirst(20);
        circularLinkedList.insertAtFirst(30);

        circularLinkedList.display();
    }
}
