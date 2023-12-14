package Graph;

public class GraphNode {
    String name;
    int index;
    boolean isVisited = false;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
