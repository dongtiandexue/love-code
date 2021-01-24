//给出一个区间的集合，请合并所有重叠的区间。
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 775 👎 0


package com.hh.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals_56().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 1、对数组按照第一个元素从小到大排序
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            // 2、因为不知道最终数组的大小，用集合代替
            List<int[]> merged = new ArrayList<>();
            int max, i, j = 0;
            // 3、主要是用了这个表达式一定会返回左值的概念，每次完成循环结束后的赋值和初始赋值
            while ((i = j) < intervals.length) {
                max = intervals[i][1];
                j = i;
                // 4、合并区间，找到每个可合并区间的最右值
                while (j < intervals.length && intervals[j][0] <= max) {
                    max = Math.max(intervals[j++][1], max);
                }
                merged.add(new int[]{intervals[i][0], max});
            }

            return merged.toArray(new int[merged.size()][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}