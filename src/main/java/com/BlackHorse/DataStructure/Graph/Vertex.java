package main.DataStructure.Graph;

import java.util.List;
import java.util.Objects;

/**
 * @Author: 小蔡
 * @Date: 2023/12/12 23:17
 * @description: 图-顶点
 */
public class Vertex {
    String name;
    public List<Edge> edges;
    boolean visited;    // 是否被访问过
    int inDegree;       // 入度:用于拓扑排序
    int status;          // 状态: 0-未访问， 1-访问中， 2-访问过，用于拓扑排序
    int dist = INF;         // 距离
    static final Integer INF = Integer.MAX_VALUE;
    Vertex prev = null;     // 记录从何而来

    public String getName() {
        return name;
    }

    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String n = name;
        if (visited) {
            n = "\u001B[31m" + name + "\u001B[0m";
        }
        return n + '(' + (dist == Integer.MAX_VALUE ? "∞" : String.valueOf(dist)) + ") <- " + (prev == null ? "null" : prev.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.edges = List.of(new Edge(b), new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();
    }
}
