package CodeExercise.Leecode;

import main.DataStructure.LinkedList.ListNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/17 13:34
 * @description: 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 *      链表中节点的数目范围是 [0, 5000]
 *      -5000 <= Node.val <= 5000
 */
public class Leecode_206 {
//    // 方法1
//    public ListNode reverseList(ListNode head) {
//        ListNode n1 = null;
//        ListNode p = head;
//        while (p != null){
//            n1 = new ListNode(p.val, n1);
//            p = p.next;
//        }
//        return n1;
//    }

//    // 方法2
//    public ListNode reverseList(ListNode head){
//        List list1 = new List(head);
//        List list2 = new List(null);
//        while (true) {
//            ListNode first = list1.removeFirst();
//            if (first == null) {
//                break;
//            }
//            list2.addFirst(first);
//        }
//        return list2.head;
//    }
//
//    static class List {
//        ListNode head;
//        public List(ListNode head) {
//            this.head = head;
//        }
//
//        public void addFirst(ListNode first) {
//            first.next = head;
//            head = first;
//        }
//
//        public ListNode removeFirst() {
//            ListNode first = head;
//            if (first != null) {
//                head = first.next;
//            }
//            return first;
//        }
//    }

    // 方法3-递归
    public static ListNode reverseList(ListNode p){
        if (p == null || p.next == null){
            return p;       // 最后一个节点
        }
        ListNode last = reverseList(p.next);
        p.next.next = p;
        p.next = null;
        return last;
    }

//    // 方法4
//    public ListNode reverseList(ListNode o1){
//        // 空链表或者只有一个元素的情况
//        if (o1 == null || o1.next == null){
//            return o1;
//        }
//        // 1-设置指针o1（旧头），n1（新头），o2（旧老二）分别指向第一，第一，第二节点
//        ListNode o2 = o1.next;
//        ListNode n1 = o1;
//        while (o2 != null){
//            o1.next = o2.next;  // 2-将o2节点从链表断开，即o1节点指向第三节点
//            o2.next = n1;       // 3-o2节点链入链表头部
//            n1 = o2;            // 4-n1指向o2
//            o2 = o1.next;       // 5-o2指向o1的下一个节点
//        }
//        return n1;
//    }

    // 方法5-把链表分成两部分，思路就是不断从链表2的头，往链表1的头搬移
//    public ListNode reverseList(ListNode o1){
//        if (o1 == null || o1.next == null){
//            return o1;
//        }
//        // 1-n1指向null，代表新链表一开始没有元素，o1指向原链表的首节点
//        ListNode n1 = null;
//        while (o1 != null){
//            ListNode o2 = o1.next;   // 2-开始循环，o2指向原链表次节点
//            o1.next = n1;            // 3-搬移
//            // 4-指针复位
//            n1 = o1;
//            o1 = o2;
//        }
//        return n1;
//    }
}
