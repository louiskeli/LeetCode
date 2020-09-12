//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 271 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer("");
        int len = s.length();
        //处理字符串，将原字符串中数字和字母按顺序放入新的字符串中，并统一将字母小写化
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        //将处理后的新字符串进行逆序得到新逆序字符串
        if (sb.length() == 0) return true;
        StringBuffer sb_rev = new StringBuffer(sb).reverse();

        //改进：字符串比较只要比较一半的长度即可
        for (int i = 0;i <= sb.length() / 2;i++){
            if (sb_rev.charAt(i) != sb.charAt(i)){
                return false;
            }
        }
        return true;
        //return sb.toString().equals(sb_rev.toString());

    }
}
//leetcode submit region end(Prohibit modification and deletion)
