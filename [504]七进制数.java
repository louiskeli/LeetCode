//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -107 <= num <= 107 
// 
// Related Topics 数学 
// 👍 92 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        StringBuilder str = new StringBuilder();
        if (num == 0) return "0";
        boolean flag = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            str.append(num % 7);
            num = num / 7;
        }
        if (flag) str.append('-');
        return str.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
