//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 465 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        //if (head.val == val) head = head.next;
        while(q != null){
            if (q.val == val) {
                p.next = q.next;
                q = p.next;
            }else{
                p = p.next;
                q = q.next;
            }
        }
        //先进行除头结点外的节点删除，对于头结点为目标节点的情况单独进行
        if (head.val == val) head = head.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
