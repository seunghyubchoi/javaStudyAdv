package thread.control;

import util.ThreadUtils;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {
        @Override
        public void run() /*throws Exception 이거 써도 불가능 */ {
            // 부모가 체크 예외를 던지지 않는다면
            // 구현된 자식도 체크 예외를 던질 수 없다
            // throw new Exception; 부모인 Runnable에 예외 던지는 게 없음
        }
    }
}
