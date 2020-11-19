//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 124 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        char[] st = s.toCharArray();
        int low = 0;
        int high = st.length - 1;
        while (low < high){

            if (!vowel.contains(st[low] + "")){
                low++;
                continue;
            }
            if (!vowel.contains(st[high] + "")){
                high--;
                continue;
            }
            char temp = st[low];
            st[low] = st[high];
            st[high] = temp;
            low++;
            high--;
        }
        return String.valueOf(st);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
