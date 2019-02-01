package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019年2月1日下午12:21:21
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class BinaryTreeNode {

    private Object data;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
    
    public void setData(Object data) {
        this.data = data;
    }
    
    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }
    
    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
    public Object getData() {
        return data;
    }
    
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }
    
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }
}
