//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 342 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();

        if (numRows >= 1){
            List<Integer> inList = new ArrayList<>();
            inList.add(1);
            lists.add(inList);

            for(int row = 2;row <= numRows;row++){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                List<Integer> pre = lists.get(lists.size() - 1);

                for (int j = 1;j < row - 1;j++){
                    int temp;
                    if (j <= row / 2) temp = pre.get(j - 1) + pre.get(j);
                    else temp = list.get(row - 1 - j);
                    list.add(temp);
                }

                list.add(1);
                lists.add(list);
            }
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
