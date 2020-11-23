//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 420 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();

        //将nums1移入哈希链表中
        for (int i = 0 ; i < nums1.length ; i++){
            if (!map.containsKey(nums1[i])) map.put(nums1[i],1);
            else map.put(nums1[i],map.get(nums1[i]) + 1);
        }

        //创建新数组用来存储重复元素
        int [] remember = new int[Math.min(nums1.length,nums2.length)];
        //count用来记录重复元素的个数
        int count = 0;

        //遍历nums2，来查找重复元素
        for (int i = 0 ; i < nums2.length ; i++){
            //int key = nums2[i];
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                remember[count] = nums2[i];
                count++;
                map.put(nums2[i],map.get(nums2[i]) - 1);
            }
        }

        //截取remember数组，利用count计数
        return java.util.Arrays.copyOf(remember,count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
