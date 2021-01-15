//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 
//
// 
//
// 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
// 
//
// 
//
// 注意： 
//
// 
// 你可以重复使用键盘上同一字符。 
// 你可以假设输入的字符串将只包含字母。 
// Related Topics 哈希表 
// 👍 120 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //建立字符串类型的字典数组
    String [] oneLines = new String[] {
            "QWERTYUIOP","ASDFGHJKL","ZXCVBNM"
    };

    public String[] findWords(String[] words) {
        //创建数组，保存128位ascll码
        int [] lines = new int[128];
        //存放满足条件的单词
        String [] res = new String[words.length];

        //初始化字典：将字典中每行大写字母在lines数组中标上行数
        for (int i = 0;i < oneLines.length; i++) {
            for (char c : oneLines[i].toCharArray()) {
                lines[c] = i + 1;
            }
        }

        int count = 0;
        //对输入单词列表中的每个单词进行判断是否为同一行单词组成
        for (String word : words) {
            int lineNum = 0;
            boolean isOneLine = true;
            for (char c : word.toCharArray()) {
                //将单词中的每个字母统一转为大写
                c = Character.toUpperCase(c);
                //判断单词中当前字符和上个字符是否在同一行
                if (lineNum != 0 && lines[c] != lineNum) {
                    isOneLine = false;
                    //跳出当前for循环
                    break;
                }else {
                    lineNum = lines[c];
                }
            }
            //满足条件的单词存入res数组中
            if (isOneLine) {
                res[count] = word;
                count++;
            }
        }
        //数组res数组中前count个字符串
        return Arrays.copyOf(res, count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
