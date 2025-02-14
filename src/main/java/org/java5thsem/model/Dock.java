package org.java5thsem.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dock {
    private final int id;
    private final Lock lock = new ReentrantLock();

    public Dock(int id) {
        this.id = id;
    }

    public boolean tryLock() {
        return lock.tryLock();
    }

    public void release() {
        lock.unlock();
    }

    public int getId() {
        return id;
    }
}
