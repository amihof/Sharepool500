package Shared;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;

public class Buffer<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -689559181872181133L;
    private LinkedList<T> buffer = new LinkedList<T>();

    public synchronized void put(T obj) {
        buffer.addLast(obj);
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while(buffer.isEmpty()) {
            wait();
        }
        return buffer.removeFirst();
    }

    public int size() {
        return buffer.size();
    }
}
