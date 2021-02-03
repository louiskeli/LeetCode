//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2928 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //if (nums.length <= 2) return ans;
        //int n = nums.length;
        Arrays.sort(nums);
        //枚举i
        for (int i = 0; i < nums.length - 2; i++) {
            //需要和上一次枚举的数不相同
           if (i > 0 && nums[i] == nums[i - 1]) {
               continue;
           }
           //k对应的指针初始指向数组的最右端
           int k = nums.length - 1;
           int target = -nums[i];
           //枚举j
           for (int j = i + 1; j < nums.length; j++) {
               //需要和上一次枚举的数不相同
               if (j > i + 1 && nums[j] == nums[ j - 1]) {
                   continue;
               }
               //需要保证j的指针在k的左侧
               while (j < k && nums[j] + nums[k] > target) {
                   --k;
               }
               //如果指针重合，随着j后续的增加，就不会有满足i+j+k=0并且j<k的k了，可以退出循环
               if (j == k) {
                   break;
               }
               if (nums[j] + nums[k] == target) {
                   List<Integer> list = new ArrayList<>();
                   list.add(nums[i]);
                   list.add(nums[j]);
                   list.add(nums[k]);
                   ans.add(list);
               }
           }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
