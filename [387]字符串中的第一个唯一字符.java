//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 293 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        if (s == null) return -1;
        if (s.length() == 1) return 0;

        //构建哈希链表
        HashMap<Character,Integer> map = new HashMap<>();

        //第一次遍历字符串，将每个字符出现次数记录在哈希表中
        for (int i = 0; i <= s.length() - 1;i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        //第二次遍历字符串，找出第一次唯一字符
        for (int i = 0;i <= s.length() - 1;i++){
            char key = s.charAt(i);
            if (map.get(key) == 1) return i;
        }

        //找不到就返回-1
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
