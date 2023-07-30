package sorting.other_sorting_algorthims;

public class TwoWaySorting {
    private static void twoWayMerge(int[] a,int[] b){
        int[] arr=new int[a.length+b.length];
        int aLen=a.length-1;
        int bLen=b.length-1;
        int k1=0,i1=0,j1=0,i2=aLen,j2=bLen;
        int k2=arr.length-1;
        while(i1<=aLen && j1<=bLen && i2>=0 && j2>=0){
            if(a[i1]<b[j1]){
                arr[k1]=a[i1++];
            }else{
                arr[k1]=b[j1++];
            }
            if(a[i2]>b[j2]){
                arr[k2]=a[i2--];
            }else{
                arr[k2]=b[j2--];
            }
            k1++;
            k2--;
        }
        for(int arrVal:arr){
            System.out.print(arrVal+" ");
        }
    }
    public static void main(String[] args) {
        int[] b={1,3,5,7,9};
        int[] a={10,20,30,40,50};
        twoWayMerge(a,b);
    }
}
