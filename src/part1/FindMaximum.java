package part1;

public class FindMaximum {
    public static void main(String[] args) {
        
        int[] input = {1,100,2000,39999,20,22222,999};
        System.out.println("findMaximum => "+findMaximum(input));

    }

    public static int findMaximum(int[] a){

        int i;
        int max;

        max = a[0];
        for(i=1;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;
        
    }

}
