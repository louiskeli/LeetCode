//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 
// 👍 68 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        //计算单词的数量，就等同于计数单词开始的下标个数
        int segmentCount = 0;

        //遍历整个字符串，检测每个下标
        for (int i = 0; i < s.length(); i++){
            //若该下标前为空格（或者为初始下标），且自身不为空格，则其为单词开始的下标
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' '){
                segmentCount++;
            }
        }

        //返回满足条件的下标个数
        return segmentCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
