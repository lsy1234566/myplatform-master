package com.lsy.study.jdk;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.LinkedList;

public class JavaList {

    @Test
    public void t1() {
        Node node1 = new Node();
        node1.val="1";
        Node node2 = new Node();
        node2.val="2";
        Node node3 = new Node();
        node3.val="3";
        Node node4 = new Node();
        node4.val="4";
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        soutList(node1);
        reverse(node1);
        soutList(node1);
    }

    //非递归实现
    public Node reverse(Node current) {
        Node previous = null;
        Node next = null;

        while (current != null) {
            //存储下一节点
            next = current.next;
            current.next = previous;		//反转

            //更新遍历节点
            previous = current;
            current = next;
        }

        return current;
    }

    static class Node{
        String val;
        Node next;
    }

    void soutList(Node node){
        while (true){
            if (node!=null) {
                System.out.println(node.val);
                node=node.next;
            }else{
                break;
            }
        }
    }

    @Test
    public void t2(){
        String s = new String("1");
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);

    }
}
