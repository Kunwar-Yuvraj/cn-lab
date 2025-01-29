import java.util.*;


public class BellmanFord{
    static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void bellmanFord(int v, Edge[] e, int s){
        int[] d = new int[v];

        for (int i = 0; i < v; i++) d[i] = Integer.MAX_VALUE;
        d[s] = 0;

        for (int i = 1; i < v; i++){
            for (Edge edge: e){
                if (
                    d[edge.u] != Integer.MAX_VALUE
                    && d[edge.u] + edge.w < d[edge.v]
                )
                    d[edge.v] = d[edge.u] + edge.w;
            }
        }

        for (Edge edge: e){
            if (
                d[edge.u] != Integer.MAX_VALUE
                && d[edge.u] + edge.w < d[edge.v]
            ){
                System.out.println("Negative Cycle Detection!");
                return;
            }
        }
        for (int i = 0; i < v; i++){
            System.out.println("Vertex: " + i + " " + (d[i] == Integer.MAX_VALUE ? "INF" : d[i]));
        }
    }

    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertex: ");
        int v = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        Edge[] edges = new Edge[e];

        System.out.println("Enter (u v weight):");
        for (int i = 0; i < e; i++){
            edges[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        System.out.print("Enter source: ");
        int s = sc.nextInt();

        bellmanFord(v, edges, s);

        sc.close();
    }
}
