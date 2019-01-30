package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019年1月30日下午10:50:48
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class ListGraphNode {

    private Object value;
    private ListGraphNode next;
    
    public ListGraphNode(Object value, ListGraphNode next) {
        this.value = value;
        this.next = next;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    
    public void setNext(ListGraphNode next) {
        this.next = next;
    }
    
    public Object getValue() {
        return value;
    }
    
    public ListGraphNode getNext() {
        return next;
    }
    
}
