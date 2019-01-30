package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019��1��30������10:55:07
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class ListGraph {

    private ListGraphNode[] nodes;  // �����鱣�����еĶ���
    
    public ListGraph(Object[] vertexes) {
        nodes = new ListGraphNode[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            nodes[i] = new ListGraphNode(vertexes[i], null);
        }
    }
    
    public void addEdge(Object start, Object[] end) {
        // ��ѭ����Ȼ���ҵ�����start������nodes�е�������Ȼ��Ϳ��Զ�λ����Ӧ��ListGraphNode��Ԫ��
        // Ȼ��Ϳ��԰�end�����еĶ��������������͹����˶���start��end������Ԫ�صı�
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getValue().equals(start)) {    // ��ô��˵����λ����start������
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
