package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019年1月31日下午1:26:35
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class EntryAnother {
    
    Object key;
    int value;
    EntryAnother next;
    
    public EntryAnother(Object key, int value, EntryAnother next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
