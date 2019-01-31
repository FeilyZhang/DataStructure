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
     * emmm���÷���ͨ��ȷ��start��end�ھ���matrix�е����꣬Ȼ������ֵΪ1���Ӷ�ȷ��start��end��ı߹�ϵ
     * @param start �ò���Ϊ��ʼ����
     * @param end �ò���Ϊ��ֹ����
     */
    public void addEdge(Object start, Object end) {
        int row = -1;
        int col = -1;
        // Ѱ������
        for (int i = 0; i < mapping.length; i++) {
            // ��ʼ����Ϊrow = -1, col = -1
            // �����ʼ���귢���仯����ô�Ϳ�����Ϊ�Ѿ�Ѱ�ҵ�����Ӧ����
            if (row != -1 && col != -1) {
                break;
            }
            // ��Ҫע����ǣ�������㼯����������Ϊint���Ҷ�������(��0�� 1�� 2�� 3)����ô��������ǿ���ʡ�Ե�
            // ��Ϊ���㱾���������
            // ����Ѱ������ָ����һά���㼯���������Ͳ�Ϊint�Ҳ���������ôֻ��ͨ���������㼯�ķ�ʽ��ȡ�������ڶ��㼯�е�����
            // ��ʵ����Ѱ�Ҷ�����mapping�е�������Ҳ��������matrix�е�����
            if (start == mapping[i]) {
                row = i;
            }
            
            if (end == mapping[i]) {
                col = i;
            }
        }
        
        // �жϸ������Ƿ�Ϸ�(�����)
        if (row == -1 || col == -1 || row > mapping.length - 1 || col > mapping.length - 1) {
            throw new IndexOutOfBoundsException("The vertex of the edge does not exist or the coordinates are illegal.");
        }
        matrix[row][col] = 1;   //������������Ϊ1����ô����˵������start(����Ϊrow)�붥��end(����Ϊcol)���ڱ�
    }
    
    public void printMatrix() {
        // ��һ����ʵ�е���࣬��Ϊ���ǵľ���matrix������ΪObject
        // ������ǲ���������ֵ�Ļ�����ô����null
        // ���ÿ������ǽ�null�滻Ϊ0,�������64��if (obj == null) obj = 0;
        for (Object[] object : matrix) {
            for (Object obj : object) {
                if (obj == null) obj = 0;
                System.out.print(obj + " ");
            }
            System.out.println();
        }
    }
    
    /*
     * emmm,��visited����(�������鱻����״̬����)����δ�����ʹ��Ķ���
     * emmm,���ڶ����ڱ�������Ψһ�ģ���ôֻҪ�ö��㱻̽������ô�˺��һ�������ٱ�̽��
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
        int[] visited = new int[mapping.length];  // ��ʼ�������㱻����״̬��ȫ��Ϊ0
        int unVisited = getUnVisited(visited);  // �Ӷ��㱻����״̬�������ҵ�һ��δ�����ʹ��Ķ���
        // ������㶼�����ʣ��Ƕ�᷵��-1������������ѭ���������������
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
        while (unVisited >= 0) {    //��ô˵������δ̽���Ķ���
            // ��ʼ�������
            queue.push(unVisited);
            while (!queue.isEmpty()) {  //���в�Ϊ�գ���ô˵�����ж���δ��̽��
                int index = (Integer) queue.pop();
                if (visited[index] == 1) {
                    continue;
                }
                System.out.print(mapping[index] + ",");
                // ��Ǳ�����
                visited[index] = 1;
                // ��������δ�����ʵ��ڽӽ�㲢������У���������indexͬ�е��������������Ķ��㣬��������ʾ���ǵ�ǰindex�������һ��
                // ����֮�����������
                for (int i = 0; i < mapping.length; i++) {
                    // �������Լ���δ�����ʡ��ɵ���
                    if (index != i && visited[i] == 0 && matrix[index][i] != null) {
                        queue.push(i);
                    }
                }
                // ��������ѭ������ô������indexͬ�еĶ��������������У���ô��Ҫ���γ��ӣ��ٴα�����̽�����Ӷ��������е�����Ԫ��
            }
            // ������Ϊ�պ���ô�����ʼ���㼰���Ӷ�����ص����ж������̽������ô���п��ܴ��ڹ����Ķ���
            // �ٴ�Ѱ��δ��̽���Ķ���(��������)�ٴ�ִ����ز���
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
