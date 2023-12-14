class KruskalAlgorithm {
    static int numVertices = 5;
    static int[] parent = new int[numVertices];
    static int INFINITY = Integer.MAX_VALUE;

    static int find(int vertex) {
        while (parent[vertex] != vertex)
            vertex = parent[vertex];
        return vertex;
    }

    static void union(int vertex1, int vertex2) {
        int root1 = find(vertex1);
        int root2 = find(vertex2);
        parent[root1] = root2;
    }

    static void kruskal(int[][] edgeWeights) {
        int minCost = 0;
        for (int i = 0; i < numVertices; i++) {
            parent[i] = i;
        }
        int edgeCount = 0;
        while (edgeCount < numVertices - 1) {
            int minWeight = INFINITY;
            int u = -1, v = -1;
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
                union(u, v);
                minCost += minWeight;
                edgeCount++;
            } else {
                break;
            }
        }
        System.out.println("Minimum Cost of the Spanning Tree: " + minCost);
    }

    public static void main(String[] args) {
        int[][] edgeWeights = {
                { INFINITY, 2, INFINITY, 6, INFINITY },
                { 2, INFINITY, 3, 8, 5 },
                { INFINITY, 3, INFINITY, INFINITY, 7 },
                { 6, 8, INFINITY, INFINITY, 9 },
                { INFINITY, 5, 7, 9, INFINITY }
        };
        kruskal(edgeWeights);
    }
}
