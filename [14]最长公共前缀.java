//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1256 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans ;
        if(strs.length==0||strs[0].length()==0){
            ans = "";
        }else{
            ans = strs[0];
        }
        a:
        for (int i = 1;i<strs.length;i++){
            if(strs[i].length()==0||ans.length()==0){
                ans = "";
                break a;
            }
            int count ;
            if(ans.length() <= strs[i].length()){
                count = ans.length();
            }else{
                count = strs[i].length();
            }

            int j = 0;

            if (ans.charAt(j)!= strs[i].charAt(j)){
                ans = "";
                break a;
            }
            b:
            for(j=1;j<count;j++){
                if(ans.charAt(j)!= strs[i].charAt(j)){
                    break b;
                }
            }
            ans = strs[i].substring(0,j);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
