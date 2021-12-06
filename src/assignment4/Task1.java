package assignment4;

public class Task1 {
    public static int productDiagonals(int[][] array, int arraySize){
        int product = 1;
        for(int i=0;i<arraySize;i++){
             product = product * array[i][i] * array[i][arraySize-(i+1)];
        }
        if(arraySize%2 != 0)   //odd size
            return product/(array[arraySize/2][arraySize/2]);

        return product;        //even size

    }

    /**
    public static void main(String[] args){
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,7,4,2},{2,2,2,1}};
        System.out.println(productDiagonals(arr,arr.length));
    }
    **/
}
