import java.io.*;
import java.util.*;

public class Task6 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

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

        int dist1 [] = new int [N+1];
        int dist2 [] = new int [N+1];

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        Dijkstra(S, dist1, dist2, List);

        if(dist2[D]==Integer.MAX_VALUE) pw.println(-1);
        else pw.println(dist2[D]);
        
        pw.close();
    }
    
    static void Dijkstra(int S, int dist1 [], int dist2 [], ArrayList <ArrayList<Node>> List){
        PriorityQueue <Integer[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        dist1[S] = 0;
        q.add(new Integer []{0, S});

        while(!q.isEmpty()){
            Integer curr [] = q.poll();
            Integer d = curr[0];
            Integer u = curr[1];

            for(Node n : List.get(u)){
                int total = d+n.w;

                if(total < dist1[n.v]){
                    dist2 [n.v] = dist1 [n.v];
                    dist1 [n.v] = d+n.w;
                    q.add(new Integer[] {dist1[n.v],n.v});
                }
                else if(total>dist1[n.v] && total<dist2[n.v]){
                    dist2 [n.v] = total;
                    q.add(new Integer[] {dist2[n.v],n.v});
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
