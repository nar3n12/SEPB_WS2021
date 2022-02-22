package Task3;

public class Node {
    Record record;
    Node next;

    public Node(Record record){
        this.record = record;
        this.next = null;
    }

    public Record getRecord() {
        return record;
    }

    public Node getNext() {
        return next;
    }
}
