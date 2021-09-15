package cPractice;
import java.text.ParseException;
import java.util.LinkedList;

public class nthNodeLinkedList {

    Node head;
    public class Node{
        Node next;
        int data;
           Node(int d){
                       this.data=d;
                       next=null;
                      }
    }

    public void push(int new_data)
    {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    public void reverseList(Node head){
        Node temp=null;
        Node prev=null;
        Node current=head;

        while (current!=null){
            temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
    }

    public int nthNode(int index){

        Node current=head;
        int count=1;

        while(current!=null){
            if(count==index)
                return current.data;
            current=current.next;
            count++;
        }
      return 0;
    }

    public static void main(String args[]) throws ParseException {
        nthNodeLinkedList llist=new nthNodeLinkedList();
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(5);

        System.out.println("list is "+llist.nthNode(3));

    }
}
