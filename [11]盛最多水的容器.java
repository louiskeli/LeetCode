//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2145 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        //循环整个输入数组，将组成的最大面积求出并作为最后的答案
        for (int i = 0; i < height.length; i++) {
            ans = Math.max(ans, findMax(height,i));
        }
        return ans;
    }
    //将每条线通数组剩下的线所组成的最大面积求出
    public int findMax(int[] height,int index) {
        //范围是数组第一位到index - 1
        int max1 = 0;
        for (int i = 0; i < index; i++) {
            int width = index - i;
            int high = Math.min(height[i], height[index]);
            int temp = width * high;
            max1 = Math.max(max1, temp);
        }
        //范围是index + 1 到数组最后一位
        int max2 = 0;
        for (int i = index + 1; i < height.length; i++) {
            int width = i - index;
            int high = Math.min(height[index], height[i]);
            int temp = width * high;
            max2 = Math.max(max2, temp);
        }
        //选取max1、max2中最大的数作为当前的结果输出
        return Math.max(max1, max2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
