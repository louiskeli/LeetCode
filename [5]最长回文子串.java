//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3129 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        //构建布尔矩阵存储从i到j的字符串是否是回文串的布尔值
        boolean [][] dp = new boolean[n][n];
        //创建存放最长回文串的字符串
        String ans = "";
        //"k + 1"表示要判断的字符子串的长度
        for (int k = 0; k < n; k++) {   
            for (int i = 0; i + k < n; i++) {
                int  j = i + k;
                if (k == 0) {
                    dp[i][j] = true;
                }else if (k == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1] [j - 1]);
                }
                if (dp[i][j] && k + 1 > ans.length()) {
                    ans = s.substring(i,i + k + 1);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
