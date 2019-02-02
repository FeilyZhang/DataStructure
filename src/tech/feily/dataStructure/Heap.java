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
    
    public int delete() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The big top heap is empty.");
        }
        int deleteElement = elements[1];    // Ҫɾ���Ľڵ㣬��ô���ڵ��Ϊ��
        elements[1] = elements[elements[0]];    // ������β����ֵ�滻�����ڵ�
        elements[0] --; // ���ȼ�һ����Ϊ���һ���ڵ��Ѿ�������Ϊ1��λ�ã������һ���ڵ��Ѿ��Ǹ��ڵ�
        // �������һ���ڵ�һ������²���������ԣ�����������������
        // ����ʱ������ڵ㣬��ΪҪ���������ԣ���ȡ�ķ��������ڲ���������û�����
        // Ҳ����˵���ջ�ճ���һ��λ�ã����λ�þ���temp�ڵ��λ�ã�ֱ�����ȥ����
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
