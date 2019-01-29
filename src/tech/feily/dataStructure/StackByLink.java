package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019-1-29 16:53:20
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class StackByLink {

    private Link link = new Link();
    
    public void push(int data) {
        link.addLast(data);
    }
    
    public int peek(int data) {
        return link.get(link.size() - 1).getData();
    }
    
    public int pop() {
        int temp = link.get(link.size() - 1).getData();
        link.removeLast();
        return temp;
    }
    
    public boolean isEmpty() {
        return link.size() == 0;
    }
    
    public int size() {
        return link.size();
    }
}
