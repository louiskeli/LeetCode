//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 445 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        //carry是用来得到计算结果
        int n = Math.max(a.length(),b.length()),carry = 0;
        for(int i = 0;i < n;i++){
            //a或者b，只要位数没有超出i，就将该位数加到carry上
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            //利用%和/来得到余数和进位数
            ans.append((char)(carry % 2 + '0'));
            carry /= 2;
        }

        //循环之后，carry不为零，表示还要进位，就在字符串后再加上一位"1"
        if(carry > 0){
            ans.append('1');
        }
        //倒转字符串，结果就是我们想要得到的和
        ans.reverse();

        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
