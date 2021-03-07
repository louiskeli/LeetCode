//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
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
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 983 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int k = len - 1;
        //从后往前找，找到第一个下降的位置，记为 k。注意k 以后的位置是降序的
        while (k - 1 >= 0 && nums[k - 1] >= nums[k]) {
            k--;
        }

        if (k == 0) {
            reverse(nums,0,len - 1);
        } else {
            int u = k;
            //从 k 往后找，找到最小的比 k 要大的数
            while (u + 1 < len && nums[u + 1] > nums[k - 1]) {
                u++;
            }
            //将两者交换。注意此时 k 以后的位置仍然是降序
            //直接将 k 以后的部分翻转（变为升序）
            swap(nums,k - 1,u);
            reverse(nums,k,len - 1);
        }
    }

    public void reverse(int[] nums,int a,int b) {
        int left = a,right = b;
        while (left < right) {
            swap(nums,left++,right--);
        }
    }

    public void swap(int[] nums,int a,int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
