package com.yologger.app;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[][] input = {
                {0, 1, 1},
                {0, 2, 3},
                {1, 0, 1},
                {1, 3, 2},
                {1, 5, 9},
                {2, 0, 3},
                {2, 3, 7},
                {2, 4, 8},
                {3, 1, 2},
                {3, 2, 7},
                {3, 4, 1},
                {3, 5, 2},
                {4, 2, 8},
                {4, 3, 1},
                {4, 5, 15},
                {5, 1, 9},
                {5, 3, 2},
                {5, 4, 15}
        };

        solution.solution(n, input);
    }
}

class Solution {

    public void solution(int n, int[][] input) {
        Map<Integer, ArrayList<Edge>> graph = new HashMap<>();

        // 그래프 초기화
        for (int i=0; i<input.length; i++) {
            ArrayList<Edge> adjacentVertices = graph.get(input[i][0]);
            if (adjacentVertices == null) {
                adjacentVertices = new ArrayList<Edge>();
                adjacentVertices.add(new Edge(input[i][1], input[i][2]));
                graph.put(input[i][0], adjacentVertices);
            } else {
                adjacentVertices.add(new Edge(input[i][1], input[i][2]));
            }
        }

        System.out.println(dijkstra(graph, 0));  // {0=0, 1=1, 2=3, 3=3, 4=4, 5=5}
        System.out.println(dijkstra(graph, 1));  // {0=1, 1=0, 2=4, 3=2, 4=3, 5=4}
        System.out.println(dijkstra(graph, 2));  // {0=3, 1=4, 2=0, 3=6, 4=7, 5=8}
        System.out.println(dijkstra(graph, 3));  // {0=3, 1=2, 2=6, 3=0, 4=1, 5=2}
        System.out.println(dijkstra(graph, 4));  // {0=4, 1=3, 2=7, 3=1, 4=0, 5=3}
        System.out.println(dijkstra(graph, 5));  // {0=5, 1=4, 2=8, 3=2, 4=3, 5=0}
    }

    public Map<Integer, Integer> dijkstra(Map<Integer, ArrayList<Edge>> graph, int start) {

        // 거리 저장 배열 생성
        Map<Integer, Integer> distance = new HashMap<>();

        // 거리 저장 배열 무한대로 초기화
        for (Integer key : graph.keySet()) distance.put(key, Integer.MAX_VALUE);

        // 시작 노드 초기화
        distance.put(start, 0);

        // 우선순위 큐에 시작 노드 추가
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));

        while(priorityQueue.size() > 0) {
            Edge minEdge = priorityQueue.remove();
            int minWeight = minEdge.weight;
            int minVertex = minEdge.vertex;

            if (distance.get(minVertex) < minWeight) continue;

            ArrayList<Edge> adjacentEdges = graph.get(minVertex);
            for (Edge edge: adjacentEdges) {
                int adjacentVertex = edge.vertex;
                int adjacentWeight = edge.weight;
                if (minWeight + adjacentWeight < distance.get(adjacentVertex)) {
                    distance.put(adjacentVertex, minWeight + adjacentWeight);
                    priorityQueue.add(new Edge(adjacentVertex, minWeight + adjacentWeight));
                }
            }
        }

        return distance;
    }
}

class Edge implements Comparable<Edge> {

    Integer vertex;
    Integer weight;

    public Edge(Integer vertex, Integer weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }

    @Override
    public String toString() {
        return "{" + vertex + ", " + weight + "}";
    }
}