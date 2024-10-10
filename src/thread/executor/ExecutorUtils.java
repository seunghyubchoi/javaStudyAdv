package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static util.MyLogger.log;

public abstract class ExecutorUtils {
    public static void printState(ExecutorService executorService) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize(); // 풀에서 노는 스레드 수
            int active = poolExecutor.getActiveCount(); // 실제 작업 중인 스레드 수
            int queued = poolExecutor.getQueue().size(); // 작업 큐에서 대기 중 스레드 수
            long completedTask = poolExecutor.getCompletedTaskCount(); // 작업 완료 수
            log("[pool =" + pool + ", active = " + active +
                    ", queued = " + queued + ", completedTask = " + completedTask + "]");

        } else{
            log(executorService);
        }
    }
}
