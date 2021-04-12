//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 863 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length,w = board[0].length;
        //visited数组用于标识每个位置是否被访问过
        //在一个大遍历中遍历相邻位置时，需要跳过已经被访问过的位置
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = checkFunction(board,visited,i,j,word,0);
                if (flag) return true;
            }
        }
        return false;
    }

    public boolean checkFunction(char [][] board,boolean[][] visited,int i,int j,String word,int k) {
        if (board[i][j] != word.charAt(k)) return false;
        else if (k == word.length() - 1) return true;
        //当前位置设为已被访问状态
        visited [i][j] = true;
        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean result = false;
        //从当前位置的上下左右出发寻找满足下一个字符的位置
        for (int [] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            //下一个位置应该在合理范围内
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                //遍历相邻位置时，需要跳过已经被访问过的位置
                if (!visited[newi][newj]) {
                    boolean flag = checkFunction(board,visited,newi,newj,word,k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        //设置回未被访问状态
        visited[i][j] = false;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
