package main.DataStructure.Graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 小蔡
 * @Date: 2023/12/12 23:36
 * @description: 广度优先遍历BFS（Breadth-First Search）
 */
public class BFS {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(
                new Edge(v3, 9),
                new Edge(v2, 7),
                new Edge(v6, 14)
        );
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(
                new Edge(v4, 11),
                new Edge(v6, 2)
        );
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9));

        bfs(v1);
    }

    private static void bfs(Vertex v) {
        LinkedList<Vertex> queue = new LinkedList<>();
        v.visited = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                if (!edge.linked.visited) {
                    edge.linked.visited = true;
                    queue.offer(edge.linked);
                }
            }
        }
    }
}
