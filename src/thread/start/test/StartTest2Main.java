package thread.start.test;

import static util.MyLogger.log;
public class StartTest2Main {
    public static void main(String[] args) {
        Thread counter = new Thread(new CounterRunnable());
        counter.start();
    }
}
