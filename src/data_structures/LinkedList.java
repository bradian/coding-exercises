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
    public void insert(String data){
        if (head.getNext()==null){
            add(data);
        }else{
            Node temp = new Node(data);
            temp.setNext(head.getNext());
            head.setNext(temp);
        }
        
        
    }
    
    public void add(String data){
        Node next = new Node(data);
        while (current.getNext()!= null){
            current = current.getNext();
        }
        current.setNext(next);
        current = next; 
        
    }
    /**
     * This removes the last node.  
     */
    
    public void remove(){
     /*   Because this is very naive list and 
     * each node only points towards the next node (forward), current cannot
     * just be deleted.  
     */
       //first check that there is more than one node (not just head).  Head cannot be deleted.  
        if (head.getNext() != null){
            Node temp = head; 
            //find next to last 
            while(temp.getNext().getNext()!= null){
                temp = temp.getNext();
            }
            // from the next to last, set the last node to null
            temp.setNext(null);
            //the next to last is now the last.  Make it the current. 
            current = temp; 
        }
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
        list.add("Marcez");
        list.add("Kwiecień");
        list.add("Maj");
       // list.printList();
        list.remove();
       // list.printList();
        list.remove();
       // list.printList();
        list.add("Kwiecień");
       // list.printList();
        list.insert("January");
        list.printList();
    }
}
