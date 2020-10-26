//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 209 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //利用哈希表遍历数组 将第一次遇到的数和所处位置索引插入哈希表中
        //对于已存在的数字，将索引和哈希表中的索引相减取绝对值，最后和k进行比较
        //对于满足差值小于k的，可以直接输出true，结束程序
        //对于差值不满足小于k的，将索引值进行更新覆盖，继续向后遍历
        //遍历完数字都没有满足条件，则输出false
        Map <Integer,Integer> map = new HashMap<>();
        //boolean tag = false;
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    //tag = true;
                   // map.put(nums[i],i);
                    //return tag;
                    return true;
                }
                else {
                    //tag = false;
                    map.put(nums[i],i);
                }
            }else map.put(nums[i],i);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
