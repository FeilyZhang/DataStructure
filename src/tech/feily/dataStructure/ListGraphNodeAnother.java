package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019��1��31������1:14:04
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class ListGraphNodeAnother {

    private Object value;
    private int index;  // ���ֶμ�¼�ö����ڶ��㼯(��������)�е��������������̽��
    private ListGraphNodeAnother next;
    
    public ListGraphNodeAnother(Object value, int index, ListGraphNodeAnother next) {
        this.value = value;
        this.index = index;
        this.next = next;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public void setNext(ListGraphNodeAnother next) {
        this.next = next;
    }
    
    public Object getValue() {
        return value;
    }
    
    public int getIndex() {
        return index;
    }
    
    public ListGraphNodeAnother getNext() {
        return next;
    }
    
}
