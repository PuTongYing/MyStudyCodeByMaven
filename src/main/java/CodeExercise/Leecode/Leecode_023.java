package CodeExercise.Leecode;

import main.DataStructure.LinkedList.ListNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/20 16:30
 * @description: 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *  1->4->5,
 *  1->3->4,
 *  2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 *      k == lists.length
 *      0 <= k <= 10^4
 *      0 <= lists[i].length <= 500
 *      -10^4 <= lists[i][j] <= 10^4
 *      lists[i] 按 升序 排列
 *      lists[i].length 的总和不超过 10^4
 */
public class Leecode_023 {
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if (p2 == null) {
            return p1;
        }
        if (p1 == null) {
            return p2;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwoLists(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoLists(p1, p2.next);
            return p2;
        }
    }

    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0){
            return null;
        }
        return split(lists, 0, lists.length-1);
    }

    // 返回合并后的链表
    // i,j分别代表左右边界
    private ListNode split(ListNode[] lists, int i, int j){
        if (i == j){        // 数组内只有一个链表时
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m+1, j);
        return mergeTwoLists(left, right);
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(1,4,5),
                ListNode.of(1,3,4),
                ListNode.of(2,6),
        };
        ListNode m = new Leecode_023().mergeKLists(lists);
        System.out.println(m);
    }
}
