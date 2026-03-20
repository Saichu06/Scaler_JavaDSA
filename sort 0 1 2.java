// User function Template for Java

class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            if(arr[left]==1){
                if(arr[right]!=1){
                     int temp=arr[left];
                     arr[left]=arr[right];
                     arr[right]=temp;
                     left++;
                     right--;
                }
                else{
                    right--;
                }
            }
            else{
                left++;
            }
        }
    }
}
