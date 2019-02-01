package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019��2��1������12:26:34
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
     * emmm,���ĳ�����������нڵ�
     */
    public void clear(BinaryTreeNode node) {
        if (node != null) {
            clear(node.getLeftChild()); //�ݹ��ɾ�����ӽڵ�
            clear(node.getRightChild());    //�ݹ��ɾ�����ӽڵ�
            node = null;    //ɾ���ڵ�
        }
    }
    
    /*
     * emmm,�����
     */
    public void clear() {
        clear(root);
    }
    
    /*
     * emmm,�ж϶������Ƿ�Ϊ�գ���ôֻ��Ҫ�ж϶��������ڵ��Ƿ�Ϊnull����
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /*
     * emmm,��ȡ�������ĸ߶�
     */
    public int height() {
        return height(root);
    }
    
    /*
     * emmm,��ȡĳ�ڵ�Ϊ�����ĸ߶�
     */
    public int height(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int left = height(node.getLeftChild()); // �ݹ�Ļ�ȡ�������ĸ߶�
            int right = height(node.getRightChild());    // �ݹ�Ļ�ȡ�������ĸ߶�
            // �߶�Ӧ������ߵ�һ�ߣ���1����ΪҪ�����Լ���һ��
            return left < right ? right + 1 : left + 1; //��������ִ���������
        }
    }
    
    /*
     * emmm,��ȡ�������Ľڵ���
     */
    public int size() {
        return size(root);
    }
    
    /*
     * emmm,��ȡĳ�ڵ�Ϊ�����Ľڵ���
     */
    public int size(BinaryTreeNode node) {
        // ������Ϊ�գ���ôֱ�ӷ���0
        if (node == null) {
            return 0;
        } else {
            // ����ݹ�Ļ�ȡ�������Ľڵ������������Ľڵ��������
            // ��1����ΪҪ���㱾�ڵ�
            return 1 + size(node.getLeftChild()) + size(node.getRightChild());
        }
    }
    
    /*
     * emmm,���ҽ���������������еĸ��ڵ㣬���Ը��ڵ�Ϊ���������������
     */
    public BinaryTreeNode getParent(BinaryTreeNode node) {
        // ���ڵ�û�и��ڵ㣬ֱ�ӷ���null
        return (root == null || root == node) ? null : getParent(root, node);
    }
    
    /*
     * emmm,�ݹ����node�����subTree�����еĸ��ڵ�
     */
    public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
        // �������subTreeΪ�գ���ô�ڵ�nodeû�и��ڵ�
        if (subTree == null) {
            return null;
        }
        // ������������ӽڵ�����Һ��ӽڵ���node����ôֱ�ӷ�������(��һ���ڵ����)
        // ʵ���ϣ�����ж��������������жϴ���
        if (subTree.getLeftChild() == node || subTree.getRightChild() == node) {
            return subTree;
        }
        BinaryTreeNode parent = null;
        // ��Ϊnode�ڵ�������subTree�еĸ��ڵ��п������������ϣ�Ҳ�п������������ϣ���ô��Ҫ�����ж�
        // ���������������ôֱ�ӷ���parent
        if ((parent = getParent(subTree.getLeftChild(), node)) != null) {
            return parent;
        } else {
            // ����ݹ�������
            return getParent(subTree.getRightChild(), node);
        }
    }
}
