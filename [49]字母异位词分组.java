//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 685 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] vis;
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for (String str : strs) {
            //对字符串数组中每个字符串进行排序，如果排完序之后的字符串相同则说明是字母异位词
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String (array);
            //建立哈希表，key为排完序的字符串，values为字母异位词分组
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key,list);
            }else {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key,list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
