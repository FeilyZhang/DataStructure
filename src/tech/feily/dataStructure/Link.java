package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019年1月29日下午2:06:49
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class Link {
    
    private int size = 0;
    private Node first;
    private Node last;
    
    public Link() {
        
    }
    
    /*
     * emmm,如果链表为空，即size == 0，那么就调用该方法把当前data的结点设置为链首和链尾
     */
    public void fillFirst(int data) {
        Node node = new Node();
        node.setData(data);
        last = first = node;
        size ++;
    }
    
    /*
     * emmm,要先判断链表是否为空，如果为空，那么调用fillFirst()方法，否则改变链尾的指向关系
     */
    public void addLast(int data) {
        if (size == 0) {
            fillFirst(data);
        } else {
            Node node = new Node();
            node.setData(data);
            last.setNext(node);
            last = node;
            size ++;
        }
    }

    /*
     * emmm,要先判断链表是否为空，如果为空，那么调用fillFirst()方法，否则改变链首的指向关系
     */
    public void addFirst(int data) {
        if (size == 0) {
            fillFirst(data);
        } else {
            Node node = new Node();
            node.setData(data);
            node.setNext(first);
            first = node;
            size ++;
        }
    }
    
    public Node get(int index) {
        Node temp = null;
        if (index < size) {
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        } else {
            throw new IndexOutOfBoundsException("The index is out of bounds, the element does not exist");
        }
        return temp;
    }
    
    /*
     * emmm，在链表的指定位置插入
     * 
     * @param index 下标从0开始
     * @param data 要插入的结点的数据
     */
    public void add(int data, int index) {
        if (index < size) {
            if (size == 0) {
                fillFirst(data);
            } else if (index == 0) {    //等同于直接插入链首
                addFirst(data);
            } else if (index == size - 1) {
                addLast(data);
            } else {
                Node temp = get(index); //先获取当前该index处的结点
                Node node = new Node();
                node.setData(data);
                node.setNext(temp.getNext());
                temp.setNext(node);
                size ++;
            }
        } else {
            throw new IndexOutOfBoundsException("The index is out of bounds, the element does not exist.");
        }
    }
    
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
    
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("The linked list has no elements.");
        } else if (size == 1) { //如果只有一个元素，那么就直接清空链表
            clear();
        } else {
            Node temp = first;
            first = temp.getNext();
            temp = null;
            size --;
        }
    }
    
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("The linked list has no elements.");
        } else if (size == 1) {
            clear();
        } else {
            // 因为get的索引从0开始，那么链表的最后一个结点就是size - 1，上一个结点就是size - 2
            Node temp = get(size - 2);  
            temp.setNext(null);
            size --;
        }
    }
    
    public void remove(int index) {
        if (index < size) {
            if (size == 0) {
                return;
            } else if (index == 0) {    //等同于直接删除链首
                removeFirst();
                return;
            } else if (index == size - 1) {    //等同于直接删除链尾
               removeLast();
               return;
            } else {
                Node node = get(index);
                Node preNode = get(index - 1);
                preNode.setNext(node.getNext());
                node = null;
                return;
            }
        } else {
            throw new IndexOutOfBoundsException("The index is out of bounds, the element does not exist.");
        }
    }
    
    public int size() {
        return size;
    }
    
}
