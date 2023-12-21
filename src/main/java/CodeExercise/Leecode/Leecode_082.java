package CodeExercise.Leecode;

import main.DataStructure.LinkedList.ListNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/19 23:46
 * @description: 删除排序链表中的重复元素Ⅱ
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 *      链表中节点数目在范围 [0, 300] 内
 *      -100 <= Node.val <= 100
 *      题目数据保证链表已经按升序 排列
 */
public class Leecode_082 {
//    // 方法1--递归
//    public ListNode deleteDuplicates(ListNode p){
//        if (p == null || p.next == null){
//            return p;
//        }
//        if (p.val == p.next.val){
//            ListNode x = p.next.next;
//            while (x != null && x.val == p.val) {
//                x = x.next;
//            }
//            return deleteDuplicates(x);
//        } else {
//            p.next = deleteDuplicates(p.next);
//            return p;
//        }
//    }

    // 方法2--哨兵
    public ListNode deleteDuplicates(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2, p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val){
                while ((p3 = p3.next) != null && (p3.val == p2.val)){}
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }
}
