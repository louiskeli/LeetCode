//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 759 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listSum = new ArrayList<List<Integer>>();
        //对数组进行排序
        Arrays.sort(nums);
        //排除数组长度小于4或数组为空的特殊情况
        if(nums.length < 4 || nums == null) return listSum;

        int len = nums.length;
        for(int i =  0 ; i < len - 3; i++) {
            //对第一个数进行确定，同时跳过重复的数字防止出现重复输出
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if(nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
            for(int j = i + 1; j < len - 2; j++) {
                //对第二个数进行确定，同时跳过重复的数字防止出现重复输出
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if(nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;
                //对剩下的两个数进行确定，采用双指针的方法
                int left = j + 1,right = len - 1;
                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        //使用Arrays.asList快速创建并赋值数组
                        listSum.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //对双指针进行移动并且跳过重复的数字
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    }else if(sum > target) {
                        right--;
                    }else {
                        left++;
                    }
                }
            }
        }
        return listSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
