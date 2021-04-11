package Service;

import java.util.*;


public class ListnerClassTest {

    Node head;
      class Node {
          Node next;
          int data ;

          Node (int d ){ data=d ; next=null;}
      }
       public void pushElement(int d )
       {
           Node new_node=new Node(d);
           new_node.next=head;
           head=new_node;
       }

       public int countNumber(Node Head){
          int count=0;
          while(head !=null) {
              head=head.next;
              count++;
          }
          return count;
       }
       public boolean isElement(Node Head, int n){
          Node temp=Head ;
          while(temp.next !=null)
          {
              if(temp.data==n)
                  return true;
              temp=temp.next;
          }
          return false;
       }

       public boolean isCircle(Node Head){
          Node temp=Head;
          HashSet<Node> h1= new HashSet<>();
          while(temp!=null)
          {
              if(h1.contains(temp))
                  return true;
              h1.add(temp);
              temp=temp.next;
          }
          return false;
       }

       public int countInLoop(Node slowPointer)
       {
           int count=0;
           Node temp=slowPointer;
           while(temp.next!=slowPointer)
           {
               temp=temp.next;
               count++ ;
           }
           return count;
       }

       public boolean Palidrome(Node head)
       {
           Stack<Node> s1= new Stack<>();
           while(head != null) {
               s1.push(head);
               head=head.next;
           }

       }




}