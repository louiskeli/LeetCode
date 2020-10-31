//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 748 👎 0


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
    public boolean isPalindrome(ListNode head) {
       List<Integer> list = new ArrayList<>();

       //将表中值复制到数组中
       ListNode cur = head;
       while (cur != null){
           list.add(cur.val);
           cur = cur.next;
       }

       //使用双指针判断是否回文
       int front = 0;
       int back = list.size() - 1;
       while (front < back){
           if (!list.get(front).equals(list.get(back))) return false;
           front++;
           back--;
       }
       return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
