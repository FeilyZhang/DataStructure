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
    
    public int delete() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The big top heap is empty.");
        }
        int deleteElement = elements[1];    // 要删除的节点，那么根节点会为空
        elements[1] = elements[elements[0]];    // 将数组尾部的值替换到根节点
        elements[0] --; // 长度减一，因为最后一个节点已经在索引为1的位置，即最后一个节点已经是根节点
        // 但是最后一个节点一般情况下不满足堆属性，接下来修正堆属性
        // 先临时保存根节点，因为要修正堆属性，采取的方法类似于插入排序的置换方法
        // 也就是说最终会空出来一个位置，这个位置就是temp节点的位置，直接填补上去即可
        int temp = elements[1];
        int parent = 1;
        int child = 2;
        while (child <= elements[0]) {
            if (child < elements[0] && elements[child] < elements[child + 1]) {
                child ++;
            }
            if (temp > elements[child]) {
                break;
            } else {
                elements[parent] = elements[child];
                parent = child;
                child += 2;
            }
        }
        elements[parent] = temp;
        return deleteElement;
    }
    
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(12);
        heap.insert(21);
        heap.insert(6);
        heap.insert(35);
        heap.insert(58);
        heap.printAll();
        System.out.println(heap.delete());
        heap.printAll();
    }
}
