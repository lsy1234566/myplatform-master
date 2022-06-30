package com.lsy.study.leetcode;

import org.junit.Test;

import java.util.*;

public class T1 {
    public T1(){}
    //随机对象
    Random random;
    //随机边界，即构思的0~n大整型数组，前边全白名单，后边全黑名单数的分界线
    public int bound;
    //存放前面出现黑名单，通过键值就能一一映射到后边非黑名单的map集合
    public Map<Integer, Integer> blaceToWhite;
//
//    public T1(int n, int[] blacklist) {
//        //初始化随机对象
//        this.random = new Random();
//        //初始化随机边界
//        this.bound = n - blacklist.length;
//        //初始化map
//        //前面的键作为前面的数本身，若随机到的此数不是黑名单数，直接返回这个数
//        //后面的值作为他映射到的后边的非黑名单数，若随机到的此数是黑名单数，则返回这个映射值
//        blaceToWhite = new HashMap<Integer, Integer>();
//
//
//        //那么如何把边界前面出现的黑名单数，一一映射到边界后边的非黑名单数去呢？
//        //考虑到边界前面有多少个黑名单数，边界后边就会有多少个非黑名单数
//
//        //将边界后的黑名单数记录下
//        Set<Integer> backBlack = new HashSet<Integer>();
//        for (int x : blacklist) {
//            //比如x拿到50，既表示它数本身是50，但同时也表示对应在0~n的大数组中，它的下标也是50
//            //故x > bound可以表示x的下标位置在边界后，即将它添加到边界后黑名单集合set中
//            if (x >= bound) {
//                backBlack.add(x);
//            }
//        }
//
//        //开始将边界前的黑名单数数映射到边界后的非黑名单数
//        int w = bound;
//        for (int x : blacklist) {
//            //同理，它表示边界前的黑名单数
//            if (x < bound) {
//                //去找边界后的非黑名单数
//                //从边界数往后依次判断，若此数是边界后黑名单数，那向后继续找
//                while (backBlack.contains(w)) {
//                    w++;
//                }
//                //直到找到边界后的一个非黑名单数
//                //建立映射
//                blaceToWhite.put(x, w);
//                //让下一个映射，往后到下一个数
//                w++;
//            }
//        }
//    }
//
//    public int pick() {
////如果边界前随机的就是白名单数，直接返回就完了，否则返回这个边界前黑名单数对应的边界后映射
//
//        //map方法：default V getOrDefault(Object key, V defaultValue)
//        //返回指定键映射到的值，如果此映射不包含该键的映射，则返回 defaultValue
//        int x = random.nextInt(bound);
//        return blaceToWhite.getOrDefault(x, x);
//    }
//
//    public static void main(String[] args) {
//        T1 t1 = new T1(8, new int[]{5,6,7});
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//        System.out.println(t1.pick());
//    }

    @Test
    public void t1(){
        int i1=11111;
        int i2=11;
        System.out.println(i1&i2);
        System.out.println(1 << 9);
    }
}