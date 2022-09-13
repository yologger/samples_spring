package com.yologger.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge("A", "B", 4));
        edges.add(new Edge("A", "C", 3));
        edges.add(new Edge("B", "D", 5));
        edges.add(new Edge("B", "F", 9));
        edges.add(new Edge("C", "D", 2));
        edges.add(new Edge("C", "E", 6));
        edges.add(new Edge("D", "E", 1));
        edges.add(new Edge("D", "F", 8));
        edges.add(new Edge("E", "F", 15));

        Solution solution = new Solution();
        ArrayList<Edge> MST = solution.kruskal(vertices, edges);
        System.out.println(MST);
    }
}

class Solution {

    HashMap<String, String> parent = new HashMap<String, String>();

    public ArrayList<Edge> kruskal(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> MST = new ArrayList<Edge>();

        // MakeSet
        for (String vertex: vertices) parent.put(vertex, vertex);

        // Weight를 기준으로 정렬
        Collections.sort(edges);

        for (int i=0; i<edges.size(); i++) {
            Edge cursorEdge = edges.get(i);

            // 싸이클이 없을 때만 Union
            if (find(cursorEdge.vertexU) != find(cursorEdge.vertexV)) {
                union(cursorEdge.vertexU, cursorEdge.vertexV);
                MST.add(cursorEdge);
            }
        }

        return MST;
    }

    // 두 그래프를 합집합
    public void union(String u, String v) {
        String uParent = find(u);
        String vParent = find(v);
        if (uParent.compareTo(vParent) > 0) parent.put(u, v);
        else parent.put(v, u);
    }

    // 부모 정점 반환
    public String find(String vertex) {
        // 재귀 사용
        if (parent.get(vertex) != vertex) parent.put(vertex, find(parent.get(vertex)));
        return parent.get(vertex);
    }

}

class Edge implements Comparable<Edge> {

    String vertexU;
    String vertexV;
    int weight;

    public Edge(String vertexU, String vertexV, int weight) {
        this.vertexU = vertexU;
        this.vertexV = vertexV;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" + vertexU + ", " + vertexV + ", " + weight + "}";
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}