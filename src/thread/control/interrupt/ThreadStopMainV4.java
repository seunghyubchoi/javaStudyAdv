package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
        log("난 언제 나오나?");
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {

            while (!Thread.interrupted()) { // 인터럽트 상태를 확인하고 변경까지
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            // 인터럽트 예외 터지면 false로 변경, 현재는 계속 true임

            try {
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태 : " + Thread.currentThread().isInterrupted());
            }
            log("작업 종료");


        }
    }
}
