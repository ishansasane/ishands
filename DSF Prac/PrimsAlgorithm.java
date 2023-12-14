class PrimsAlgorithm {
    static int numVertices = 5;
    static int[] parent = new int[numVertices];
    static int INFINITY = Integer.MAX_VALUE;

    // Function to find the root of the set to which a vertex belongs
    static int find(int vertex) {
        while (parent[vertex] != vertex)
            vertex = parent[vertex];
        return vertex;
    }

    // Function to perform union of two sets
    static void union(int vertex1, int vertex2) {
        int root1 = find(vertex1);
        int root2 = find(vertex2);
        parent[root1] = root2;
    }

    // Prim's algorithm to find the minimum spanning tree
    static void findMinimumSpanningTree(int[][] edgeWeights) {
        int totalWeight = 0;
        for (int i = 0; i < numVertices; i++) {
            parent[i] = i; // Initialize each vertex to be in its own set
        }
        int edgeCount = 0;
        while (edgeCount < numVertices - 1) {
            int minWeight = INFINITY;
            int u = -1, v = -1;
            // Find the minimum weight edge that connects a vertex in the tree to a vertex outside the tree
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (find(i) != find(j) && edgeWeights[i][j] < minWeight) {
                        minWeight = edgeWeights[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
            if (u != -1 && v != -1) {
                System.out.println("Edge " + u + " - " + v + " : Weight = " + minWeight);
                union(u, v); // Perform union to add the vertex to the tree
                totalWeight += minWeight;
                edgeCount++;
            } else {
                break;
            }
        }
        System.out.println("Minimum Weight of the Spanning Tree: " + totalWeight);
    }

    public static void main(String[] args) {
        int[][] edgeWeights = {
            {INFINITY, 2, INFINITY, 6, INFINITY},
            {2, INFINITY, 3, 8, 5},
            {INFINITY, 3, INFINITY, INFINITY, 7},
            {6, 8, INFINITY, INFINITY, 9},
            {INFINITY, 5, 7, 9, INFINITY}
        };
        findMinimumSpanningTree(edgeWeights);
    }
}
