package linkedlist;


/*
Traverse back

Hashmap ( Current, PrevAddress)
(1000, null)
(1002, 1000)
(1004, 1002)

 */




public class SingleLinkedList {
    Node head; // head

    // Linked list Node
    class Node {
        int data;
        Node next;

        // constructor to initialize
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public Node insertAtBeginning(int data) {
        // Using constructor to create memory and value assignment
        Node new_node = new Node (data);
        // current head becomes this new_node's next
        new_node.next = head;

        // changing head to this newly created node
        head = new_node;

        return head;
    }
    public void insertAtEnd(int data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_node;
        }
        else {
            // Else traverse till the last node and insert the new_node there
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }
    }

    public void deleteFromBeginning() {
        if (head == null)
        {
            System.out.println ("List is empty, not possible to delete");
            return;
        }

        System.out.println ("Deleted: " + head.data);
        // move head to next node
        head = head.next;
    }

    public void deleteFromEnd() {
        if (head == null)
        {
            System.out.println ("List is empty, not possible to delete");
            return;
        }

        System.out.println ("Deleted: " + head.data);
        // move head to next node
        Node last = head;
        while (last.next.next != null) {
            last = last.next;
        }
        // Insert the new_node at last node
        last.next = null;
    }
    public void deleteByKey(int key) {
        // Store head node
        Node currNode = head, prev = null;
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currNode != null && currNode.data == key) {
            head = currNode.next; // Changed head

            // Display the message
            System.out.println(key + " found and deleted");
        }
        // CASE 2:
        // If the key is somewhere other than at head

        // Search for the key to be deleted, keep track of the previous node as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode Unlink currNode from linked list
            prev.next = currNode.next;
            // Display the message
            System.out.println(key + " found and deleted");
        } else{
            // CASE 3: The key is not present
            // If key was not present in linked list currNode should be null
            System.out.println(key + " not found");
        }
    }

    public void display () {
        Node node = head;
        //as linked list will end when Node reaches Null
        while (node != null)
        {
            System.out.print (node.data + " , ");
            node = node.next;
        }
        System.out.println ();
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        l1 = head;
        l2 = head;
        Node L3 = new Node(0);
        Node curr=L3;
        int carry=0;
        while(l1!=null || l2!=null){
            int x=(l1!=null)?l1.data:0;
            int y=(l2!=null)?l2.data:0;
            int sum =carry+x+y;
            carry=sum/10;
            curr.next=new Node(sum%10);

            curr=curr.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry>0){
            curr.next =new Node(carry);
        }
        return L3.next;
    }

    public static void main(String[] args) {
        SingleLinkedList listObj = new SingleLinkedList();

        listObj.insertAtBeginning (2);
        listObj.insertAtBeginning(4);
        listObj.insertAtBeginning(6);
//        listObj.insertAtEnd(10);
//        listObj.insertAtEnd(5);

        listObj.display ();

//        listObj.deleteFromBeginning();
//        listObj.deleteByKey(15);

        listObj.display ();

        listObj.addTwoNumbers(null, null);
    }
}