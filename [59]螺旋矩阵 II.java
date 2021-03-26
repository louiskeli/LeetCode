//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 398 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int num_max = n * n;
        int [][] ans = new int[n][n];
        int left = 0,right = n - 1,top = 0,bottom = n - 1;
        int number = 1;
        while (left <= right && top <= bottom) {
            //这里规定循环截止为i<=right，不然可能最后一个位置，也就是left=right、top=bottom的位置遍历不到
            for (int i = left; i <= right; i++) {
                ans[top][i] = number;
                number++;
                if (number > num_max) break;
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans[i][right]=number;
                number++;
                if (number > num_max) break;
            }
            //再次判断一次，不然可能在最后一层（例如只剩一行）时会返回导致重复添加上一层的元素
            if (left < right && top < bottom){
                for (int i = right - 1; i > left; i--) {
                    ans[bottom][i] = number;
                    number++;
                    if (number > num_max) break;
                }
                for (int i = bottom; i > top ; i--) {
                    ans[i][left] = number;
                    number++;
                    if (number > num_max) break;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        //ans[n][n] = num_max;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
