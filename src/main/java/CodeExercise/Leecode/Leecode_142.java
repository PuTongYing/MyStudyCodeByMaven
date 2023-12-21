package CodeExercise.Leecode;

import main.DataStructure.LinkedList.ListNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/20 19:23
 * @description: 环形链表2
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
 * 链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * 提示：
 *      链表中节点的数目范围在范围 [0, 10⁴] 内
 *      -10⁵ <= Node.val <= 10⁵
 *      pos 的值为 -1 或者链表中的一个有效索引
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 */
public class Leecode_142 {
    public ListNode detectCycle(ListNode head){
        ListNode h = head;  // 龟
        ListNode t = head;  // 兔
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
            if (t == h){
                t = head;
                while (true) {
                    if (t == h){
                        return t;
                    }
                    t = t.next;
                    h = h.next;
                }
            }
        }
        return null;
    }
}
