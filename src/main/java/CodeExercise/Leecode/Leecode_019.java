package CodeExercise.Leecode;

import main.DataStructure.LinkedList.ListNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/19 23:18
 * @description: 删除链表的倒数第N个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 *      链表中结点的数目为 sz
 *      1 <= sz <= 30
 *      0 <= Node.val <= 100
 *      1 <= n <= sz
 */
public class Leecode_019 {
//    // 方法1
//    public ListNode removeNthFromEnd(ListNode head,int n){
//        ListNode s = new ListNode(-1, head);
//        recursion(s, n);
//        return s.next;
//    }
//
//    private int recursion(ListNode p, int n){
//        if (p == null){
//            return 0;
//        }
//        int nth = recursion(p.next, n); // 下一个节点的倒数位置
//        if (nth == n){
//            p.next = p.next.next;
//        }
//        return nth + 1;
//    }

    // 方法2--快慢指针法
    /*
        n=2
        p1
        p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

                  p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

        p1             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

                       p1             p2
        s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }
}
