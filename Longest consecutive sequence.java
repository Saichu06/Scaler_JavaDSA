class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        // 1. Assume all are starting point 
        for(int num:nums) map.put(num,true);
        
        // 2. Consider only the valid sp
        for(int num:nums){
            if(map.containsKey(num-1)){
                map.put(num,false);
            }
        }

        // 3. Form the longest sequence
        int longest=Integer.MIN_VALUE;
        for(int num:nums){
            if(map.get(num)==true){
                int currlen=1;
                int val=num;
                while(map.containsKey(val+1)==true){
                    currlen++;
                    val++;
                }
                longest=Math.max(longest,currlen);
            }
        }

        return longest;
    }
}