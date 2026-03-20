class Solution {
    public void sort012(int[] arr) {
        // code here
        int low=0;
        int mid=0;
        int high=arr.length-1;
        while(mid<=high){
            //for zero
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                mid++;
                low++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;
            }
        }
    }
}