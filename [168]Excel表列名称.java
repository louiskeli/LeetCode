//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 268 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int n) {
        //StringBufferd 空串创建格式
        StringBuffer s = new StringBuffer();
        while (n > 0){
            int m = n % 26;
            //A在ascall表上为65，对应于64+1
            if (m == 0) m = 26;
            char letter = (char)(m + 64);
            s.append(letter);
            n = (n - m) / 26;
        }
        //将s串倒置并创建string类型字符串
        return new String (s.reverse());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
