//给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。 
//
// 示例 1: 
//
// 
//输入: [3, 2, 1]
//
//输出: 1
//
//解释: 第三大的数是 1.
// 
//
// 示例 2: 
//
// 
//输入: [1, 2]
//
//输出: 2
//
//解释: 第三大的数不存在, 所以返回最大的数 2 .
// 
//
// 示例 3: 
//
// 
//输入: [2, 2, 3, 1]
//
//输出: 1
//
//解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
//存在两个值为2的数，它们都排第二。
// 
// Related Topics 数组 
// 👍 189 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        //int [] sort = new int[3];
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        //int [] sort = new int[]{-2147483648,-2147483648,-2147483648};
        //int count = 0;

        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int n : nums){
            if (n > firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = n;
            }
            //跳过重复的
            else if (firstMax == n) continue;
            else if (n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            }
            //层层递进判断，不需要考虑前面的是否重复
            else if (secondMax == n) continue;
            else if (n > thirdMax) {
                thirdMax = n;
            }
        }
        //直接判断第三大是否改变
        return thirdMax == Long.MIN_VALUE ? (int) firstMax : (int) thirdMax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
