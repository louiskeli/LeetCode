//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 520 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        List<Integer> combina = new ArrayList<>();
        getans(candidates,ans,combina,target,0);
        return new ArrayList<>(ans);
    }

    public void getans(int[] candidates,Set<List<Integer>> ans,List<Integer> combina,int target,int idx) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combina));
            return;
        }
        if (idx == candidates.length || target < 0) return;
//        while (idx > 0 && candidates[idx] == candidates[idx - 1]) {
//            idx++;
//        }

        //使用当前位置
        combina.add(candidates[idx]);
        getans(candidates,ans,combina,target - candidates[idx],idx + 1);

        //回溯
        combina.remove(combina.size() - 1);
        getans(candidates,ans,combina,target,idx + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
