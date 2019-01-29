package tech.feily.dataStructure;

/**
 * @author : Feily Zhang
 * @date : 2019-1-28 9:30:33
 * @version : V1.0 
 * @Description :  
 * @Copyright : All rights Reserved, Designed By https://feily.tech.
 */
public class HashTable {

    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final float LOAD_FACTOR = 0.75f;
    
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size = 0;
    private int use = 0;

    public int hash(int key) {
        return key % table.length;
    }
    
    /*
     * emmm,������Ҫ����������Entry������table�ĳ���
     * emmm,��һ������Ҫ�������ϵ���ײԪ�����½��й�ϣ��ɢ��
     */
    public void resize() {
        int newLength = table.length * 2;
        Entry[] oldTable = table;
        table = new Entry[newLength];
        use = 0;
        for (int i = 0; i < table.length; i++) {    //�ò�ѭ����������table�ϵ�ÿ����ַ
            if (oldTable[i] != null && oldTable[i].next != null) {
                Entry e = oldTable[i];  //�Ȼ�ȡ�õ�ַ�ϵ�ֵ����ͨ���жϿ��õ�ַ�Ƿ�������
                while (e.next != null) {
                    Entry next = e.next;
                    // ���¼����ϣֵ���ٴν���ɢ�У�������߼���put��Ĳ����߼�һ��
                    int index = hash(next.key);
                    if (table[index] == null) {
                        use ++;
                        table[index] = new Entry(-1, -1, null);
                    }
                    table[index].next = new Entry(next.key, next.value, table[index].next);
                    e = next;
                }
            }
        }
    }
    
    public void put(int key, int value) {
        int index = hash(key);  //�õ�key�ĵ�ַ
        // ������̽���õ�ַ���Ƿ�Ϊnull�����Ϊnull��ô˵��û��Ԫ�أ���Ԫ�ؾ��Ǹõ�ַ������
        // �����Ϊnull����ô˵���õ�ַ��Ԫ�أ���ô�ͽ���Ԫ�صĺ�̽ڵ�����Ϊԭ�ȵ��׽ڵ�
        if (table[index] == null) {
            table[index] = new Entry(-1, -1, null); //���øõ�ַ��ֵ�����������Ƿ�õ�ַ��Ԫ�أ�nullָ���Ǹõ�ַ������û��Ԫ��
        }
        // �������Ȼ�ȡ�õ�ַ��������ʼȻ����в������
        Entry e = table[index];
        // Ȼ�󿴸���ʼ�Ƿ���Ԫ�أ��еĻ���ǰ����Ϊ��̣�����ֱ������Ϊ����
        if (e.next == null) {   //˵�����ײ�����Ԫ�أ���ô��ֱ������Ԫ��Ϊ����
            table[index].next = new Entry(key, value, null);
            size ++;
            use ++;
            if (use >= table.length * LOAD_FACTOR) {
                resize();
            }
        } else {    // ˵�����״���Ԫ�أ���ôǰ���ĺ��
            // ����һ������ǣ���ϣ���������ظ���key�����key�Ѿ�������ô�ͻ��޸���ֵΪ���µ�value
            // ��ô�ͱ����������Ƿ���ڸ�key
            // ��ʼ������e = e.next����Ϊindex��ַ����Ԫ����˵���õ�ַ��������������Ҫnext�Ż�õ�����
            for (e = e.next; e != null; e = e.next) {
                if (e.key == key) {
                    e.value = value;
                    return; //����key����ô������֮����ǰ��ֹ
                }
            }
            // ���������ֲ�����key����ô��ǰ������
            Entry oldStart = table[index].next;    // ��ȡ����Ԫ��
            table[index].next = new Entry(key, value, oldStart);   //��������Ϊ��ǰԪ�أ���ǰԪ�صĺ��Ϊ��ǰ�����ף�������������
            size++;
        }
    }
    
    /*
     * e��pre����������ɾ��Ԫ����Ҫ��ȡǰ����㣬����ǰ�����ָ��Ҫɾ�����ĺ���ϣ�������Ҫpre��e��������
     * preΪǰ����㣬eΪ��ǰ�ڵ㣬ɾ����ζ��pre.next = e.next��������ǰ�ڵ�e��ǰ�����pre�ĺ��ָ��ǰ�ڵ�e�ĺ�̽ڵ�e.next��
     */
    public void remove(int key) {
        int index = hash(key);
        Entry e = table[index];    // ���eΪnull����ô˵���õ�ַ�������õ�ַ������key��ֵ
        Entry pre = table[index];  // ǰ������ݶ�Ϊtable[index]
        // e.next���п���Ϊnull����Ϊ���ܸõ�ַ�������������ף�����ҲҪ��������
        if (e != null && e.next != null) {
            for (e = e.next; e != null; pre = e, e = e.next) {
                if (e.key == key) {
                    pre.next = e.next;
                    size --;
                    return;
                }
            }
        }
    }
    
    /*
     * emmmm,��ȡԪ�ز�����Ҫǰ����㣬ֻ��Ҫ��ǰe�ͺ���
     */
    public int get(int key) {
        int index = hash(key);
        Entry e = table[index];
        if (e != null && e.next != null) {
            for (e = e.next; e != null; e = e.next) {
                if (e.key == key) {
                    return e.value;
                }
            }
        }
        return -1;
    }
    
    public int size() {
        return size;
    }
    
    public int length() {
        return table.length;
    }
    
}
