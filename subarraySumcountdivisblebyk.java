import java.util.*;
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        int sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=((sum%k)+k)%k;
            if(map.containsKey(mod)){
                count+=map.get(mod);
            }
            map.put(mod,map.getOrDefault(mod,0)+1);
            
        }
        return count;
    }
}