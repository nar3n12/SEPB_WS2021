package Task3;

public class List {

    Node head;


    public static double calculateTotal(List list){

        double total = 0;

        if(list.head != null){
            Node last = list.head;
            while (last.next != null){
                total += (last.record.prize * last.record.amount);
                last = last.next;
            }
        }


        return total;
    }

    public static List splitByType(List list,ProductType type){

        List newlist = new List();
        if(list.head != null){
            Node last = list.head;
            Node prev = null;

            while (last.next != null) {
                if(last.record.productType == type){
                    insert(newlist,last.record);
                    if(prev!=null)
                    prev.next = last.next;
                }else prev = last;
                //prev = last;
                last = last.next;

            }


        }

        return newlist;
    }

    public static List merge(List alist,
                              List blist) {
        if (alist.head == null) {
            return blist;
        }
        else if(blist.head == null){
            return alist;
        }
        else{
            Node lastB = blist.head;

            while (lastB.next != null) {
                insert(alist,lastB.record);
                lastB = lastB.next;
            }


        }

        return alist;
    }

    public static void print(List list){
        Node last = list.head;
        if(list.head != null){
            while (last.next != null){
                System.out.println(last.record.name+" "+last.record.prize+"$ x"+last.record.amount+" "+last.record.productType);
                last = last.next;
            }
            System.out.println(last.record.name+" "+last.record.prize+"$ x"+last.record.amount+" "+last.record.productType);
        }
    }

    public static List insert(List list,
                                    Record record)
    {
        // Create a new node with given record
        Node new_node = new Node(record);
        boolean skipFlag = false;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                if(last.record.name != new_node.record.name)
                    last = last.next;
                else{
                    last.record.amount += new_node.record.amount;
                    skipFlag = true;
                    break;
                }
            }

            // Insert the new_node at last node
            if(!skipFlag)
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

     public static void main(String[] args){
        List WestMarketList = new List();
        Record MBanana = new Record("MBanana",0.99,24,ProductType.FOOD);
        insert(WestMarketList,MBanana);
        Record MSoda = new Record("MSoda", 1.27, 38, ProductType.BEVERAGES);
        insert(WestMarketList,MSoda);
        Record FWater = new Record("Fwater",2.58,150,ProductType.BEVERAGES);
        insert(WestMarketList,FWater);
        Record GGlue = new Record("GGlue",4.99,66,ProductType.NONFOOD);
        insert(WestMarketList,GGlue);
        System.out.println("\nWest Market List:");
        print(WestMarketList);

        List EastMarketList = new List();
         Record MSoda1 = new Record("MSoda", 1.27, 42, ProductType.BEVERAGES);
         insert(EastMarketList,MSoda1);
         Record pstew = new Record("PStew",2.99,51,ProductType.FOOD);
         insert(EastMarketList,pstew);
         System.out.println("\nEast Market List:");
         print(EastMarketList);

        merge(WestMarketList,EastMarketList);
         System.out.println("\nWest Market List:");
         print(WestMarketList);

        List BeverageList = new List();
        BeverageList = splitByType(WestMarketList,ProductType.BEVERAGES);
         System.out.println("\nWest Market List:");
         print(WestMarketList);
         System.out.println("\nBeverage List:");
         print(BeverageList);

         calculateTotal(WestMarketList);
         calculateTotal(EastMarketList);
         calculateTotal(BeverageList);


     }

}
