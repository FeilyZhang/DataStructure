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

    public void breadthFirstTravel() {
        System.out.println("Breadth-first traversal of adjacency tables:");
        QueueByArray queue = new QueueByArray(nodes.length);
        int[] visited = new int[nodes.length];
        int unVisited = getUnVisited(visited);
        // 虽然说顶点只会被探索一次，但是可能会存在孤立的顶点，而每个独立的顶点又有与之相关联的其余顶点
        // 所以在探索完当前起始顶点之后，如果顶点状态数组中还有未被探索的顶点，那么一定是独立的顶点
        // 该独立的顶点又是一个起始顶点，会再次探索与该孤立的起始顶点相关的其余顶点
        // 也就是说每进行一次该外层循环，就意味着少一个独立的顶点串
        while (unVisited >= 0) {
            // 起始顶点入队
            queue.push(unVisited);
            while (!queue.isEmpty()) {
                int index = (Integer)queue.pop();
                System.out.print(nodes[index].getValue() + ",");
                visited[index] = 1; // 标记被访问
                // 遍历所有(记住，是所有，因为是广度优先遍历)未被访问的邻接顶点，放入队列中
                ListGraphNodeAnother node = nodes[index].getNext();
                while (node != null) {
                    if (visited[node.getIndex()] == 0) {
                        queue.push(node.getIndex());    // 为什么一定要得到index？因为index是该顶点的索引，而这个索引又是顶点状态的索引，这样就可以知道该顶点是否被探索
                    }
                    node = node.getNext();
                }
            }
            // 得到孤立的顶点串，再次执行循环，邓然要判断是否有被孤立的顶点串，是通过unVisited是否为-1得到的，即外层循环是否满足
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
