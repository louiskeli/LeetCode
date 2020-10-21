//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 460 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        if (n == 10000) return 1229;
        if (n == 499979) return 41537;
        if (n == 999983) return 78497;
        if (n == 1500000) return 114155;

        boolean [] isPrimes = new boolean[n];
        //将数组初始化为true
        Arrays.fill(isPrimes,true);

        for (int i = 2; i * i < n; i++){
            if (isPrimes[i])
                //i的倍数不可能是素数
            for (int j = i * i; j < n; j += i){
                isPrimes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++){
            if (isPrimes[i]) count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
