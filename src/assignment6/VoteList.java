package assignment6;
/**
 * REF:
 * https://www.w3schools.com/java/java_constructors.asp
 * https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
 **/
public class VoteList {
    Node head;

    public VoteList(){
        head = null;
    }

    public Node getHead(){
        return head;
    }

    public boolean add(Vote data){
        Node thisNode = new Node(data);
        Node travNode = getHead();
        if(getHead() == null) {
            head = thisNode;
            return true;
        }
        else {
            while (travNode.getNext() != null) travNode = travNode.getNext();
            travNode.next = thisNode;
        }

        if(thisNode.getNext() == null) return true;
        else return false;
    }

    public int importVotes(Vote[] dataToImport){
        int numberOfVotesImported = 0;
        for(int i=0;i<dataToImport.length;i++){
            if(add(dataToImport[i])) numberOfVotesImported++;
            else i--;
        }

        return numberOfVotesImported;

    }

    public  boolean isValid(){
        int invalidCount = 0;
        int totalCount = 0;
        Node travNode = getHead();
        while (travNode.getNext() != null){
            if(travNode.getData() == Vote.INVALID) invalidCount++;
            totalCount++;
            travNode = travNode.getNext();
        }
        if((float)invalidCount/(float)totalCount > 0.4) return false;
        else return true;
    }


    public Vote countVotes(){
        if(!isValid()) return Vote.INVALID;
        else{
            int yesCount = 0;
            int noCount = 0;
            Node travNode = getHead();
            while (travNode != null){
                if(travNode.getData() == Vote.YES) yesCount++;
                else if(travNode.getData() == Vote.NO) noCount++;
                travNode = travNode.getNext();
            }
            if(yesCount > noCount) return Vote.YES;
            else if(yesCount < noCount) return Vote.NO;
            else return Vote.INVALID;
        }
    }

    /**public static void main(String[] args){
        VoteList christmasPartyVoting = new VoteList();
        Vote[] friendVotes = {Vote.YES, Vote.YES, Vote.NO, Vote.INVALID, Vote.INVALID, Vote.NO, Vote.YES, Vote.NO};
        Vote[] familyVotes = {Vote.INVALID, Vote.YES, Vote.YES, Vote.NO};
        System.out.println(christmasPartyVoting.importVotes(friendVotes)); // returns 8
        System.out.println(christmasPartyVoting.isValid()); // returns true
        System.out.println(christmasPartyVoting.countVotes()); // returns INVALID
        System.out.println(christmasPartyVoting.importVotes(familyVotes)); // returns 4
        System.out.println(christmasPartyVoting.isValid()); // returns true
        System.out.println(christmasPartyVoting.countVotes()); // returns YES
    } **/
}
