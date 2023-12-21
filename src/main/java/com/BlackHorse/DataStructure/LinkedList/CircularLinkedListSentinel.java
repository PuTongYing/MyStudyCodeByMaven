package main.DataStructure.LinkedList;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 小蔡
 * @Date: 2023/12/10 23:17
 * @description: 双向环形链表（带哨兵）
 */
public class CircularLinkedListSentinel implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private final Node sentinel = new Node(null, -1, null);

    public CircularLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value){
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.next = added;
    }

    @Test
    @DisplayName("测试addFirst")
    public void test1() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        assertIterableEquals(List.of(5, 4, 3, 2, 1), list);
    }

    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    @Test
    @DisplayName("测试addLast")
    public void test2() {
        CircularLinkedListSentinel list = new CircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        assertIterableEquals(List.of(1, 2, 3, 4, 5), list);
    }

    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    @Test
    @DisplayName("测试removeFirst")
    public void test3() {
        CircularLinkedListSentinel list = getList();
        list.removeFirst();
        assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(5), list);
        list.removeFirst();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    private CircularLinkedListSentinel getList() {
        CircularLinkedListSentinel list = new CircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        return list;
    }

    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    @Test
    @DisplayName("测试removeLast")
    public void test4() {
        CircularLinkedListSentinel list = getList();
        list.removeLast();
        assertIterableEquals(List.of(1, 2, 3, 4), list);
        list.removeLast();
        assertIterableEquals(List.of(1, 2, 3), list);
        list.removeLast();
        assertIterableEquals(List.of(1, 2), list);
        list.removeLast();
        assertIterableEquals(List.of(1), list);
        list.removeLast();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeLast);
    }

    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    // 根据值进行删除
    public void removeByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            return; // 不用删
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    @Test
    @DisplayName("测试removeByValue")
    public void test5() {
        CircularLinkedListSentinel list = getList();
        list.removeByValue(1);
        assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeByValue(2);
        assertIterableEquals(List.of(3, 4, 5), list);
        list.removeByValue(3);
        assertIterableEquals(List.of(4, 5), list);
        list.removeByValue(4);
        assertIterableEquals(List.of(5), list);
        list.removeByValue(5);
        assertIterableEquals(List.of(), list);
    }

}
