class Solution {
    public ListNode doubleIt(ListNode head) {
        
        head = reverse(head);

        ListNode curr = head;
        int carry = 0;

        while(curr != null){
            int sum = curr.val * 2 + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            
            if(curr.next == null) break;
            curr = curr.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}