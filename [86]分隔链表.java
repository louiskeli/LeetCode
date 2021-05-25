//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 393 👎 0


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
    public ListNode partition(ListNode head, int x) {
        //创建small链表存储比x小的节点
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        //创建large链表存储比x大于等于的节点
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        //遍历原链表，根据当前节点的x值将其存入不同（small或large链表）中
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        //将large链表最后置空
        large.next = null;
        //将两个链表连接起来并且small链表放于large前面
        small.next = largeHead.next;
        //返回smallHead之后的节点，因为当前节点为空表头
        return smallHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
