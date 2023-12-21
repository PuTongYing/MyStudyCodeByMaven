package CodeExercise.Leecode;

import main.DataStructure.LinkedList.ListNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/20 0:03
 * @description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 *      两个链表的节点数目范围是 [0, 50]
 *      -100 <= Node.val <= 100
 *      l1 和 l2 均按 非递减顺序 排列
 */
public class Leecode_021 {
//    // 方法1
//    public ListNode mergeTowLists(ListNode p1, ListNode p2){
//        ListNode s = new ListNode(-1, null);
//        ListNode p = s;
//        while (p1 != null && p2 != null) {
//            if (p1.val < p2.val){
//                p.next = p1;
//                p1 = p1.next;
//            } else {
//                p.next = p2;
//                p2 = p2.next;
//            }
//            p = p.next;
//        }
//        if (p1 != null){
//            p.next = p1;
//        }
//        if (p2 != null){
//            p.next = p2;
//        }
//        return s.next;
//    }

    // 方法2--递归
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
}
