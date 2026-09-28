import java.io.*;
import java.util.*;

public class Task5 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int u [] = new int[M+1];
        int v [] = new int[M+1];
        int w [] = new int[M+1];

        for(int t=1 ; t<=3; t++){
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=M; i++){
                if(t==1) u[i] = Integer.parseInt(st.nextToken());
                else if(t==2) v[i] = Integer.parseInt(st.nextToken());
                else w[i] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList <ArrayList<Node>> List = new ArrayList<>();
        for(int i=0; i<=N; i++) List.add(new ArrayList<>());

        for(int i=1 ; i<=M; i++) List.get(u[i]).add(new Node(v[i],w[i]));

        int dist [][] = new int [N+1][2];
        for(int i=0; i<=N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        Dijkstra(dist, List);

        int res = Math.min(dist[N][0], dist[N][1]);

        if(res == Integer.MAX_VALUE) pw.println(-1);
        else pw.println(res);

        pw.close();
    }

    static void Dijkstra(int dist [][], ArrayList <ArrayList<Node>> List){
        PriorityQueue <Integer[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        
        for(Node n : List.get(1)){
            int w = n.w % 2;
            if((n.w)<dist[n.v][w]){
                dist[n.v][w] = n.w;
                q.add(new Integer[] {n.w, n.v, w});
            }
        }

        while(!q.isEmpty()){
            Integer curr [] = q.poll();
            Integer d = curr[0];
            Integer u = curr[1];
            Integer p = curr[2];

            for(Node n : List.get(u)){
                int w = n.w % 2;
                if(w!=p && (d+n.w)<dist[n.v][w]){
                    dist[n.v][w] = d+n.w;
                    q.add(new Integer[] {d+n.w, n.v, w});
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
