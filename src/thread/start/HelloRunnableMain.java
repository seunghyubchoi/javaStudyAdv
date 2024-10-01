package thread.start;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        HelloRunnable runnable = new HelloRunnable(); // runnable 객체 생성
        Thread thread = new Thread(runnable); // runnable 객체 전달
        thread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");


    }
}
