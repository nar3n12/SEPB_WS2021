package assignment4;

public class Task2 {
    public static int[] search(int[][] array, int arraySize, int x){
        int[] result = new int[2];
        if(x < array[0][0] || x > array[arraySize-1][arraySize-1]){
            return new int[0];
        }else {
            for(int i=0;i<arraySize;i++){
                if(x > array[i][arraySize-1]){
                    continue;
                }else{
                    for(int j=0;j<arraySize;j++){
                        if(x == array[i][j]){
                            result[0]=i;
                            result[1]=j;
                            return result;
                        }
                    }
                }
            }
            return new int[0];
        }
    }
    /** Main method
    public static void main(String[] args){
        int array[][] = {{10,20,30,40,50},{15,25,35,45,52},{27,29,37,48,55},{32,33,39,50,56},{32,33,39,50,60}};
        int x = 29;
        int res[] = search(array, array.length, x);
        if(res.length != 0)
            System.out.println("Found at ("+res[0]+","+res[1]+")");
        else System.out.println("Element not found");
    }
     **/
}
