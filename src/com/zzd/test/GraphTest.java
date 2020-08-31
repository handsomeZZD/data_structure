package com.zzd.test;

import com.zzd.graph.Graph;

/**
 * @Author ZZD
 * @Date 2020/8/29 12:55
 * @Email 1396896729@qq.com
 */
public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        String vertexes[] = {"A","B","C","D","E"};
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();
    }
}
