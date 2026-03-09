// User function Template for Java

class Solution {
    static String getSmallest(Long N) {
        // code here
        if (N == 0) return "10";
        if (N == 1) return "1";
        StringBuilder sb=new StringBuilder();
        int[] arr=new int[10];
        int counter=9;
        for(int i=9;i>=2;i--){
            while(N%i==0){
                arr[i]++;
                N=N/i;
            }
        }
        
        if (N != 1) {
            return "-1";
        }
        
        for(int i=2;i<10;i++){
            while(arr[i]-->0){
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
};