package assignment5;

public class Stemmer {

    public static String[] getNGrams(String keyword,int number){
        if(keyword.length() < number){
            while(keyword.length()!=number){
                keyword = keyword+"*";
            }
            String[] result = new String[1];
            result[0] = keyword;
            return result;
        }

        int length = keyword.length()-(number-1);
        String[] array = new String[length];
        for(int i=0;i<=(keyword.length() - number);i++){
            array[i]=keyword.substring(i,i+number);
        }

        return array;
    }

    public static String[] getShared(String[] a, String[] b){
        int length = (a.length>b.length)? a.length : b.length;
        int k=0;
        String[] sharedTemp = new String[length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i].equals(b[j]))
                    sharedTemp[k++]=a[i];
            }
        }
        int actualSize = 0;
        int i=0;
        while (sharedTemp[i]!=null){
            actualSize++;
            i++;
        }
        String[] shared = new String[actualSize];
        for(i=0;i<actualSize;i++){
            shared[i] = sharedTemp[i];
        }

        return shared;
    }

    public static double getDistance(String[] a, String[] b){
        double lengthSum = a.length+b.length;
        double shared = getShared(a,b).length;
        if(shared == 0.0) return 99999.99;  //divide by zero exception
        return shared/lengthSum;
    }

    public static boolean isRelevant(String keyword, String text){
        String[] words = text.split(" ");
        String[] keywordNgrams = getNGrams(keyword,3);
        for(int i=0;i<words.length;i++){
            String[] wordNgrams = getNGrams(words[i],3);
            if(getDistance(keywordNgrams,wordNgrams) >= 0.4) return true;
        }
        return false;
    }


    public static void main(String []args){
        String[] house = getNGrams("house",3);
        String[] trousers = getNGrams("trousers",3);
        getShared(house,trousers);
        System.out.println(getDistance(house,trousers));
        System.out.println(isRelevant("house","trousers"));
        System.out.println(isRelevant("house","the house is clean"));
        String[] cat = getNGrams("cat",5);
        for(int i=0;i<cat.length;i++)
            System.out.println(cat[i]);
    }
}
