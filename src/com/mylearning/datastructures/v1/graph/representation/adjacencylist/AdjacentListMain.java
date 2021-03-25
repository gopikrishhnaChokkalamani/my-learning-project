package com.mylearning.datastructures.v1.graph.representation.adjacencylist;

public class AdjacentListMain {

  public static void main(String[] args) {
    int n = 4;
    //[0,1],[1,2],[2,0],[1,3]
    Graph g = new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(1, 3);

    for (int i = 0; i < g.list.size(); i++) {
      System.out.print(i + " -> ");
      for (Integer j : g.list.get(i)) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
    System.out.println();

   // g.dfs(0);
    g.bfs(0);
    System.out.println();
  }
}
