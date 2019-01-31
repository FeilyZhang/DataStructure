package tech.feily.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator 
 * @date : 2019��1��31������1:19:36
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class ListGraphAnother {

    private ListGraphNodeAnother[] nodes;
    private Map<Object, Integer> map = new HashMap<Object, Integer>();   // �ù�ϣ���¼���㼰���ڶ��㼯�е�����������set����index�������index������
    
    public ListGraphAnother(Object[] vertexes) {
        nodes = new ListGraphNodeAnother[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            nodes[i] = new ListGraphNodeAnother(vertexes[i], i, null);  // ÿ�������index���Ƕ��㼯�е�����
            map.put(vertexes[i], i);   // ����ÿ�������ڶ��㼯�����е��������������ֱ����ȡ����
        }
    }
    
    public void addEdge(Object start, Object[] end) {
        // �ȵõ�����start����������Ϊ������������nodes�е�����һ����ô�Ϳ�����ȡ��ListGraphNodeAnother�Ͷ���start
        int index = map.get(start);
        ListGraphNodeAnother node = nodes[index];
        // ����end���飬�������ӱ�
        for (int i = 0; i < end.length; i++) {
            int j = map.get(end[i]);
            node.setNext(new ListGraphNodeAnother(end[i], j, null));
            node = node.getNext();
        }
    }

    public void printListGraph() {
        for (int i = 0; i < nodes.length; i++) {
            ListGraphNodeAnother node = nodes[i];
            do {
                System.out.print(node.getValue() + "->");
                node = node.getNext();
            } while (node != null);
            System.out.println();
        }
    }
    
    public int getUnVisited(int[] visited) {
        int index = -1;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public void depthFirstTravel() {
        System.out.println("Depth-first traversal of linked tables:");
        StackByArray stack = new StackByArray();
        int[] visited = new int[nodes.length];
        int unVisited = getUnVisited(visited);
        while (unVisited >= 0) {
            visited[unVisited] = 1;
            stack.push(unVisited);
            System.out.print(nodes[unVisited].getValue() + ",");
            while (!stack.isEmpty()) {
                int index = stack.peek();
                boolean found = false;
                ListGraphNodeAnother node = nodes[index];
                while (node != null) {
                    if (node.getNext() != null && visited[node.getNext().getIndex()] == 0) {
                        visited[node.getNext().getIndex()] = 1;
                        stack.push(node.getNext().getIndex());
                        System.out.print(node.getNext().getValue() + ",");
                        found = true;
                        break;
                    }
                    node = node.getNext();
                }
                if (!found) {
                    stack.pop();
                }
            }
            unVisited = getUnVisited(visited);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] vertexes = {0, 1, 2, 3, 4, 5, 6};
        ListGraphAnother graph = new ListGraphAnother(vertexes);
        graph.addEdge(0, new Integer[]{1, 2});
        graph.addEdge(1, new Integer[]{3, 4});
        graph.addEdge(2, new Integer[]{5, 6});
        graph.printListGraph();
        graph.depthFirstTravel();
    }
}
