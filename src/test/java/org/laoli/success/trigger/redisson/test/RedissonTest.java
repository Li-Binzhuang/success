package org.laoli.success.trigger.redisson.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.laoli.success.trigger.entity.Student;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTest {
    @Resource
    RedissonClient redissonClient;

    @Test
    public void testSetBucket(){
        RBucket<Object> bucket = redissonClient.getBucket("haha");
        Student student = new Student();
        student.setAge(18);
        student.setName("laoli");
        bucket.set(student);
    }

    @Test
    public void testGetBucket(){
        RBucket<Object> bucket = redissonClient.getBucket("haha");
        Student student = (Student) bucket.get();
        log.info("student:{}",student);
    }

    //redisson分布式锁
    @Test
    public void performTaskWithLock() {
        RLock lock = redissonClient.getLock("myLock");
        try {
            lock.lock();// 加锁// 执行需要同步的代码（例如生成唯一ID）
            System.out.println("Lock  acquired, executing task...");
            Thread.sleep(1000);// 模拟耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();// 释放锁
            System.out.println("Lock  released");
        }
    }

    @Test
    public void publishMessage() {
        RTopic topic = redissonClient.getTopic("news");
        topic.publish("Hello  Redisson!");
    }

    @Test
    public void subscribeMessage() {
        RTopic topic = redissonClient.getTopic("news");
        topic.addListener(String.class,  (channel, msg) ->
            System.out.println("Received:  " + msg)
        );
    }
}
