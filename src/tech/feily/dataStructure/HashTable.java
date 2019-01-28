package tech.feily.dataStructure;

/**
 * @author : Feily Zhang
 * @date : 2019-1-28 9:30:33
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class HashTable {

    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final float LOAD_FACTOR = 0.75f;
    
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size = 0;
    private int use = 0;

    public int hash(int key) {
        return key % table.length;
    }
    
    public void resize() {
        
    }
    
    public void put(int key, int value) {
        int index = hash(key);  //得到key的地址
        // 接下来探索该地址处是否为null，如果为null那么说明没有元素，该元素就是该地址的链首
        // 如果不为null，那么说明该地址有元素，那么就将该元素的后继节点设置为原先的首节点
        if (table[index] == null) {
            table[index] = new Entry(-1, -1, null); //设置该地址的值，用于区分是否该地址有元素，null指的是该地址的链表没有元素
        }
        // 接下来先获取该地址的链表起始然后进行插入操作
        Entry e = table[index];
        // 然后看该起始是否有元素，有的话把前驱变为后继，否则直接设置为链首
        if (e.next == null) {   //说明链首不存在元素，那么就直接设置元素为链首
            table[index].next = new Entry(key, value, null);
            size ++;
            use ++;
            if (use >= table.length * LOAD_FACTOR) {
                resize();
            }
        } else {    // 说明链首存在元素，那么前驱改后继
            // 还有一种情况是，哈希表不允许有重复的key，如果key已经存在那么就会修改其值为最新的value
            // 那么就遍历链表，看是否存在该key
            // 初始条件是e = e.next是因为index地址处的元素是说明该地址存在链表，但是需要next才会得到链首
            for (e = e.next; e != null; e = e.next) {
                if (e.key == key) {
                    e.value = value;
                    return; //存在key，那么设置完之后提前终止
                }
            }
            // 遍历过后发现不存在key，那么就前驱变后继
            Entry oldStart = table[index].next;    // 获取链首元素
            table[index].next = new Entry(key, value, oldStart);   //设置链首为当前元素，当前元素的后继为以前的链首，即第三个参数
            size++;
        }
    }
    
    /*
     * e和pre两个变量，删除元素需要获取前驱结点，并将前驱结点指向要删除结点的后继上，所以需要pre和e两个变量
     * pre为前驱结点，e为当前节点，删除意味着pre.next = e.next，即将当前节点e的前驱结点pre的后继指向当前节点e的后继节点e.next上
     */
    public void remove(int key) {
        int index = hash(key);
        Entry e = table[index];    // 如果e为null，那么说明该地址无链表即该地址不存在key的值
        Entry pre = table[index];  // 前驱结点暂定为table[index]
        // e.next可有可能为null，因为可能该地址有链表但是无链首，所以也要考虑在内
        if (e != null && e.next != null) {
            for (e = e.next; e != null; pre = e, e = e.next) {
                if (e.key == key) {
                    pre.next = e.next;
                    size --;
                    return;
                }
            }
        }
    }
    
    /*
     * emmmm,获取元素并不需要前驱结点，只需要当前e就好了
     */
    public int get(int key) {
        int index = hash(key);
        Entry e = table[index];
        if (e != null && e.next != null) {
            for (e = e.next; e != null; e = e.next) {
                if (e.key == key) {
                    return e.value;
                }
            }
        }
        return -1;
    }
}
