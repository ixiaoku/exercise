package thread;

public class SecondThread implements Runnable{

	private int i;
	@Override
	public void run() {
		
		for(; i < 50 ; i++){
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		for(int i = 0 ; i < 50 ; i++){
			System.out.println(Thread.currentThread().getName() + " 主綫程" + i);
			if(i == 20) {
				SecondThread s = new SecondThread();
				new Thread(s, "新线程1").start();
				new Thread(s, "新线程2").start();
			}
		}
	}
	
	
}
