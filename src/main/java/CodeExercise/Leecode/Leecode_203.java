package CodeExercise.Leecode;

import main.DataStructure.LinkedList.ListNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/18 22:40
 * @description: 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * 提示：
 *      列表中的节点数目在范围 [0, 10⁴]
 *      1 <= Node.val <= 50
 *      0 <= val <= 50
 */
public class Leecode_203 {
//     // 方法1
//    public ListNode removeElement(ListNode head, int val) {
//        ListNode s = new ListNode(-1, head);
//        ListNode p1 = s;
//        ListNode p2 = s.next;
//        while (p2 != null) {
//            if (p2.val == val) {
//                p1.next = p2.next;
////                p2 = p2.next; => p2 = p1.next;
//            } else {
//                p1 = p1.next;
////                p2 = p2.next; => p2 = p1.next;
//            }
//            p2 = p1.next;
//        }
//        return s.next;
//    }

    // 方法2--递归
    public ListNode removeElements(ListNode p ,int val){
        if (p == null){
            return null;
        }
        if (p.val == val){
            return removeElements(p.next, val);
        } else {
            p.next = removeElements(p.next, val);
            return p;
        }
    }
}
