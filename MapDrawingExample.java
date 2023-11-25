import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class MapDrawingExample extends JFrame {
    public MapDrawingExample() {
        setTitle("Bản đồ");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLACK);
                int pointSize = 10; // Kích thước của điểm
                int V = 8; // Số đỉnh

                Graph graph = new Graph(V);
                graph.addEdge(0,1, 100, 400, 0);

                graph.addEdge(1,1, 100, 400, 0);
                graph.addEdge(1,2, 500, 200, 25);
                graph.addEdge(1,3, 500, 400, 30);
                graph.addEdge(1,4, 500, 600, 30);

                graph.addEdge(2,2, 500, 200, 0);
                graph.addEdge(2,5, 900, 200, 22);

                graph.addEdge(3,3, 500, 400, 0);
                graph.addEdge(3,6, 900, 400, 30);
                graph.addEdge(3,7, 900, 600, 14);

                graph.addEdge(4,4, 500, 600, 0);
                graph.addEdge(4,7, 900, 600, 50);

                graph.addEdge(5,5, 900, 200, 0);
                graph.addEdge(5,3, 500, 400, 18);
                graph.addEdge(5,6, 900, 400, 10);
                graph.addEdge(5,8, 1300, 400, 20);

                graph.addEdge(6,6, 900, 400, 0);
                graph.addEdge(6,8, 1300, 400, 20);

                graph.addEdge(7,7, 900, 600, 0);
                graph.addEdge(7,8, 1300, 400, 21);

                System.out.println(graph.toString ());
                for (int i = 0; i < V; i++) {
                    Graph.Vertex sourceVertex = graph.adjList.get(i).get(0);

                    System.out.println("node root"+sourceVertex.dest+" "+sourceVertex.x+" "+sourceVertex.y);

                    for ( Graph.Vertex vertex : graph.adjList.get(i)) {
                        System.out.println("connected with"+vertex.dest);
                        System.out.println("connected with: "+vertex.x+" "+vertex.y);
                        g2d.fillOval(vertex.x - 3, vertex.y - 5, pointSize, pointSize);// draw point
                        g2d.setColor(Color.BLACK);
                        g2d.setStroke(new BasicStroke(vertex.weight));
                        g2d.draw(new Line2D.Double(sourceVertex.x,sourceVertex.y , vertex.x ,vertex.y));
                    }
                    System.out.println();
                }
            }
        };
        add(panel);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MapDrawingExample example = new MapDrawingExample();
            example.setVisible(true);
        });
    }
    }