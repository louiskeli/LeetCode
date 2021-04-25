//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 607 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode deleteDuplicates(ListNode head) {
        //链表本身就是空表直接返回即可
        if (head == null) return head;
        //创建一个指向表头的指针，防止整个链表在处理后是空表时无法返回
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        /判断遍历停止条件
        while (cur.next != null && cur.next.next != null) {
            //出现重复情况
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                //利用链表特性可直接跳过重复节点
                while (cur.next != null && x == cur.next.val) {
                    cur.next = cur.next.next;
                }
            }else {
                //节点不重复，继续下一个节点判断
                cur = cur.next;
            }
        }
        //返回头节点
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
