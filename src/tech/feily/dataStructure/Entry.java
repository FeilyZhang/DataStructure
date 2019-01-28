package tech.feily.dataStructure;

/**
 * @author : Feily Zhang
 * @date : 2019-1-28 9:27:28
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class Entry {
    
    int key;
    int value;
    Entry next;
    
    public Entry(int key, int value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
