package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("run flag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {

        //boolean runFlag = true;
        volatile boolean runFlag = true;
        // 캐시 메모리 사용하지 않고 항상 메인 메모리에 직접 접근

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                // runFlag = false로 변하면 탈출
            }
            log("task 종료");
        }
    }
}
