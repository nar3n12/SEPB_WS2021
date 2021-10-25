
class Demo{
    public static boolean isGreater(int a,int b){
        if(a>b) return true;
        return false;
    }

    public static boolean opposite(boolean a){
        return !a;
    }

    public static int polynomial(int x){
        int cal = (x*x)+(3*x)-7;
        return cal;
    }

    public static double mean(int[] arr){
        int res=0;
        for(int j=0;j<arr.length;j++){
            res = res + arr[j];
        }
        return res/arr.length;
    }

    public static void main(String []args){
        System.out.println("Hell");
        int a=50,b=8;
        System.out.println("b("+b+") > a ("+a+") is "+isGreater(b,a)+"\nopposite: "+opposite(false)+ "\n" +
                "polynomial x^2+3x-7 of " +50+" is "+polynomial(50));
    }
}