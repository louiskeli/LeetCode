//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 547 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return ans;
    }

    public void dfs(int curr,int n, int k) {
        //剪枝：list长度加上区间[curr,n]的长度小于k，不可能构造出长度为k的list
        if (list.size() + (n - curr + 1) < k) return;
        //记录合法的答案
        if (list.size() == k) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        //考虑选择当前位置
        list.add(curr);
        dfs(curr + 1,n,k);
        //回溯
        list.remove(list.size() - 1);
        //考虑不选择当前位置
        dfs(curr + 1,n,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
