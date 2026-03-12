class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<arr.length;i++) result.add(-1);
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()) result.set(i,arr[st.peek()]);
            st.push(i);
        }
        return result;
    }
}