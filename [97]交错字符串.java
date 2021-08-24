//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 520 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        //字符串长度不满足加法，直接返回fasle
        if (n + m != t) {
            return false;
        }
        //定义布尔矩阵f，f[i][j]表示是s1前i位字符和s2前j位字符能否交错形成长度为n+m的s3前n+m位字符串
        //边界条件复制为true
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                //对i进行判断，如果s1的第i位（第一位序号为1）和s3第i+j-1位相等，则f[i][j]的值依赖于f[i-1][j]
                if (i > 0){
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                //j的情况同上，不同的是，此时f[i][j]的值在上一情况满足时也会取决与上一结果产生的f[i][j]
                if (j > 0){
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
                //上述两种情况的结果取或关系，最终决定f[i][j]的值
            }
        }
        return f[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
