//给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。 
//
// 注意: 
//
// 
// 十六进制中所有字母(a-f)都必须是小写。 
// 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
// 给定的数确保在32位有符号整数范围内。 
// 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。 
// 
//
// 示例 1： 
//
// 
//输入:
//26
//
//输出:
//"1a"
// 
//
// 示例 2： 
//
// 
//输入:
//-1
//
//输出:
//"ffffffff"
// 
// Related Topics 位运算 
// 👍 112 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toHex(int num) {
        //处理 0 的特殊情况
        if (num == 0) return "0";

        //获得32位二进制位
        int [] bits = new int[32];
        for (int i = 31; i >= 0; i--){
            bits[i] = num & 0x1;
            num >>>= 1;
        }

        //从左到右每4位转成1位十六进制
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= 28; i += 4){
            int sum = 8 * bits[i] + 4 * bits[i + 1] + 2 * bits[i + 2] + bits[i + 3];
            if (sum <= 9 ) ans.append((char)(sum + '0'));
            else if (sum <= 15) ans.append((char)(sum - 10 + 'a'));
        }

        //去掉前导0，这也是0要特殊处理的原因
        //因为0的十六进制全为0，使用下面这个循环会越界访问
        while(ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }

        //toString() 方法用于返回以一个字符串表示的 Number 对象值
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
