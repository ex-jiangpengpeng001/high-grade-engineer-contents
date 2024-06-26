package com.mashibing.juc.c_001_00_thread_end;

import com.mashibing.util.SleepHelper;

public class T02_Suspend_Resume {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while (true) {
                System.out.println("go on");
                SleepHelper.sleepSeconds(1);
            }
        });

        t.start();

        SleepHelper.sleepSeconds(5);

        t.suspend();
        SleepHelper.sleepSeconds(3);
        System.out.println("暂停3秒后继续。");
        t.resume();
    }
}
