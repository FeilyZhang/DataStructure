/**  
 * @Title:  TreeNode.java   
 * @Package tech.feily.dataStructure   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: Feily Zhang     
 * @date:   2019年2月1日 下午1:27:58   
 * @version V1.0 
 * @Copyright: All rights Reserved, Designed By https://feily.tech
 */
package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019年2月1日下午1:27:58
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
