//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 
//
// 示例： 
//
// 输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 提示： 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。 
// 
// Related Topics 位运算 回溯算法 
// 👍 193 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    void backTracking(int i, int num, int hour,int minute,List<String> ans){
        if(hour>11 || minute>59) return;
        if(num>10-i) return;//亮灯数大于剩下的位置数
        if(num==0){//使用完亮灯数，进行添加
            String minStr = String.valueOf(minute);
            if(minute<10) {
                minStr = "0"+minStr;
            }
            ans.add(String.valueOf(hour)+":"+minStr);
            return;
        };
        //不选当前位置
        backTracking(i+1,num,hour,minute,ans);
        //选取当前位置
        if(i<4){//在hour范围内
            hour+=(1<<i);
        }else{
            minute += (1<<(i-4));
        }
        backTracking(i+1,num-1,hour,minute,ans);
    }

    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        backTracking(0,num,0,0,ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
