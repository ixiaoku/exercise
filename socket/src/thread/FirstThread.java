package thread;

public class FirstThread extends Thread{

	private int i;
	public void run(){
		for(; i < 100 ; i++){
			System.out.println(this.getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0 ; i < 100 ; i++){
			System.out.println(Thread.currentThread().getName() + " ���Q��" + i);
			if(i == 20) {
				FirstThread f1 = new FirstThread();
				FirstThread f2 = new FirstThread();
				f1.start();
				f2.start();
			}
		}
	}
}
