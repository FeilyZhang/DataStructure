package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019��1��29������2:06:49
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
     * emmm,�������Ϊ�գ���size == 0����ô�͵��ø÷����ѵ�ǰdata�Ľ������Ϊ���׺���β
     */
    public void fillFirst(int data) {
        Node node = new Node();
        node.setData(data);
        last = first = node;
        size ++;
    }
    
    /*
     * emmm,Ҫ���ж������Ƿ�Ϊ�գ����Ϊ�գ���ô����fillFirst()����������ı���β��ָ���ϵ
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
     * emmm,Ҫ���ж������Ƿ�Ϊ�գ����Ϊ�գ���ô����fillFirst()����������ı����׵�ָ���ϵ
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
     * emmm���������ָ��λ�ò���
     * 
     * @param index �±��0��ʼ
     * @param data Ҫ����Ľ�������
     */
    public void add(int data, int index) {
        if (index < size) {
            if (size == 0) {
                fillFirst(data);
            } else if (index == 0) {    //��ͬ��ֱ�Ӳ�������
                addFirst(data);
            } else if (index == size - 1) {
                addLast(data);
            } else {
                Node temp = get(index); //�Ȼ�ȡ��ǰ��index���Ľ��
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
        } else if (size == 1) { //���ֻ��һ��Ԫ�أ���ô��ֱ���������
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
            // ��Ϊget��������0��ʼ����ô��������һ��������size - 1����һ��������size - 2
            Node temp = get(size - 2);  
            temp.setNext(null);
            size --;
        }
    }
    
    public void remove(int index) {
        if (index < size) {
            if (size == 0) {
                return;
            } else if (index == 0) {    //��ͬ��ֱ��ɾ������
                removeFirst();
                return;
            } else if (index == size - 1) {    //��ͬ��ֱ��ɾ����β
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
