package main.DataStructure.Array;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class DynamicArray implements Iterable<Integer>{
    private int size = 0;           //逻辑大小
    private int capacity = 8;       //实际大小
    private int[] array = {};

    public int[] array(){
        return Arrays.copyOf(array, size);
    }

    public void addLast(int element) {
//        array[size] = element;
//        size++;
        add(size, element);
    }

    public void add(int index, int element) {
        checkAndGrow();
        // 添加逻辑
        if (index >= 0 && index < size) {
            // 向后挪动, 空出待插入位置
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void checkAndGrow() {
        // 容量检查
        if (size == 0) {
            array = new int[capacity];
        }else if (size == capacity) {
            // 进行扩容, 1.5 1.618 2
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0,
                    newArray, 0, size);
            array = newArray;
        }
    }

    public int get(int index) {
        return array[index];
    }

    public void foreach(Consumer<Integer> consumer){
        for(int i = 0; i < size; i++){
//            System.out.println(array[i]);
            consumer.accept(array[i]);
        }
    }

    // 迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {      // 有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() {         // 返回当前元素，并指针移动到下一个元素
                return array[i + 1];
            }
        };
    }

    // stream流遍历
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    // ---删除元素---
    public int remove(int index){
        int removed_index = array[index];
        if(index < size - 1){
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed_index;
    }


    @Test
    @DisplayName("测试DynamicArray")
    public void test() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
//        dynamicArray.addLast(5);
        dynamicArray.add(2,5);
//        dynamicArray.foreach((element)->{
//            System.out.println(element);  //1 2 5 3 4
//        });
//        dynamicArray.forEach(System.out::println);
        assertEquals(1, dynamicArray.get(0));
        assertEquals(2, dynamicArray.get(1));
        assertEquals(5, dynamicArray.get(2));
        assertEquals(3, dynamicArray.get(3));
        assertEquals(4, dynamicArray.get(4));
    }

    @Test
    @DisplayName("测试遍历1")
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        RusultCollector consumer = new RusultCollector();
        dynamicArray.foreach(consumer);
        consumer.test(List.of(1, 2, 3, 4));
    }

    static class RusultCollector implements Consumer<Integer>{
        List<Integer> list = new ArrayList<>();
        public void accept(Integer element) {
            list.add(element);
        }
        public void test(List<Integer> expected){
            assertIterableEquals(expected, list);
        }
    }

    @Test
    @DisplayName("测试遍历2")
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

//        for(Integer element : dynamicArray){
//            System.out.println(element);  //1 2 3 4
//        }
        //1 2 5 3 4
        dynamicArray.foreach(System.out::println);
//        assertIterableEquals(List.of(2, 2, 2, 2), dynamicArray);
    }

    @Test
    @DisplayName("测试遍历3")
    public void test4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, dynamicArray.stream().toArray());
    }

    @Test
    @DisplayName("测试删除元素")
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        int removed = dynamicArray.remove(2);
        System.out.println(removed);
        //1 2 5 3 4
        dynamicArray.foreach(System.out::println);
//        dynamicArray.foreach(System.out::println);
    }

    @Test
    @DisplayName("测试扩容")
    public void test6() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 9; i++) {
            dynamicArray.addLast(i + 1);
        }
        assertIterableEquals(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),
                dynamicArray
        );
    }
}
