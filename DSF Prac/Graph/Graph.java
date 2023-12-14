package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;

    Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[i][nodeIndex] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    void DFSVisit(GraphNode node) {
        LinkedList<GraphNode> stack = new LinkedList<GraphNode>();
        stack.push(node);

        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();

            if (!currentNode.isVisited) {
                currentNode.isVisited = true;
                System.out.print(currentNode.name + " ");

                ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
                for (GraphNode neighbor : neighbors) {
                    if (!neighbor.isVisited) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();

            if (!currentNode.isVisited) {
                currentNode.isVisited = true;
                System.out.print(currentNode.name + " ");

                ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
                for (GraphNode neighbor : neighbors) {
                    if (!neighbor.isVisited) {
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    void BFS() {
        for (GraphNode j : nodeList) {
            if (!j.isVisited) {
                bfsVisit(j);
            }
        }
    }

    void DFS() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                DFSVisit(node);
            }
        }
    }
}
