package tech.feily.dataStructure;

/**
 * @author : Feily Zhang
 * @date : 2019-2-2 11:48:43
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class Heap {

    private int[] elements;
    
    public Heap(int length) {
        elements = new int[length + 1];
        elements[0] = 0;
    }
    
    public boolean isEmpty() {
        return elements[0] == 0;
    }
    
    public boolean isFull() {
        return elements[0] == elements.length - 1;
    }
    
    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("The big top heap is full.");
        }
        if (isEmpty()) {
            elements[1] = value;
        } else {
            int i = elements[0] + 1;    //ȷ������ĳ�ʼλ�ã�Ϊ������ȵ����һ���ڵ�
            // ��������Ԫ�ش��ڸ��ڵ㣬��ô�ý����ڵ��������ƣ�Ȼ��value����������λ��
            while (i != 1 && value > elements[i / 2]) {
                elements[i] = elements[i / 2];
                i /= 2;
            }
            // ���ս�ֵ���뵽ָ��λ��
            elements[i] = value;
        }
        elements[0] ++; //Ԫ�ظ�����һ
    }
    
    /*
     * emmm,��ӡ�ķ����ܼ򵥣���Ϊ����������ģ��ģ���ôֱ�ӱ������鼴��
     */
    public void printAll() {
        for (int element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(12);
        heap.insert(21);
        heap.insert(6);
        heap.insert(35);
        heap.insert(58);
        heap.printAll();
    }
}
