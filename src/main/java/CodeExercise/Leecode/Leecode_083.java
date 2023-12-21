package CodeExercise.Leecode;

import main.DataStructure.LinkedList.ListNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/19 23:35
 * @description: 删除排序链表中的重复元素
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
public class Leecode_083 {
//    // 方法1
//    public ListNode deleteDuplicates(ListNode head){
//        // 节点数 < 2
//        if (head == null || head.next == null){
//            return head;
//        }
//        // 节点数 >= 2
//        ListNode p1 = head;
//        ListNode p2;
//        while ((p2 = p1.next) != null) {
//            if (p1.val == p2.val){
//                p1.next = p2.next;
//            } else {
//                p1 = p1.next;
//            }
//        }
//        return head;
//    }

    // 方法2--递归
    public ListNode deleteDuplicates(ListNode p){
        if (p == null || p.next == null){
            return p;
        }
        if (p.val == p.next.val){
            return deleteDuplicates(p.next);
        } else {
            p.next = deleteDuplicates(p.next);
            return p;
        }
    }
}
