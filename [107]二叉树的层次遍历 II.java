//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 293 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //对二叉树为空的情况进行处理，直接返回空链表
        if (root == null) return new ArrayList();

        //分别创建队列、链表、和栈
        Queue <TreeNode> q = new LinkedList <>();
        List <List<Integer>> out = new ArrayList<>();
        Stack <List<Integer>> stack = new Stack<>();

        //在非空树时将根节点加入队列
        q.offer(root);
        int count ;

        //只要队列不为空，表明树的节点还没有添加完成，就继续循环
        while(!q.isEmpty()){
            //count用来统计队列大小，此处表示上一层的节点数
            count = q.size();
            //创建小链表
            List <Integer> list = new ArrayList<>();

            //对每层节点进行子节点的添加，并将每层节点值加入小链表list中
            while (count > 0){
                TreeNode ret = q.poll();
                list.add(ret.val);
                if (ret.left != null) q.offer(ret.left);
                if (ret.right != null) q.offer(ret.right);
                count--;
            }
            //将小链表压入栈中，每个小链表为一个单位
            stack.add(list);
        }

        //将栈中的单位加入大链表中，注意大链表和小链表的数据结构不同，大链表和栈的数据结构相同
        while(!stack.isEmpty()){
            out.add(stack.pop());
        }
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
