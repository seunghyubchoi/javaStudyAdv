package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV4 implements BankAccount {
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());

        lock.lock();//ReentrantLock 이용하여 lock 걸기

        try {
            log("검증 시작, 출금액 : " + amount + ", 잔액 : " + balance);
            if (balance < amount) {
                log("검증 실패, 출금액 : " + amount + ", 잔액 : " + balance);
                return false; // 리턴, 익셉션 터지면? unlock 안 됨!!
            }
            log("검증 완료, 출금액 : " + amount + ", 잔액 : " + balance);

            sleep(1000);
            balance = balance - amount;
            log("출금 완료, 출금액 : " + amount + ", 잔액 : " + balance);
        } finally {
            lock.unlock(); // 반드시 unlock 하여 WAITING 빠진 아이 호출
        }

        log("거래 종료 : " + getClass().getSimpleName());
        return true;
    }

    @Override
    public  int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
