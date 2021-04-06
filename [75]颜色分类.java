//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 835 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        //创建三个变量分别表示数组中012的个数
        int red = 0, white = 0, blue = 0;
        //遍历数组，统计三个数的个数
        for (int i = 0 ; i < nums.length; i++) {
            switch (nums[i]){
                case 0:
                    red += 1;
                    break;
                case 1:
                    white += 1;
                    break;
                case 2:
                    blue += 1;
                    break;
            }
        }
        //依据三个数字的个数将数字按要求的顺序依次填入
        int idx = -1;
        for (int i = red; i > 0; i--) {
            idx++;
            nums[idx] = 0;
        }
        for (int i = white; i > 0; i--) {
            idx++;
            nums[idx] = 1;
        }
        for (int i = blue; i > 0; i--) {
            idx++;
            nums[idx] = 2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
