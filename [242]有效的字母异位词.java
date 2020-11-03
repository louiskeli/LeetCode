//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 269 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        //判断两字符串长度是否相等，不相等返回false
        if (s.length() != t.length()) return false;

        //将两个字符转化为字符类型的数组
        char [] str1 = s.toCharArray();
        char [] str2 = t.toCharArray();

        //将字符串转换好的数组进行排序
        Arrays.sort(str1);
        Arrays.sort(str2);

        //比较排序好的数组，不相等就返回false，相等则返回true
        return Arrays.equals(str1,str2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
