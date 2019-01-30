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
