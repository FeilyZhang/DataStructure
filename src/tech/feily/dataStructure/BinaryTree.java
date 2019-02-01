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
    
    /*
     * emmm,获取某个节点的左子树，可以直接返回该节点的左孩子
     */
    public BinaryTreeNode getLeftTree(BinaryTreeNode node) {
        return node.getLeftChild();
    }
    
    /*
     * emmm,获取某个节点的右子树，可以直接返回该节点的右孩子
     */
    public BinaryTreeNode getRightTree(BinaryTreeNode node) {
        return node.getRightChild();
    }
    
    /*
     * emmm,二叉树的左插入
     * emmm,直接让父节点设置左孩子为结点node，如果该父节点parent已经有左孩子那么该操作会覆盖原先的孩子节点
     */
    public void insertLeft(BinaryTreeNode parent, BinaryTreeNode node) {
        parent.setLeftChild(node);
    }

    /*
     * emmm,二叉树的右插入
     * emmm,直接让父节点设置右孩子为结点node，如果该父节点parent已经有右孩子那么该操作会覆盖原先的孩子节点
     */
    public void insertRight(BinaryTreeNode parent, BinaryTreeNode node) {
        parent.setRightChild(node);
    }
    
    /*
     * emmm,输出二叉树结点的数据
     */
    public void visited(BinaryTreeNode node) {
        System.out.println(node.getData().toString());
    }
    
    /*
     * emmm,先根遍历，顺序如下
     * 1. 访问根节点,即先根
     * 2. 先根遍历左子树
     * 3. 先根遍历右子树
     * 4. 退出
     */
    public void preOrder(BinaryTreeNode node) {
        if (node != null) {
            visited(node);  // 先访问根节点
            preOrder(node.getLeftChild());  //再遍历左子树
            preOrder(node.getRightChild()); //再遍历右子树
        }   // 退出
    }
    
    /*
     * emmm,中根遍历，顺序如下
     * 1. 中根遍历左子树
     * 2. 访问根节点
     * 3. 中根遍历右子树
     * 4. 退出
     */
    public void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.getLeftChild());   // 中根遍历左子树
            visited(node);  // 访问根节点
            inOrder(node.getRightChild());  // 中根遍历右子树
        }   // 退出
    }
    
    /*
     * emmm,中根遍历，顺序如下
     * 1. 后根遍历左子树
     * 2. 后根遍历右子树
     * 3. 访问根节点
     * 4. 退出
     */
    public void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.getLeftChild()); // 后根遍历左子树
            postOrder(node.getRightChild());    // 后根遍历右子树
            visited(node);  //访问根节点
        }   //退出
    }
    
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode btn = new BinaryTreeNode();
        btn.setData(new TreeNode(0, 0));
        bt.setRoot(btn);
        BinaryTreeNode leftBtn = new BinaryTreeNode();
        leftBtn.setData(new TreeNode(1, 1));
        BinaryTreeNode rightBtn = new BinaryTreeNode();
        rightBtn.setData(new TreeNode(2, 2));
        bt.getRoot().setLeftChild(leftBtn);
        bt.getRoot().setRightChild(rightBtn);
        bt.preOrder(bt.getRoot());
        System.out.println("------");
        bt.inOrder(bt.getRoot());
        System.out.println("------");
        bt.postOrder(bt.getRoot());
    }
}
