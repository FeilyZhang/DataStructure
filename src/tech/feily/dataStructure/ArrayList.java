package tech.feily.dataStructure;

import java.util.Arrays;

/**
 * @author : Feily Zhang
 * @date : 2019-1-28 4:22:12
 * @version : V1.0 
 * @Description : Array-based list implementation.
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class ArrayList {

    private static final int INITIAL_SIZE = 10;
    private int size = 0;
    private int[] array;
    
    public ArrayList() {
        this(INITIAL_SIZE);
    }
    
    public ArrayList(int size) {
        array = new int[size];
    }
    
    public void add(int num) {
        if (size == array.length) {
            resize();
        }
        array[size++] = num;
    }
    
    public int get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("The index is out of bounds, the element does not exist");
        }
        return array[index];
    }
    
    public int set(int index, int num) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("The index is out of bounds, the element does not exist");
        }
        int oldEle = get(index);
        array[index] = num;
        return oldEle;
    }
    
    public int size() {
        return size;
    }
    
    public int length() {
        return array.length;
    }
    
    public void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }
}

