package assignment6;
/**REF:
 * https://www.w3schools.com/java/java_classes.asp
 * https://www.w3schools.com/java/java_encapsulation.asp
 * https://www.w3schools.com/java/java_encapsulation.asp
 **/


public class Node {
    Vote data;
    Node next;

    public Node(Vote vote){
        data = vote;
        next=null;
    }

    public Vote getData(){
        return data;
    }
    public Node getNext(){
        return next;
    }
}
