// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        map.put(0,-1);
        int prefixSum=0;
        int maxlen=0;
        for(int i=0;i<n;i++){
            prefixSum+=arr[i];
            if (prefixSum == k) 
                maxlen = i + 1;
            else if(map.containsKey(prefixSum-k)){
                int length=i-map.get(prefixSum-k);
                maxlen=Math.max(maxlen,length);
            }
            else{
                map.put(prefixSum,i);
            }
        }
        return maxlen;
    }
}
