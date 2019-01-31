package tech.feily.dataStructure;

/**
 * @author Administrator 
 * @date : 2019-1-30 9:40:58
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class MatrixGraph {

    private Object[] mapping;
    private Object[][] matrix;
    
    public MatrixGraph(Object[] mapping) {
        int length = mapping.length;
        this.mapping = new Object[length];
        matrix = new Object[length][length];
        for (int i = 0; i < length; i++) {
            this.mapping[i] = mapping[i];
        }
    }
    
    /*
     * emmm，该方法通过确定start与end在矩阵matrix中的坐标，然后设置值为1，从而确定start与end间的边关系
     * @param start 该参数为起始顶点
     * @param end 该参数为终止顶点
     */
    public void addEdge(Object start, Object end) {
        int row = -1;
        int col = -1;
        // 寻找坐标
        for (int i = 0; i < mapping.length; i++) {
            // 初始坐标为row = -1, col = -1
            // 如果初始坐标发生变化，那么就可以认为已经寻找到了相应坐标
            if (row != -1 && col != -1) {
                break;
            }
            // 需要注意的是，如果顶点集的数据类型为int并且顶点连续(即0， 1， 2， 3)，那么这个步骤是可以省略的
            // 因为顶点本身就是坐标
            // 这里寻找坐标指的是一维顶点集的数据类型不为int且不连续，那么只能通过遍历顶点集的方式获取该数据在顶点集中的索引
            // 其实就是寻找顶点在mapping中的索引，也就是其在matrix中的坐标
            if (start == mapping[i]) {
                row = i;
            }
            
            if (end == mapping[i]) {
                col = i;
            }
        }
        
        // 判断该坐标是否合法(或存在)
        if (row == -1 || col == -1 || row > mapping.length - 1 || col > mapping.length - 1) {
            throw new IndexOutOfBoundsException("The vertex of the edge does not exist or the coordinates are illegal.");
        }
        matrix[row][col] = 1;   //设置坐标内容为1，那么即可说明顶点start(索引为row)与顶点end(索引为col)存在边
    }
    
    public void printMatrix() {
        // 这一步其实有点多余，因为我们的矩阵matrix的类型为Object
        // 如果我们不给它设置值的话，那么就是null
        // 不好看，我们将null替换为0,代码见第64行if (obj == null) obj = 0;
        for (Object[] object : matrix) {
            for (Object obj : object) {
                if (obj == null) obj = 0;
                System.out.print(obj + " ");
            }
            System.out.println();
        }
    }
    
    /*
     * emmm,从visited数组(顶点数组被访问状态数组)中找未被访问过的顶点
     * emmm,由于顶点在遍历中是唯一的，那么只要该顶点被探索，那么此后就一定不会再被探索
     */
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
        System.out.println("Depth-first traversal of adjacency matrix:");
        StackByArray stack = new StackByArray(mapping.length);
        int[] visited = new int[mapping.length];  // 初始化各顶点被访问状态，全部为0
        int unVisited = getUnVisited(visited);  // 从顶点被访问状态数组中找到一个未被访问过的顶点
        // 如果顶点都被访问，那额会返回-1，即会跳出该循环，代表遍历结束
        while (unVisited >= 0) {
            visited[unVisited] = 1;
            stack.push(unVisited);
            System.out.print(mapping[unVisited] + ",");
            while (!stack.isEmpty()) {
                int index = stack.peek();
                boolean found = false;
                for (int i = 0; i < mapping.length; i++) {
                    if (index != i && visited[i] == 0 && matrix[index][i] != null) {
                        visited[i] = 1;
                        stack.push(i);
                        System.out.print(mapping[i] + ",");
                        found = true;
                        break;
                    }
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
        System.out.println("Breadth-first traversal of adjacency matrix:");
        QueueByArray queue = new QueueByArray(mapping.length);
        int[] visited = new int[mapping.length];
        int unVisited = getUnVisited(visited);
        while (unVisited >= 0) {    //那么说明还有未探索的顶点
            // 起始顶点入队
            queue.push(unVisited);
            while (!queue.isEmpty()) {  //队列不为空，那么说明还有顶点未被探索
                int index = (Integer) queue.pop();
                if (visited[index] == 1) {
                    continue;
                }
                System.out.print(mapping[index] + ",");
                // 标记被访问
                visited[index] = 1;
                // 遍历所有未被访问的邻接结点并放入队列，即遍历与index同行的所欲符合条件的顶点，用树来表示就是当前index顶点的下一层
                // 简言之，即广度优先
                for (int i = 0; i < mapping.length; i++) {
                    // 不能是自己、未被访问、可到达
                    if (index != i && visited[i] == 0 && matrix[index][i] != null) {
                        queue.push(i);
                    }
                }
                // 跳出上述循环，那么代表与index同行的顶点均被放入队列中，那么就要依次出队，再次遍历和探索出队顶点所在行的所有元素
            }
            // 当队列为空后那么与该起始顶点及其子顶点相关的所有顶点均被探索，那么还有可能存在孤立的顶点
            // 再次寻找未被探索的顶点(孤立顶点)再次执行相关操作
            unVisited = getUnVisited(visited);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Integer[] vertexes = {0, 1, 2, 3, 4, 5, 6};
        MatrixGraph graph = new MatrixGraph(vertexes);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.printMatrix();
        graph.depthFirstTravel();
        graph.breadthFirstTravel();
    }
}
