package dataStructure.collection.List;

import java.util.*;

public class linkedList {
    public static void main(String[] args) {

        // LinkedList模拟 队列 数据结构
        LinkedList queue = new LinkedList();
        QUEUE(queue);

        // inkedList模拟 栈 数据结构
        LinkedList stack = new LinkedList();
        STACK(stack);

    }

    /**
     * QUEUE 队列：一端添加元素，在另一端取出元素
     * 先进先出
     * @param queue
     */
    public static void QUEUE(LinkedList queue) {
        System.out.println("初始化队列");
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        printList(queue);

        System.out.println("返回队列的头元素，但不删除");
        System.out.println(queue.element());
        System.out.println(queue.peek());

        System.out.println("0号出队");
        queue.poll();
        printList(queue);

        System.out.println("10号入队");
        queue.offer(10);
        printList(queue);

        System.out.println("循环队列");
        queue.offer(queue.poll());
        printList(queue);

    }

    /**
     * STACK 栈：只能操作栈顶
     * 先进后出
     * @param list
     */
    public static void STACK(LinkedList list){
        System.out.println("入栈");
        for(int i = 0; i < 10; i++){
            list.push(i);
        }
        printList(list);

        System.out.println("出栈");
        list.pop();
        printList(list);
    }

    /**
     * 遍历list
     * @param list
     */
    public static void printList(LinkedList list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + ",");
        }
        System.out.println("");
    }
}