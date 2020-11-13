//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 212 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        //创建哈希表，并把字符串s以空格为界形成字符串数组，每个数组单位是一个单词
        HashMap<Character,String> map = new HashMap<>();
        String [] array = s.split(" ");
        //如果pattern和字符串数组长度不相等，那么单词规律一定不存在
        if (pattern.length() != array.length) return false;
        //对pattern里的每个规律进行遍历，
        for (int i = 0; i < pattern.length(); i++){
            //哈希表中已存在key，就对其value值进行判断
            if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(array[i])) return false;
            }
            else{
                //如果哈希表中不存在key，先要进行value值的存在判断，再进行key和对应value值的加入
                if (map.containsValue(array[i])) return false;
                map.put(pattern.charAt(i),array[i]);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
