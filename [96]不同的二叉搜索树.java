//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 
// 👍 1288 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++){
            //i表示我们想要求的长度为i的子树序列
            for (int j = 1; j <= i; j++){
                //j表示子树的根节点
                nums[i] += nums[j - 1] * nums[i - j];
            }
        }
        return nums[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
