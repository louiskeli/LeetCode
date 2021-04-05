//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 417 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //使用两次二分法在目标矩阵中查找target'
        int idxRow = idxFind(matrix,target);
        if (idxRow < 0) return false;
        return midFind(matrix,idxRow,target);
    }

    //二分法查找target可能在的行
    public int idxFind(int[][] matrix,int target) {
        int low = -1;
        int high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target)
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }

    //在目标行里使用二分法查找target
    public boolean midFind(int[][] matrix,int idxRow,int target) {
        int left = 0;
        int right = matrix[idxRow].length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (matrix[idxRow][mid] == target) return true;
            else if (matrix[idxRow][mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
