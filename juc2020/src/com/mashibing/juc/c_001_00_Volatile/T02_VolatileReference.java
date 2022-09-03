/**
 * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
 */
package com.mashibing.juc.c_001_00_Volatile;

import com.mashibing.util.SleepHelper;

public class T02_VolatileReference {

    private static class A {
        boolean running = true;

        void m() {
            System.out.println("m start");
            while (running) {
            }
            System.out.println("m end!");
        }
    }

    private static volatile A a = new A();

    public static void main(String[] args) {
        new Thread(a::m, "t1").start();
        SleepHelper.sleepSeconds(1);
        a.running = false;
    }
}
