//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 516 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        //全为9
        int count_1 = 0;
        for (int i = 0;i < len;i++) {
            if(digits[i] == 9) count_1 += 1;
        }
        if(count_1 == len){
            //重新输出一个首位为1，其他位为零的，比原数组多一位的新数组
           int [] digits_1 = new int[len+1];
           digits_1[0] = 1;
           return digits_1;
        }
        else{
            //得到末尾连续9的个数
            count_1 = 0;
            boolean tag = true;
            for(int i = len-1;i >= 0 && tag;i--){
                if (digits[i] == 9) count_1 += 1;
                else tag = false;
            }
            //利用得到的9个数转换为零，对上一位加一
            int count_2 = count_1;
            for(int i = len-1;i >= 0 && count_1 >0;i--,count_1--){
                digits[i] = 0;
            }
            digits[len-1 - count_2] += 1;
            return digits;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
