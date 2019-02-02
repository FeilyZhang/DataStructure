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
            int i = elements[0] + 1;    //确定插入的初始位置，为广度优先的最后一个节点
            // 如果插入的元素大于父节点，那么久将父节点依次下移，然后将value调补到合适位置
            while (i != 1 && value > elements[i / 2]) {
                elements[i] = elements[i / 2];
                i /= 2;
            }
            // 最终将值插入到指定位置
            elements[i] = value;
        }
        elements[0] ++; //元素个数加一
    }
    
    /*
     * emmm,打印的方法很简单，因为堆是用数组模拟的，那么直接遍历数组即可
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
