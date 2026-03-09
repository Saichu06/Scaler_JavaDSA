class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list= new ArrayList<>();
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals,(a,b) -> (a[0]-b[0]));
        int[] curr=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] next=intervals[i];
            //case 1 : if the start time is greater than curr start lvl
            if(next[0]<=curr[1]){
                curr[1]=Math.max(curr[1],next[1]);
            }
            //case 2 : not overlapping
            else{
                list.add(curr);
                curr=next;
            }
        }
        list.add(curr);

        return list.toArray(new int[list.size()][2]);
    }
}