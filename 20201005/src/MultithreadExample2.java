
public class MultithreadExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1= new DigitThread();
		Thread thread2= new DigitThread();
		Thread thread3= new AlphabetThread();
		Thread thread4= new AlphabetThread();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
