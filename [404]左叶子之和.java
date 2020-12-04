//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 261 👎 0


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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;

        //判断树是否为空，压入根节点
        if (root == null) return sum;
        else queue.offer(root);

        //求左叶子之和
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            //当前节点的左节点为叶子节点，进行加法操作
            if (node.left != null && node.left.left == null && node.left.right == null){
                sum += node.left.val;
            }else if (node.left != null) queue.offer(node.left);//否则只要左节点不为空就加入队列

            //当前节点的右节点只要不为空就加入队列
            if (node.right != null) queue.offer(node.right);
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
