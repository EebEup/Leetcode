package OFFER;

public class Offer11 {
    public int minArray(int[] numbers) {
        int low =0;
        int high=numbers.length-1;
        while (low<high){
            int mid=low+(high-low)/2;
            if(numbers[mid]<numbers[high]){
                high=mid;
            }
            else if(numbers[mid]>numbers[high]){
                low=mid;
            }
            else{
                --high;
            }
        }
        return low;
    }
}
