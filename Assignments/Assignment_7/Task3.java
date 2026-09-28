import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList <ArrayList<Node>> List = new ArrayList<>();
        for(int i=0; i<=N; i++) List.add(new ArrayList<>());

        for(int i=1 ; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            List.get(u).add(new Node(v,w));
            List.get(v).add(new Node(u,w));
        }

        int dist [] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Dijkstra(1, dist, List);

        for(int i=1; i<=N; i++) pw.print(dist[i] == Integer.MAX_VALUE ? -1+" " : dist[i]+" ");

        pw.close();
    }
    
    static void Dijkstra(int source, int dist [], ArrayList <ArrayList<Node>> List){
        PriorityQueue <Integer[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        dist[source] = 0;
        q.add(new Integer []{0, source});

        while(!q.isEmpty()){
            Integer curr [] = q.poll();
            Integer d = curr[0];
            Integer u = curr[1];

            for(Node n : List.get(u)){
                int v = n.v;
                int dang = Math.max(d, n.w);
                if(dang<dist[v]){
                    dist[v] = dang;
                    q.add(new Integer[] {dist[v],v});
                }
            }
        }
    }

    static class Node{
        int v;
        int w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}
