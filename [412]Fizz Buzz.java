//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 77 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0){
                ans.add("FizzBuzz");
            }else if (i % 3 == 0) {
                ans.add("Fizz");
            }else if (i % 5 == 0) {
                ans.add("Buzz");
            }else {
                //使用Integer.toString()将数字i转为字符形式，不能直接"i"，会直接显示i而不是数字
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
