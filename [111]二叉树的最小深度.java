//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 355 👎 0


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
    //定义节点队列类--并不是队列
    class QueueNode{
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node,int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    public int minDepth(TreeNode root){
            if (root == null) return 0;
            Queue<QueueNode> queue = new LinkedList<>();
            queue.offer(new QueueNode(root,1));
            while (!queue.isEmpty()){
                QueueNode nodeDepth = queue.poll();
                TreeNode node = nodeDepth.node;
                int depth = nodeDepth.depth;
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(new QueueNode(node.left,depth + 1));
                }
                if (node.right != null){
                    queue.offer(new QueueNode(node.right,depth + 1));
                }
            }
            return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
