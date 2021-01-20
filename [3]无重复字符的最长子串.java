//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4839 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //创建哈希表来判断子串是否存在重复字符
        Set<Character> set = new HashSet<>();
        //max表示当前最长不重复子串长度，right是当前的子串的最右边位置
        //right的初值需要从-1开始，这样后面while循环中才能将第一位的字符加入哈希表中
        int max = 0, right = -1;
        //i表示子串起始位置，计算出字符串每一位作为子串起点的最长不重复长度，最后选择最长的
        for (int i = 0; i < s.length(); i++) {
            //除一开始之外，其他时候需要将重复的子串起点字符从哈希表中去掉
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            //在以i位置为起点时，最右边位置不断移动，直到找到重复字符
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            //选取最长的不重复子串长度保留
            max = Math.max(max,right - i + 1);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
