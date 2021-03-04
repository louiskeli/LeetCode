//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1594 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans,StringBuilder cur,int open,int close,int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            //左括号数量不能超过n
            cur.append('(');
            backtrack(ans,cur,open + 1,close,max);
            //去掉cur的最后一个多余位置，因为我们此时已经加了一个位置
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close< open) {
            //右括号的数量小于左括号时可以增加一个右括号
            cur.append(')');
            backtrack(ans,cur,open,close + 1,max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
