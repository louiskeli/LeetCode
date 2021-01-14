//给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个
//比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。 
//
// 示例 2: 
//
// 输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// nums1和nums2中所有元素是唯一的。 
// nums1和nums2 的数组大小都不超过1000。 
// 
// Related Topics 栈 
// 👍 341 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //建立栈进行nums2数组的下一个元素比较
        Stack<Integer> stack = new Stack<>();
        //建立nums2中每个元素的下一个更大元素的链表
        HashMap<Integer,Integer> map = new HashMap<>();

        int [] out = new int[nums1.length];
        //建立哈希映射
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        //栈中剩余元素没有下一个更大元素，映射为-1
        while (!stack.empty()) {
            map.put(stack.pop(),-1);
        }
        //遍历目标子数组
        for (int i = 0; i < nums1.length; i++) {
            out [i] = map.get(nums1[i]);
        }
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
