/*
Author: Nicole Hackler
Date: 11/00/2023

(Implement genericQueue using inheritance) In Section 24.5, Stacks and Queues, GenericQueue
is implemented using composition. Define a new queue clas that extends java.util.LinkedList.

** I used the code listed in listing 24.7 to test if the class worked.
*/
public class GenericQueue_using_inheritance <E> extends java.util.LinkedList <E> {
    private java.util.LinkedList<E> list = new java.util.LinkedList<>();

    /** Enqueue, adding an element to the last of the linked list **/
    public void enqueue(E e){
        list.addLast(e);
    }

    /** Dequeue. removing the first element in the linked list **/
    public E dequeue(){
        return list.removeFirst();
    }

    /** Returning the size **/
    public int getSize(){
        return list.size();
    }

    @Override
    public String toString(){
        return "Queue: " + list.toString();
    }

    /** Test program from listing 24.7 to insure the methods worked I added the getSize to the printout **/
    public static void main(String[] args){
        GenericQueue_using_inheritance<String> queue = new GenericQueue_using_inheritance<>();
        queue.enqueue("Tom"); //Adding the first element
        System.out.println("(1) " + queue);
        System.out.println(queue.getSize());

        queue.enqueue("Susan"); //Adding a second element
        System.out.println("(2) " + queue);
        System.out.println(queue.getSize());

        queue.enqueue("Kim"); //Adding a third and forth
        queue.enqueue("Michael");
        System.out.println("(3) " + queue);
        System.out.println(queue.getSize());

        System.out.println("(4) " + queue.dequeue()); //Taking the first element in out
        System.out.println("(5) " + queue.dequeue()); //Taking the now first, but second in element out
        System.out.println("(6) " + queue); //what is left in the queue
        System.out.println(queue.getSize());

    }
}
