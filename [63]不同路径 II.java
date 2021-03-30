//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 
// 👍 526 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //用数组ans记录到达每个位置的路径数
        int[][] ans = new int[m][n];
        //对边界进行界定，和上一题不同的是：第一行和第一列obstacleGrid位置只要出现1，那么后面ans位置全是0
        for (int i = 0 ; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            else ans[i][0] = 1;
        }
        for (int i = 0; i < n ; i++) {
            if (obstacleGrid[0][i] == 1) break;
            else ans[0][i] = 1;
        }
        //对除边界外的位置路径数进行统计：如果obstacleGrid位置上是1则表明该位置有障碍物，ans位置路径为0
        //obstacleGrid位置不为0，则ans位置等于上边的ans位置路径数加上左边的路径数
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) ans[i][j] = 0;
                else ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
            }
        }
        return ans[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
