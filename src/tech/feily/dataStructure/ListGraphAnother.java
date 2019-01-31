package tech.feily.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator 
 * @date : 2019年1月31日下午1:19:36
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class ListGraphAnother {

    private ListGraphNodeAnother[] nodes;
    private Map<Object, Integer> map = new HashMap<Object, Integer>();   // 该哈希表记录顶点及其在顶点集中的索引，方便set索引index至顶点的index属性中
    
    public ListGraphAnother(Object[] vertexes) {
        nodes = new ListGraphNodeAnother[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            nodes[i] = new ListGraphNodeAnother(vertexes[i], i, null);  // 每个顶点的index就是顶点集中的索引
            map.put(vertexes[i], i);   // 保存每个顶点在顶点集数组中的索引，方便后续直接提取设置
        }
    }
    
    public void addEdge(Object start, Object[] end) {
        // 先得到顶点start的索引，因为该索引与数组nodes中的索引一致那么就可以提取出ListGraphNodeAnother型顶点start
        int index = map.get(start);
        ListGraphNodeAnother node = nodes[index];
        // 遍历end数组，设置链接表
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
