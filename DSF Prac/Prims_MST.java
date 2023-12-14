// Importing the java.util package, which includes the Arrays class
import java.util.*;

// Class definition for Prim's Minimum Spanning Tree (MST) algorithm
class Prims_MST {
    
    // Method to find and print the MST using Prim's algorithm
    public void prim(int G[][], int v) {
        // Initializing variables
        int mincost = 0; // Variable to store the minimum cost of the MST
        int INF = 99999; // A constant representing infinity (used for initial comparison)
        int no_edge; // Variable to count the number of edges in the MST

        // Array to keep track of selected vertices (true if selected, false if not)
        boolean[] select = new boolean[v];
        Arrays.fill(select, false); // Filling the array with 'false' values initially
        no_edge = 0; // Initializing the edge count
        select[0] = true; // Selecting the first vertex as the starting point

        // Loop to find the MST
        while (no_edge < v - 1) {
            int min = INF; // Variable to store the minimum edge weight
            int x = 0; // Variable to store the starting vertex of the selected edge
            int y = 0; // Variable to store the ending vertex of the selected edge

            // Nested loop to iterate through the adjacency matrix
            for (int i = 0; i < v; i++) {
                // Checking if the current vertex is selected
                if (select[i] == true) {
                    // Iterating through all vertices to find the minimum edge weight
                    for (int j = 0; j < v; j++) {
                        // Checking if the vertex is not selected and there is an edge
                        if (!select[j] && G[i][j] != 0) {
                            // Updating the minimum edge weight and its corresponding vertices
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            // Printing the selected edge and its cost
            System.out.printf("Edge %d (%d , %d) cost %d \n", no_edge++, x, y, G[x][y]);
            
            // Marking the ending vertex as selected
            select[y] = true;
            
            // Adding the edge cost to the total minimum cost
            mincost += G[x][y];
        }
        // Printing the minimum cost of the MST
        System.out.println("min cost :" + mincost);
    }

    // Main method, the entry point of the program
    public static void main(String[] args) {
        // Creating an instance of the Prims_MST class
        Prims_MST g = new Prims_MST();
        
        // Initializing the number of vertices
        int v = 5;
        
        // Defining the adjacency matrix representing the graph
        int[][] G = {
            { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };
        
        // Calling the prim method to find and print the MST
        g.prim(G, v);
    }
}
