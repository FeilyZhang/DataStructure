package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019年1月30日下午10:55:07
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class ListGraph {

    private ListGraphNode[] nodes;  // 该数组保存所有的顶点
    
    public ListGraph(Object[] vertexes) {
        nodes = new ListGraphNode[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            nodes[i] = new ListGraphNode(vertexes[i], null);
        }
    }
    
    public void addEdge(Object start, Object[] end) {
        // 该循环仍然是找到顶点start在数组nodes中的索引，然后就可以定位到相应的ListGraphNode型元素
        // 然后就可以把end数组中的顶点连接起来，就构成了顶点start与end数组中元素的边
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getValue().equals(start)) {    // 那么就说明定位到了start的索引
                ListGraphNode node = nodes[i];
                for (int j = 0; j < end.length; j++) {
                    node.setNext(new ListGraphNode(end[j], null));
                    node = node.getNext();
                }
            }
        }
    }
    
    public void printListGraph() {
        for (int i = 0; i < nodes.length; i++) {
            ListGraphNode node = nodes[i];
            do {
                System.out.print(node.getValue() + " ");
                node = node.getNext();
            } while (node != null);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Integer[] vertexes = {0, 1, 2, 3};
        ListGraph nodes = new ListGraph(vertexes);
        nodes.addEdge(0, new Integer[]{1, 2, 3});
        nodes.addEdge(1, new Integer[]{2});
        nodes.addEdge(3, new Integer[]{2});
        nodes.printListGraph();
        
    }
}
