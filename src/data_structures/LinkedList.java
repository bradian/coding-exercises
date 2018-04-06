/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

/**
 *
 * @author ian
 */
public class LinkedList {
    
    private final Node  head; 
    private Node current; 

    public LinkedList(Node head) {
        this.head = head;
        current = head; 
    }
    
    public void add(String data){
        Node next = new Node(data);
        while (current.getNext()!= null){
            current = current.getNext();
        }
        current.setNext(next);
        current = next; 
        
    }
    
    public void printList(){
        Node n = head; 
        do{
            System.out.println(n.getData());
            n = n.getNext();
        }while(n != null);
    }
    
     
    
     public static void main(String args[]){
        LinkedList list = new LinkedList(new Node ("Styczeń"));
        //list.printList();
        list.add("Luty");
        list.printList();
    }
}
