package org.kob.botrunningsystem.service.impl.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BotPool extends Thread{
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Queue<Bot> bots = new LinkedList<>();
    public void addBot(Integer userId, String botCode, String input) {
        lock.lock();//上锁
        try {
            bots.add(new Bot(userId, botCode, input));// 添加到队列
            condition.signalAll();//唤醒所有等待的线程
        } finally {
            lock.unlock();//解锁
        }
    }

    @Override
    public void run() {
        while(true){
            lock.lock();// 上锁
            if(bots.isEmpty()){ // 如果队列为空
                try {
                    condition.await();//等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    lock.unlock();
                    break;
                }
            } else{
                Bot bot = bots.remove(); // 返回并移除队列的头
                lock.unlock();
                consume(bot);  // 比较耗时，可能会执行几秒钟
            }
        }
    }

    private void consume(Bot bot) {
        Consumer consumer = new Consumer();
        consumer.startTimeout(2000, bot);
    }
}
