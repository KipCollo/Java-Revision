package datastructures.collections.array;

public class Demo {

    public static void main(String[] args){

        int[] nums ={1,3,5,6,8,9};
        int target=6;

        int result = linearSearch(nums, target);

        if(result != -1)
            System.out.println("Index of result is at index: " + result);
        else
            System.out.println("Result not found");
    }

    public static int linearSearch(int[] nums, int target) {
       
       for (int i=0; i< nums.length;i++){
        if(nums[i]==target)
            return i;
       }
    
       return -1;
    }

}
