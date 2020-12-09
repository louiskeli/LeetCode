//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 248 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        //首先定义一个整形数组长度为58，因为'A' = 65 ; 'a' = 97, 这之间就32个字符,还要加上'a' -- 'z' 所以是32 + 26
        int[] target = new int[32+26];
        //然后判断每个字符的个数
        char[] chars = s.toCharArray();
        for (char c : chars) {
            target[c - 'A'] += 1;
        }

        int sum = 0;
        boolean flag = true;
        //然后遍历数组,如果是偶数则直接累加偶数的值,如果是奇数,并且这个奇数-1之后还要大于0就要加上这个奇数-1之后的值
        for (int i : target) {
            if(i % 2 == 0) {
                sum += i;
            }else {
                if( i - 1 > 0) {
                    sum += i - 1;
                }
            }
            //最后还要判断如果有奇数,并且flag = true的情况下,sum += 1.因为回文串允许中间有一个单个的字符
            if(flag && i % 2 != 0) {
                sum += 1;
                //加上之后就把flag设置为false
                flag = false;
            }
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
