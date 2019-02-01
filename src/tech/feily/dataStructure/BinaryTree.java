package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019年2月1日下午12:26:34
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class BinaryTree {

    private BinaryTreeNode root;
    
    public BinaryTree() {
        
    }
    
    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }
    
    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
    
    public BinaryTreeNode getRoot() {
        return root;
    }
    
    /*
     * emmm,清除某个子树的所有节点
     */
    public void clear(BinaryTreeNode node) {
        if (node != null) {
            clear(node.getLeftChild()); //递归地删除左子节点
            clear(node.getRightChild());    //递归的删除右子节点
            node = null;    //删除节点
        }
    }
    
    /*
     * emmm,清空树
     */
    public void clear() {
        clear(root);
    }
    
    /*
     * emmm,判断二叉树是否为空，那么只需要判断二叉树根节点是否为null即可
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /*
     * emmm,获取二叉树的高度
     */
    public int height() {
        return height(root);
    }
    
    /*
     * emmm,获取某节点为子树的高度
     */
    public int height(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = height(node.getLeftChild()); // 递归的获取左子树的高度
            int right = height(node.getRightChild());    // 递归的获取右子树的高度
            // 高度应该算更高的一边，加1是因为要加上自己这一层
            return left < right ? right + 1 : left + 1; //归根结底是执行这条语句
        }
    }
    
    /*
     * emmm,获取二叉树的节点数
     */
    public int size() {
        return size(root);
    }
    
    /*
     * emmm,获取某节点为子树的节点数
     */
    public int size(BinaryTreeNode node) {
        // 如果结点为空，那么直接返回0
        if (node == null) {
            return 0;
        } else {
            // 否则递归的获取左子树的节点数和右子树的节点数并相加
            // 加1是因为要计算本节点
            return 1 + size(node.getLeftChild()) + size(node.getRightChild());
        }
    }
    
    /*
     * emmm,查找结点在整个二叉树中的父节点，即以根节点为代表的整个二叉树
     */
    public BinaryTreeNode getParent(BinaryTreeNode node) {
        // 根节点没有父节点，直接返回null
        return (root == null || root == node) ? null : getParent(root, node);
    }
    
    /*
     * emmm,递归查找node结点在subTree子树中的父节点
     */
    public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
        // 如果子树subTree为空，那么节点node没有父节点
        if (subTree == null) {
            return null;
        }
        // 如果子树的左孩子节点或者右孩子节点是node，那么直接返回子树(以一个节点代表)
        // 实际上，这个判断语句才是真正的判断代码
        if (subTree.getLeftChild() == node || subTree.getRightChild() == node) {
            return subTree;
        }
        BinaryTreeNode parent = null;
        // 因为node节点在子树subTree中的父节点有可能在左子树上，也有可能在右子树上，那么就要分类判断
        // 如果在左子树，那么直接返回parent
        if ((parent = getParent(subTree.getLeftChild(), node)) != null) {
            return parent;
        } else {
            // 否则递归右子树
            return getParent(subTree.getRightChild(), node);
        }
    }
}
