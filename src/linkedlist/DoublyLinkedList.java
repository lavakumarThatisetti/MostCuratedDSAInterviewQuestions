package linkedlist;

/*

HashMap ( Ky,value) =  (data, Node)

current = map.get(data)
current.prev.next = current.next;
current.next.prev = current.prev;
 */
public class DoublyLinkedList {
    
    //this Node always point to first Node 
    private Node first;
    //this Node always point to last Node 
    private Node last;
    
    public class Node {
        int data;
        Node next;
        Node prev;

        // constructor to initialize
        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    // create an empty Nodeed list 
    public DoublyLinkedList (){
        first = null;
        last = null;
    }

    //is list empty
    public boolean isEmpty(){
        return first == null;
    }

    //insert Node at the first location
    public void insertFirst(int data){
        //create a Node
        Node node = new Node(data);

        if(isEmpty()){
            //make it the last Node
            last = node;
        }else {
            //update first prev Node
            first.prev = node;
        }
        //point it to old first Node
        node.next = first;
        //point first to new first Node
        first = node;
    }

    //insert Node at the last location
    public void insertLast(int data){
        //create a Node
        Node Node = new Node(data);

        if(isEmpty()){
            //make it the last Node
            last = Node;
        }else {
            //make Node a new last Node
            last.next = Node;
            //mark old last node as prev of new Node
            Node.prev = last;
        }

        //point last to new last node
        last = Node;
    }

    //delete Node at the first location
    public Node deleteFirst(){
        //save reference to first Node
        Node tempNode = first;
        //if only one Node
        if(first.next == null){
            last = null;
        }else {
            first.next.prev = null;
        }
        first = first.next;
        //return the deleted Node
        return tempNode;
    }

    //delete Node at the last location
    public Node deleteLast(){
        //save reference to last Node
        Node tempNode = last;
        //if only one Node
        if(first.next == null){
            first = null;
        }else {
            last.prev.next = null;
        }
        last = last.prev;
        //return the deleted Node
        return tempNode;
    }

    //display the list in from first to last
    public void displayForward(){
        //start from the beginning
        Node current = first;
        //navigate till the end of the list
        System.out.print("[ ");
        while(current != null){
            //print data
            System.out.print(current.data+" ");
            //move to next item
            current = current.next;
            System.out.print(" ");
        }
        System.out.print(" ]");
        System.out.println();
    }

    //display the list from last to first
    public void displayBackward(){
        //start from the last
        Node current = last;
        //navigate till the start of the list
        System.out.print("[ ");
        while(current != null){
            //print data
            System.out.print(current.data+" ");
            //move to next item
            current = current.prev;
            System.out.print(" ");
        }
        System.out.print(" ]");
        System.out.println();
    }

    //delete a Node with given key
    public Node delete(int data){
        //start from the first Node
        Node current = first;
        //if list is empty
        if(first == null){
            return null;
        }

        //navigate through list
        while(current.data != data){
            //if it is last node
            if(current.next == null){
                return null;
            }else{
                //move to next Node
                current = current.next;
            }
        }

        //found a match, update the Node
        if(current == first) {
            //change first to point to next Node
            first = current.next;
        }else {
            //bypass the current Node
            current.prev.next = current.next;
        }

        if(current == last){
            //change last to point to prev Node
            last = current.prev;
        }else {
            current.next.prev = current.prev;
        }
        return current;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertLast(20);

        doublyLinkedList.displayForward();

        doublyLinkedList.displayBackward();

        doublyLinkedList.insertLast(30);

        doublyLinkedList.deleteFirst();
        doublyLinkedList.deleteLast();

        doublyLinkedList.displayForward();
    }
}