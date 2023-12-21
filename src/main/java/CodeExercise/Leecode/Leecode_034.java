package CodeExercise.Leecode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/11 22:12
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 *      0 <= nums.length <= 10⁵
 *      -10⁹ <= nums[i] <= 10⁹
 *      nums 是一个非递减数组
 *      -10⁹ <= target <= 10⁹
 */
public class Leecode_034 {
    public int[] searchRange(int[] a, int target) {
        int x = left(a, target);
        if (x == -1){
            return new int[]{-1,-1};
        } else {
            return new int[]{x, right(a,target)};
        }
    }

    public int left(int[] a, int target){
        int i = 0, j = a.length - 1;
        int candidata = -1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (target < a[m]){
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidata = m;
                j = m - 1;
            }
        }
        return candidata;
    }

    public int right(int[] a, int target){
        int i = 0, j = a.length - 1;
        int candidata = -1;
        while (i <= j){
            int m = (i + j) >>> 1;
            if (target < a[m]){
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidata = m;
                i = m + 1;
            }
        }
        return candidata;
    }
}
