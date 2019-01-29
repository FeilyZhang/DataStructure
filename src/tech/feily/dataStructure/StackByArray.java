package tech.feily.dataStructure;

import java.util.Arrays;

/**
 * @author Administrator 
 * @date : 2019年1月29日下午3:16:09
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class StackByArray {

    private int size = 0;
    private int[] array;
    
    public StackByArray(int length) {
        array = new int[length];
    }
    
    public StackByArray() {
        this(10);
    }
    
    public void resize() {
        int[] oldArray = array;
        array = Arrays.copyOf(oldArray, oldArray.length * 2);
    }
    
    public void push(int data) {
        if (size == array.length) {
            resize();
        }
        array[size ++] = data;
    }
    
    public int peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty.");
        }
        return array[size - 1]; //因为该栈基于数组，即下标从0开始，那么最后一个元素就需要size - 1
    }
    
    public int pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty.");
        }
        int temp = peek();
        size --;
        return temp;
    }
    
    public boolean isFull() {
        return size == array.length;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
}
