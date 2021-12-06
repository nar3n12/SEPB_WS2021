public class Passenger {
    public static int[] queue(int[] position){
        int temp=0;
        for(int i=0; i< position.length; i++)
        {
            for(int j=0; j< position.length-1; j++)
            {
                if(position[j+1]<position[j])
                {
                    temp=position[j+1];
                    position[j+1]=position[j];
                    position[j]=temp;
                }
            }
        }
        return position;
    }

    public static void main(String[] args){
        int arr[]={2,1,3,7,5,6,8,88,74};
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
        queue(arr);
        System.out.println("-----");
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);

    }
}
