package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019年1月29日下午2:03:31
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class Node {
    
    private int data;
    private Node next;
    
    public void setData(int data) {
        this.data = data;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public int getData() {
        return data;
    }
    
    public Node getNext() {
        return next;
    }
}
