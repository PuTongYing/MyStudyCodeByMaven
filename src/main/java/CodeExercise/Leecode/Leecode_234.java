package CodeExercise.Leecode;

import main.DataStructure.LinkedList.ListNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/20 16:57
 * @description: 判断回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * 提示：
 *      链表中节点数目在范围[1, 10⁵] 内
 *      0 <= Node.val <= 9
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Leecode_234 {
    // 快慢指针法
    /*
        步骤1. 找中间点的同时反转前半个链表
        步骤2. 反转后的前半个链表 与 中间点开始的后半个链表 逐一比较
                p1      p2
        1   2   2   1   null

        n1
        2   1
     */
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head; // 慢
        ListNode p2 = head; // 快
        ListNode n1 = null; // 新头
        ListNode o1 = head; // 旧头
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            // 反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        if (p2 != null) { // 奇数节点
            p1 = p1.next;
        }
        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }
}
