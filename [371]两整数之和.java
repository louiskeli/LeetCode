//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 334 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        while (b != 0){
            //当进位不为0时

            //异或运算用来计算无累加值
            int temp = a ^ b ;
            //与运算用来计算进位值
            int carry = (a & b) << 1;

            //分别复制给a和b
            a = temp;
            b = carry;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
