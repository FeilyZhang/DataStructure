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
    
    public static void main(String[] args) {
        Integer[] vertexes = {0, 1, 2, 3};
        MatrixGraph graph = new MatrixGraph(vertexes);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.printMatrix();
    }
}
