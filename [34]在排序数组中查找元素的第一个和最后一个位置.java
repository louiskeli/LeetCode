//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 885 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums.length == 0 || nums == null) {
            setArrayOfTwo(ans,-1,-1);
            return ans;
        }
        int a = 0;
        while (a < nums.length) {
            if (nums[a] == target) break;
            else a += 1;
        }
        if (a == nums.length) {
            setArrayOfTwo(ans,-1,-1);
            return ans;
        } else {
            int b = a + 1;
            while (b < nums.length && nums[b] == target) {
                b++;
            }
            setArrayOfTwo(ans,a,b - 1);
            return ans;
        }
    }

    public void setArrayOfTwo(int[] nums,int a,int b) {
        nums[0] = a;
        nums[1] = b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
