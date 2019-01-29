package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019年1月29日下午8:10:48
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class QueueByLink {

    private Link link = new Link();
    
    public void push(int data) {
        link.addLast(data);
    }
    
    public int peek() {
        return link.get(0).getData();
    }
    
    public int pop() {
        int temp = peek();
        link.removeFirst();
        return temp;
    }
    
    public int size() {
        return link.size();
    }
    
    public boolean isEmpty() {
        return link.size() == 0;
    }
    
}
