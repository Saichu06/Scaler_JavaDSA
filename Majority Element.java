class Solution {
    public int majorityElement(int[] nums) {
        int candidate=0;
        int maxcount=0;
        for(int num:nums){
            if(maxcount==0){
                candidate=num;
                maxcount=1;
            }
            else if(num==candidate) maxcount++;
            else maxcount--;
        }
        return candidate;
    }
}