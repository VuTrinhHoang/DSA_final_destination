import java.util.*;
class Graph {
    private int V; // Số đỉnh
    List<List<Vertex>> adjList; // Danh sách kề
    private int src;

    // Class Vertex biểu diễn một đỉnh với tọa độ x, y và trọng số
    class Vertex {
        int x, y, weight,dest,source;
        Vertex(int source ,int dest,int x, int y, int weight) {
            this.source = source;
            this.dest = dest;
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
        public int getX ( ){
            return this.x;
        }
        public int getY ( ){
            return this.y;
        }
        public int getW ( ){
            return this.weight;
        }
        public int getSource() {
            return this.source;
        }
        public int getDest() {
            return this.dest;
        }

    }

    Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());
    }
    // Thêm cạnh với trọng số và tọa độ x, y
    void addEdge(int src, int dest, int x, int y, int weight) {
        Vertex vertex = new Vertex(src,dest,x, y, weight);
        adjList.get(src).add(vertex);
    }

    // In đồ thị
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Đỉnh " + i + " liên kết với: ");
            for (Vertex vertex : adjList.get(i)) {
                System.out.print("(" + vertex.x + "," + vertex.y + ") [" + vertex.weight + "] ");
            }
            System.out.println();
        }
    }
    public boolean isConnected(Vertex vertex1, Vertex vertex2) {
        if(vertex1.source==vertex2.source) return true;
        return false;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph adjacency list:\n");
        for (int i = 1; i < V; i++) {
            sb.append("Vertex ").append(i).append(" connected to: ");
            for (Vertex edge : adjList.get(i)) {
                sb.append(edge.getDest()).append("(").append ( edge.getX () ).append ( ", " )
                        .append ( edge.getY () ).append ( ", " ).append(edge.getW()).append(")\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
