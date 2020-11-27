//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 注意： 
//
// 你可以假设两个字符串均只含有小写字母。 
//
// canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true
// 
// Related Topics 字符串 
// 👍 124 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();

        //第一次遍历将magazine字符串中的字符输入到哈希表中
        for (int i = 0; i < magazine.length(); i++){
            char key = magazine.charAt(i);
            if (map.containsKey(key)){
                map.put(key,map.get(key) + 1);
            }else{
                map.put(key,1);
            }
        }

        //第二次遍历将ransomNote字符串中的字符同哈希表相对应
        for (int i = 0;i < ransomNote.length(); i++){
            char key = ransomNote.charAt(i);
            if (map.containsKey(key) && map.get(key) > 0){
                map.put(key,map.get(key) - 1);
            }else{
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
