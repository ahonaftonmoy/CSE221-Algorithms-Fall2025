import java.io.*;
import java.util.*;

public class Task1 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

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

        int dist [] = new int [N+1];
        int par [] = new int [N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(par, -1);
        
        Dijkstra(S, dist, par, List);

        if(dist[D] == Integer.MAX_VALUE) pw.println(-1);
        else{
            pw.println(dist[D]);
            List <Integer> path = new ArrayList<>();
            while(D != -1){
                path.add(D);
                D= par[D];
            }
            Collections.reverse(path);
            for(int i=0; i<path.size(); i++) pw.print(path.get(i)+" ");
            pw.println();
        }
        pw.close();
    }

    static void Dijkstra(int source, int dist [], int par [], ArrayList <ArrayList<Node>> List){
        PriorityQueue <Integer[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        dist[source] = 0;
        q.add(new Integer []{0, source});

        while(!q.isEmpty()){
            Integer curr [] = q.poll();
            Integer d = curr[0];
            Integer u = curr[1];

            for(Node n : List.get(u)){
                int v = n.v;
                if((d+n.w)<dist[v]){
                    dist[v] = d+n.w;
                    par[v] = u;
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
