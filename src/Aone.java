public class Aone {

/**part 1
 * task 1:  public static int countSheep(int legs)
 * task 2:  public static int furColourRatio(int black,int white)
 * task 3:  public static boolean canFeed(int sheep,float hay)
 * task 4:  public static float calculateSales(int sheep,float value)
 * **/

//part 2
  //task 1

    public static int herdDivisors(int sheep){
        int result = 2; //by itself and by 1
        for(int i=2;i<sheep;i++){
           if(sheep%i == 0) result++;
        }
        return result;
    }



    //task 2
    public static boolean isPrime(int num){
        for(int i=2;i<num;i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    public static String getColourByID(int id){
        String color;
        if(id%3 == 0) color = "black";
        else if(id%5 == 0) color = "brown";
        else if(isPrime(id)) color = "lucky";
        else color = "white";
        return color;
    }

    public static void main(String []args){
        int a = 2*(-1);
        int sheep = 24;
        System.out.println("sheep: "+sheep+"herd divisor: "+herdDivisors(sheep));
        System.out.println("sheepColor: "+getColourByID(1001));
    }
}
