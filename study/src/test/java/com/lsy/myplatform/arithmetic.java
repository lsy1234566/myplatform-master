package com.lsy.myplatform;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: 林思源
 * @date: 2022.03.19
 */

public class arithmetic {

    @Test
    public void t1() {

        long startTime = System.nanoTime();
        int n = 1123452314;
        int c = 0; // 计数器
        while (n > 0) {
            if ((n & 1) == 1) // 当前位是1
                ++c; // 计数器加1
            n >>= 1; // 移位
        }
        System.out.println(c);
        Duration timeTakenToReady = Duration.ofNanos(System.nanoTime() - startTime);
        System.out.println(timeTakenToReady);

        startTime = System.nanoTime();
        c = 0;
        n = 1123452314;
        for (c = 0; n > 0; ++c) {
            n &= (n - 1); // 清除最低位的1
        }
        System.out.println(c);
        timeTakenToReady = Duration.ofNanos(System.nanoTime() - startTime);
        System.out.println(timeTakenToReady);
    }


    @Test
    public void t3() {

        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();
        listNode1.next = listNode2;
        listNode2.pre = listNode1;
        listNode2.next = listNode3;
        listNode3.pre = listNode2;
        listNode3.next = listNode4;
        listNode4.pre = listNode3;
        listNode4.next = listNode5;
        listNode5.pre = listNode4;

        ListNode listNode = reverseList(listNode1);
        System.out.println(listNode);


        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(10);
        System.out.println(reverseListNode(list));
    }

    public List reverseListNode(List h) {
        int size = h.size();
        ListIterator startIterator = h.listIterator();
        ListIterator endIterator = h.listIterator(size);

        // 1 2 4 8 16 32 64
        if (size > 8) {
            for (int i = 0, mid = size >> 1; i < mid; i++) {
                Object next = startIterator.next();
                startIterator.set(endIterator.previous());
                endIterator.set(next);
            }
        } else {
            for (int i = 0, mid = size / 2; i < mid; i++) {
                Object next = startIterator.next();
                startIterator.set(endIterator.previous());
                endIterator.set(next);
            }
        }


        return h;
    }


    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        if (cur1.next == null || cur1.next.next == null) {
            return head;
        }
        ListNode cur2 = cur1.next;
        ListNode cur3 = cur2.next;
        while (cur3 != null) {
            cur2.next = cur3.next;
            ListNode temp = cur1.next;
            cur1.next = cur3;
            cur3.next = temp;
            cur3 = cur2.next;
        }
        return dummyHead.next;
    }

    static class ListNode {
        ListNode pre;
        ListNode next;
    }
}
