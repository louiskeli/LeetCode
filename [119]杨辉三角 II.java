//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 175 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex){
        List<Integer> list = new ArrayList<>(rowIndex + 1);

        for (int index = 0;index <= rowIndex;index++){
            if (index == 0) {list.add(1);}
            else{
                long temp = (long) list.get(index - 1) * (long) ((rowIndex + 1) - index) / index;
                list.add((int)temp);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
