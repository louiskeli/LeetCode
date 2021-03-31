//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 832 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //使用ans数组记录从起始左上角到当前位置的最小总和
        int [][] ans = new int[m][n];
        //对第一行和第一列的边界进行初始化
        ans[0][0] = grid[0][0];
        for (int i  = 1; i < m ; i++) {
            ans[i][0] = ans[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n ; i++) {
            ans[0][i] = ans[0][i - 1] + grid[0][i];
        }
        //对边界外的位置进行记录
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                //到ans数组当前位置的最小总和等于当前位置上方和左边的最小者加上grid该位置的数值
                ans[i][j] = ans[i - 1][j] > ans[i][j - 1] ? ans[i][j - 1] + grid[i][j] : ans[i - 1][j] + grid[i][j];
            }
        }
        //返回右下角的最终结果
        return ans[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
