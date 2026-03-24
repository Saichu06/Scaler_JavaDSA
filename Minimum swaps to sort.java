class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[]) {
        // Code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        
        int[] temp=arr.clone();
        Arrays.sort(temp);
        
        int swaps=0;
        
        for(int i=0;i<arr.length;i++){
            if(temp[i]!=arr[i]){
                int ind=map.get(temp[i]);
                
                int tempo=arr[i];
                arr[i]=arr[ind];
                arr[ind]=tempo;
                
                map.put(arr[ind],ind);
                map.put(arr[i],i);
                
                swaps++;
            }
        }
        
        return swaps;
    }
}