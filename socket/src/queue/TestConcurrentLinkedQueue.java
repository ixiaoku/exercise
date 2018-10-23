package queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TestConcurrentLinkedQueue {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<String>();
        queue.add("a");//内部调用offer
        queue.offer("b");
        queue.offer("c");
        System.out.println(queue);
        queue.remove();//如果队里为空会报java.util.NoSuchElementException
        
        String str = queue.peek();//拿队列元素 但不删除
        System.out.println("peek:"+str);
        System.out.println(queue);
        queue.poll();//获取队列元素并删除如果没有则是null
        System.out.println("poll"+queue);
	}
}
