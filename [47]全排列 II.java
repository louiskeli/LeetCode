//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 630 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean [] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<>();

        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,ans,perm,0);
        return ans;
    }

    //定义递归函数 backtrack(idx, perm) 表示当前排列为perm,下一个待填入的位置是第idx 个位置（下标从0开始）
    public void backtrack(int[] nums,List<List<Integer>> ans,List<Integer> perm,int idx) {
        //如果idx==n，说明我们已经填完了n个位置，找到了一个可行的解，我们将perm放入答案数组中，递归结束
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        //要解决重复问题，我们只要设定一个规则，保证在填第idx个数的时候重复数字只会被填入一次即可。
        //而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」
        for (int i = 0;i < nums.length;++i) {
            //当前位置的数字用了 或者
            //回溯的时候，如果是相同的数字，然后前面的数字没有访问过，说明现在的数字要在相同的那个没有访问过的数字前面。而这种情况已经发生过了，所以continue；
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums,ans,perm,idx + 1);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
