package org.java5thsem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static Port instance;
    private static final Lock lock = new ReentrantLock();
    private final List<Dock> docks;
    private final Warehouse warehouse;

    private Port(int dockCount, int warehouseCapacity) {
        this.docks = new ArrayList<>();
        for (int i = 0; i < dockCount; i++) {
            docks.add(new Dock(i + 1));
        }
        this.warehouse = new Warehouse(warehouseCapacity);
    }

    public static Port getInstance(int dockCount, int warehouseCapacity) {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Port(dockCount, warehouseCapacity);
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public Dock getAvailableDock() {
        for (Dock dock : docks) {
            if (dock.tryLock()) {
                return dock;
            }
        }
        return null;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
