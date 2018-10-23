package queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TestConcurrentLinkedQueue {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<String>();
        queue.add("a");//�ڲ�����offer
        queue.offer("b");
        queue.offer("c");
        System.out.println(queue);
        queue.remove();//�������Ϊ�ջᱨjava.util.NoSuchElementException
        
        String str = queue.peek();//�ö���Ԫ�� ����ɾ��
        System.out.println("peek:"+str);
        System.out.println(queue);
        queue.poll();//��ȡ����Ԫ�ز�ɾ�����û������null
        System.out.println("poll"+queue);
	}
}
