/**  
 * @Title:  TreeNode.java   
 * @Package tech.feily.dataStructure   
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: Feily Zhang     
 * @date:   2019��2��1�� ����1:27:58   
 * @version V1.0 
 * @Copyright: All rights Reserved, Designed By https://feily.tech
 */
package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019��2��1������1:27:58
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class TreeNode {

    public int value;
    public int index;
    
    public TreeNode(int value, int index) {
        this.value = value;
        this.index = index;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getValue() {
        return value;
    }
    
    public int getIndex() {
        return index;
    }
    
    @Override
    public String toString() {
       return "TreeNode : value = " + value + ", index = " + index;
    }
}
