package main.DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 小蔡
 * @Date: 2023/12/13 16:33
 * @description: 狄克斯特拉：单源最短路径算法
 *  1-将所有顶点标记为未访问。创建一个未访问顶点的集合
 *  2-为每个顶点分配一个临时距离值
 *      对于我们的初始顶点，将其设置为零
 *      对于所有其他顶点，将其设置为无穷大
 *  3-每次选择最小临时距离的未访问顶点，作为新的当前顶点
 *  4-对于当前顶点，遍历其所有未访问的邻居，并更新它们的临时距离为更小
 *      例如，1->6的距离是14，而1->3->6的距离是11，此时将距离更新为11
 *      否则，将保存上次距离值
 *  5-当前顶点的邻居处理完成后，将它从未访问集合中删除
 */
public class Dijkstra {
    public static void main(String[] args) {
        /*
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        v1.edges = List.of(new Edge(v3, 9), new Edge(v2, 7), new Edge(v6, 14));
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(new Edge(v4, 11), new Edge(v6, 2));
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9));
        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);
        */

        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v1.edges = List.of(new Edge(v2, 2), new Edge(v3, 1));
        v2.edges = List.of(new Edge(v3, -2));
        v3.edges = List.of(new Edge(v4, 1));
        v4.edges = List.of();

        List<Vertex> graph = List.of(v1, v2, v3, v4);

        dijkstra(graph, v1);
    }

    private static void dijkstra(List<Vertex> graph, Vertex source) {
        ArrayList<Vertex> list = new ArrayList<>(graph);
        source.dist = 0;
        while (!list.isEmpty()) {
            // 3. 选取当前顶点
            Vertex curr = chooseMinDistVertex(list);
            // 4. 更新当前顶点邻居距离
            updateNeighboursDist(curr);
            // 5. 移除当前顶点
            list.remove(curr);
            curr.visited = true;
        }
        for (Vertex v : graph) {
            System.out.println(v);
        }
    }

    // 更新顶点距离
    private static void updateNeighboursDist(Vertex curr) {
        for (Edge edge : curr.edges) {
            Vertex n = edge.linked;
            if (!n.visited) {
                int dist = curr.dist + edge.weight;
                if (dist < n.dist) {
                    n.dist = dist;
                    n.prev = curr;
                }
            }
        }
    }

    // 选择最小距离顶点
    private static Vertex chooseMinDistVertex(ArrayList<Vertex> list) {
        Vertex min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).dist < min.dist) {
                min = list.get(i);
            }
        }
        return min;
    }
}
