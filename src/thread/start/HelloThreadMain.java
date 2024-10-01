package thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        // run()이 아닌 start() 메서드 호출, 그래야 별도의 스레드에서 run() 실행
        helloThread.start(); // main 스레드는 start() 로 별도 스레드에 run()을 실행 시키고 기다리지 않음
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
