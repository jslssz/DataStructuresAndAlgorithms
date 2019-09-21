package com.hx.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author jxlgcmh
 * @date 2019-09-21 20:52
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue queue =new ArrayBlockingQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        /**
         * add(E) 队满后添加元素:java.lang.IllegalStateException: Queue full
         */
        //queue.add(4);

        /**
         * remove 出队，并返回出队元素
         */
        //Object remove = queue.remove();
        /**
         * element(),返回队头元素
         */
        Object element = queue.element();

        /**
         * offer(E)添加一个元素，并返回布尔值
         */
        //boolean offer = queue.offer(4);

        /**
         *poll() 返回队头，不存在则返回null
         */
        Object poll = queue.poll();



    }
}
