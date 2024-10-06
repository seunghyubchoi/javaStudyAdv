package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        t.start();

        sleep(1000);

        task.flag = false;
        log("flag = " + task.flag + ", count = " + task.count + " in main");
    }

    static class MyTask implements Runnable {

        //boolean flag = true;
        //long count;

        // volatile 사용 시 main 스레드가 flag를 변경하는 시점에
        // work 스레드도 flag의 변경 값을 정확하게 확인할 수 있다.
        // 대신 성능 차이 5배
        volatile boolean flag = true;
        volatile long count;


        @Override
        public void run() {
            while (flag) {
                count++;
                if (count % 100_000_000 == 0) { //1억에 한번씩 출력
                    log("flag = " + flag + ", count = " + count + " in while()");
                }
            }
            log("flag = " + flag + ", count = " + count + " 종료");
        }
    }


}
