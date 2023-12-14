import java.util.*;

class Kruskal_MST {
  // Number of vertices in the graph
  static int v = 5;
  // Array to store the parent of each vertex
  static int[] parent = new int[v];
  // Define infinity
  static int INF = Integer.MAX_VALUE;

  // Function to find the root of a vertex
  static int find(int i) {
    while (parent[i] != i) {
      i = parent[i];
    }
    return i;
  }

  // Function to perform union of two sets represented by their roots
  static void union(int i, int j) {
    int a = find(i);
    int b = find(j);
    parent[a] = b;
  }

  // Function to implement Kruskal's algorithm
  static void kruskalMST(int[][] cost) {
    int mincost = 0; // Initialize minimum cost
    int edge_count = 0; // Initialize edge count

    // Initialize parent array to point to each vertex itself
    for (int i = 0; i < v; i++) {
      parent[i] = i;
    }

    // Loop until all edges are included in the MST
    while (edge_count < v - 1) {
      int min = INF; // Initialize minimum weight
      int a = -1; // Initialize source vertex
      int b = -1; // Initialize destination vertex

      // Iterate through all vertices
      for (int i = 0; i < v; i++) {
        // Iterate through all adjacent vertices
        for (int j = 0; j < v; j++) {
          // Check if edge connects different sets and has minimum weight
          if (find(i) != find(j) && cost[i][j] < min) {
            min = cost[i][j];
            a = i;
            b = j;
          }
        }
      }

      // Perform union of the sets connected by the minimum weight edge
      union(a, b);
      edge_count++; // Increase edge count

      // Print the edge included in the MST
      System.out.printf("Edge %d (%d, %d) cost %d\n", edge_count, a, b, min);

      // Update minimum cost
      mincost += min;
    }

    // Print the total minimum cost of the MST
    System.out.printf("Minimum cost: %d", mincost);
  }

  // Main function
  public static void main(String[] args) {
    // Define the cost matrix
    int[][] cost = {{INF, 2, INF, 6, INF},
                    {2, INF, 3, 8, 5},
                    {INF, 3, INF, INF, 7},
                    {6, 8, INF, INF, 9},
                    {INF, 5, 7, 9, INF}};

    // Call the kruskalMST function
    kruskalMST(cost);
  }
}
