/**
 * @author xiaodp
 * @date 2019/11/16 23:11
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = (l1.val < l2.val) ? l1:l2;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 !=null && p2 != null){
            if(p1.val < p2.val){
                res.next = p1;
                p1 = p1.next;
            }else{
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
        }
        if(p1 == null) res.next = p2;
        if(p2 == null) res.next = p1;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);

        ListNode L1 = new ListNode(1);
        ListNode L2 = new ListNode(2);
        ListNode L3 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        L1.next = L2;
        L2.next = L3;
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        mergeTwoLists.mergeTwoLists(l1,L1);
    }
}
