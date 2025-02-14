package org.java5thsem.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {
    private final int capacity;
    private int currentContainers;
    private final Lock lock = new ReentrantLock();

    public Warehouse(int capacity) {
        this.capacity = capacity;
        this.currentContainers = capacity / 2;
    }

    public boolean loadContainers(int amount) {
        lock.lock();
        try {
            if (currentContainers >= amount) {
                currentContainers -= amount;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean unloadContainers(int amount) {
        lock.lock();
        try {
            if (currentContainers + amount <= capacity) {
                currentContainers += amount;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}
