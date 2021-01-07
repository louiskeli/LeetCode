//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算 
// 👍 364 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        //将x和y进行异或运算之后求结果中1的个数
        int xor = x ^ y;
        int distance = 0;
        //循环结束的条件是xor中不存在1，即1的个数已经统计完成
        while (xor != 0) {
            //"xor % 2 == 1"可以将除最右边位以外的位置屏蔽
            if (xor % 2 == 1) distance += 1;
            //移除已经统计的最右边位，同时对最左边的位进行"0"的补位
            xor = xor >> 1;
        }
        return distance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
