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

    public void breadthFirstTravel() {
        System.out.println("Breadth-first traversal of adjacency tables:");
        QueueByArray queue = new QueueByArray(nodes.length);
        int[] visited = new int[nodes.length];
        int unVisited = getUnVisited(visited);
        // ��Ȼ˵����ֻ�ᱻ̽��һ�Σ����ǿ��ܻ���ڹ����Ķ��㣬��ÿ�������Ķ���������֮����������ඥ��
        // ������̽���굱ǰ��ʼ����֮���������״̬�����л���δ��̽���Ķ��㣬��ôһ���Ƕ����Ķ���
        // �ö����Ķ�������һ����ʼ���㣬���ٴ�̽����ù�������ʼ������ص����ඥ��
        // Ҳ����˵ÿ����һ�θ����ѭ��������ζ����һ�������Ķ��㴮
        while (unVisited >= 0) {
            // ��ʼ�������
            queue.push(unVisited);
            while (!queue.isEmpty()) {
                int index = (Integer)queue.pop();
                System.out.print(nodes[index].getValue() + ",");
                visited[index] = 1; // ��Ǳ�����
                // ��������(��ס�������У���Ϊ�ǹ�����ȱ���)δ�����ʵ��ڽӶ��㣬���������
                ListGraphNodeAnother node = nodes[index].getNext();
                while (node != null) {
                    if (visited[node.getIndex()] == 0) {
                        queue.push(node.getIndex());    // Ϊʲôһ��Ҫ�õ�index����Ϊindex�Ǹö����������������������Ƕ���״̬�������������Ϳ���֪���ö����Ƿ�̽��
                    }
                    node = node.getNext();
                }
            }
            // �õ������Ķ��㴮���ٴ�ִ��ѭ������ȻҪ�ж��Ƿ��б������Ķ��㴮����ͨ��unVisited�Ƿ�Ϊ-1�õ��ģ������ѭ���Ƿ�����
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
        graph.breadthFirstTravel();
    }
}
