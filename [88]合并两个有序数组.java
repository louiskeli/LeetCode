//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 585 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //创建一个新的数组，遍历比较两个数组，将较小的数放于新数组中，最后将排好序的新数组copy到nums1上
        int [] all = new int [n + m];
        int l = 0,i = 0,j = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                all[l] = nums1[i];
                l++;
                i++;
            }else{
                all[l] = nums2[j];
                l++;
                j++;
            }
        }
        /**
         public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
         代码解释:
         Object src : 原数组
         int srcPos : 从元数据的起始位置开始
         　　     Object dest : 目标数组
         　　     int destPos : 目标数组的开始起始位置
         　　     int length  : 要copy的数组的长度
         **/
        if(i == m){
            System.arraycopy(nums2, j, all, l, n - j);
        }else{
            System.arraycopy(nums1, i, all, l, m - i);
        }
        System.arraycopy(all, 0, nums1, 0, n + m);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
