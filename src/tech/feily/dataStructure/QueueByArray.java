package tech.feily.dataStructure;

/**
 * @author : Feily Zhang
 * @date : 2019-1-29 18:36:39
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class QueueByArray {

    private int head = 0;
    private int tail = 0;
    private Object[] array;
    
    public QueueByArray(int size) {
        array = new Object[size];
    }
    
    public QueueByArray() {
        this(10);
    }
    
    public boolean push(Object data) {
        if (head == (tail + 1) % array.length) {
            return false;
        }
        array[tail] = data;
        tail = (tail + 1) % array.length;
        return true;
    }
    
    public Object peek() {
        if (head == tail) {
            return null;
        }
        return array[head];
    }
    
    public Object pop() {
        if (head == tail) {
            return null;
        }
        Object temp = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        return temp;
    }
    
    public boolean isEmpty() {
        return tail == head;
    }
    
    public int size() {
        if (tail >= head) { //说明还是单向队列
            return tail - head;
        } else {    // 已经变成循环队列
            return tail + (array.length - head);
        }
    }
    
}
