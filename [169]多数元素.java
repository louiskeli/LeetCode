//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 741 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        Map <Integer,Integer> counts = new HashMap<>();
        counts = hash(nums);

        Map.Entry<Integer,Integer> majorEntry = null;
        //遍历哈希表
        for (Map.Entry<Integer,Integer> entry : counts.entrySet()){
            if (majorEntry == null || entry.getValue() > majorEntry.getValue())
                majorEntry = entry;
        }
        return majorEntry.getKey();
    }

    public Map<Integer,Integer> hash(int [] nums){
        //构建哈希表，键为数组元素数字，键值为数字出现次数
        Map <Integer,Integer> map = new HashMap <>();
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            }
            map.put(num,map.get(num) + 1);
        }
        return map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
