package comstream;

import java.util.concurrent.locks.StampedLock;

public class t {
	private final StampedLock sl = new StampedLock();
	private long balance;

	public t(long balance) {
		this.balance = balance;
	}

	public void deposit(long amount) {
		long stamp = sl.writeLock();
		try {
			balance += amount;
		} finally {
			sl.unlockWrite(stamp);
		}
	}

	public void withdraw(long amount) {
		long stamp = sl.writeLock();
		try {
			balance -= amount;
		} finally {
			sl.unlockWrite(stamp);
		}
	}

	public long getBalance() {
		long stamp = sl.readLock();
		try {
			return balance;
		} finally {
			sl.unlockRead(stamp);
		}
	}

	public long getBalanceOptimisticRead() {
		long stamp = sl.tryOptimisticRead();
		long balance = this.balance;
		if (!sl.validate(stamp)) {
			stamp = sl.readLock();
			try {
				balance = this.balance;
			} finally {
				sl.unlockRead(stamp);
			}

		}
		return balance;
	}
}
