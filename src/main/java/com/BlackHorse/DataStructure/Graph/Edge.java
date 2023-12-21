package main.DataStructure.Graph;

/**
 * @Author: 小蔡
 * @Date: 2023/12/12 23:16
 * @description: 图-边
 */
public class Edge {
    Vertex linked;
    int weight;

    public Edge(Vertex linked){
        this(linked, 1);
    }

    public Edge(Vertex linked, int weight){
        this.linked = linked;
        this.weight = weight;
    }
}
