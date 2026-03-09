class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n=arr.length;
        
        int[] leftmax=new int[n];
        int[] rightmax=new int[n];
        
        leftmax[0]=arr[0];
        rightmax[n-1]=arr[n-1];
        
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(arr[i],leftmax[i-1]);
        }
        
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(arr[i],rightmax[i+1]);
        }
        
        int totalwater=0;
        for(int i=0;i<n;i++){
            int waterlevel=Math.min(leftmax[i],rightmax[i]);
            totalwater+=(waterlevel-arr[i]);
        }
        
        return totalwater;
    }
}
