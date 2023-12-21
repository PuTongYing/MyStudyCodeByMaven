package main.DataStructure.LinkedList;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: 小蔡
 * @Date: 2023/12/10 21:42
 * @description: 单向链表（带哨兵）
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    private Node head = new Node(666, null); // 头指针

    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类 -> 带名字内部类
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head.next;

        @Override
        public boolean hasNext() { // 是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() { // 返回当前值, 并指向下一个元素
            int v = p.value;
            p = p.next;
            return v;
        }
    }

    /**
     * 节点类
     */
    private static class Node {
        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void loop1(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    private Node findLast() {
        Node p;
        for (p = head; p.next != null; p = p.next) {}
        return p;
    }

    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null; // 没找到
    }

    public int get(int index) throws IllegalArgumentException {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }

    public void insert(int index, int value) throws IllegalArgumentException {
        Node prev = findNode(index - 1); // 找到上一个节点
        if (prev == null) { // 找不到
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    public void removeFirst() throws IllegalArgumentException {
        remove(0);
    }

    public void remove(int index) throws IllegalArgumentException {
        Node prev = findNode(index - 1); // 上一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next; // 被删除的节点
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }

    private SinglyLinkedListSentinel getLinkedList() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    @DisplayName("测试 addFirst")
    public void test1() {
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        Assertions.assertIterableEquals(List.of(4, 3, 2, 1), list);
    }

    @Test
    @DisplayName("测试addList")
    public void test2() {
        SinglyLinkedListSentinel list = getLinkedList();
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    @DisplayName("测试get")
    public void test3() {
        SinglyLinkedListSentinel list = getLinkedList();
        Assertions.assertEquals(3, list.get(2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(10));
    }

    @Test
    @DisplayName("测试insert")
    public void test4() {
        SinglyLinkedListSentinel list = getLinkedList();
        list.insert(0, 5);
        Assertions.assertIterableEquals(List.of(5, 1, 2, 3, 4), list);

        list = getLinkedList();
        list.insert(2, 5);
        Assertions.assertIterableEquals(List.of(1, 2, 5, 3, 4), list);

        list = getLinkedList();
        list.insert(4, 5);
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4, 5), list);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> getLinkedList().insert(5, 5));

        list = getLinkedList();
        list.addFirst(5);
        Assertions.assertIterableEquals(List.of(5, 1, 2, 3, 4), list);

        SinglyLinkedListSentinel list2 = new SinglyLinkedListSentinel();
        list2.addFirst(1);
        Assertions.assertIterableEquals(List.of(1), list2);
    }

    @Test
    @DisplayName("测试 removeFirst")
    public void test5() {
        SinglyLinkedListSentinel list = getLinkedList();
        list.removeFirst();
        Assertions.assertIterableEquals(List.of(2, 3, 4), list);
        list.removeFirst();
        Assertions.assertIterableEquals(List.of(3, 4), list);
        list.removeFirst();
        Assertions.assertIterableEquals(List.of(4), list);
        list.removeFirst();
        Assertions.assertIterableEquals(List.of(), list);
        Assertions.assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    @Test
    @DisplayName("测试 remove")
    public void test6() {
        SinglyLinkedListSentinel list1 = getLinkedList();
        list1.remove(2);
        Assertions.assertIterableEquals(List.of(1, 2, 4), list1);
        SinglyLinkedListSentinel list2 = getLinkedList();
        list2.remove(0);
        Assertions.assertIterableEquals(List.of(2, 3, 4), list2);
        SinglyLinkedListSentinel list3 = getLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list3.remove(5));
        SinglyLinkedListSentinel list4 = getLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list4.remove(4));
    }
}
