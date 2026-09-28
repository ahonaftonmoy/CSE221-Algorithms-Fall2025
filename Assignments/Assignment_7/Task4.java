import java.io.*;
import java.util.*;

public class Task4{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int w [] = new int [N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) w[i] = Integer.parseInt(st.nextToken());

        ArrayList <ArrayList<Integer>> List = new ArrayList<>();
        for(int i=0; i<=N; i++) List.add(new ArrayList<>());

        for(int i=1 ; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            List.get(u).add(v);
        }

        int dist [] = new int[N+1]; 
        Arrays.fill(dist, Integer.MAX_VALUE);

        Dijkstra(S, dist, List, w);

        if(dist[D]==Integer.MAX_VALUE) pw.println(-1);
        else pw.println(dist[D]);

        pw.close();
    }
    
    static void Dijkstra(int S, int dist [], ArrayList <ArrayList<Integer>> List, int w[]){
        PriorityQueue <Integer[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        dist[S] = w[S];
        q.add(new Integer []{dist[S],S});
        

        while(!q.isEmpty()){
            Integer curr [] = q.poll();
            Integer d = curr[0];
            Integer u = curr[1];

            for(int v : List.get(u)){
                if(d+w[v]<dist[v]){
                    dist[v] = d+w[v];
                    q.add(new Integer[] {dist[v],v});
                }
            }
        }
    }
}
