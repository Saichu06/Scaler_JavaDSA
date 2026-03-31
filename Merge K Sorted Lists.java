/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->
        a.val-b.val);

        for(ListNode node : lists){
            if(node!=null) pq.add(node);
        }

        ListNode dummy=new ListNode();
        ListNode res=dummy;

        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            res.next=curr;
            res=res.next;

            if(curr.next!=null){
                pq.offer(curr.next);
            }
        }

        // ArrayList<Integer> ans=new ArrayList<>();
        // ListNode temp=dummy.next;
        // while(temp!=null){
        //     ans.add(temp.val);
        //     temp=temp.next;
        // }

        return dummy.next;
    }
}