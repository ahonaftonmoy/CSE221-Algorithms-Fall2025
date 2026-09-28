import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        ArrayList <ArrayList<Node>> List = new ArrayList<>();
        for(int i=0; i<=N; i++) List.add(new ArrayList<>());

        for(int i=1 ; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            List.get(u).add(new Node(v,w));
        }

        int distOfS [] = Dijkstra(S, N, List);
        int distOfT [] = Dijkstra(T, N, List);

        int shTime = Integer.MAX_VALUE;
        int newNode = -1;
        for(int i=1; i<=N; i++){
            int sameTime = Math.max(distOfS[i], distOfT[i]);
            if(sameTime<shTime || (sameTime == shTime && i<newNode)){
                shTime = sameTime;
                newNode = i;
            }  
        }

        if(newNode == -1) pw.println(-1);
        else pw.println(shTime +" "+newNode);

        pw.close();
    }
    
    static int[] Dijkstra(int source, int N, ArrayList<ArrayList<Node>> List){
        PriorityQueue <Integer[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        q.add(new Integer []{0, source});
                
        int [] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        while(!q.isEmpty()){
            Integer curr [] = q.poll();
            Integer d = curr[0];
            Integer u = curr[1];

            for(Node n : List.get(u)){
                int v = n.v;
                if((d+n.w)<dist[v]){
                    dist[v] = d+n.w;
                    q.add(new Integer[] {dist[v],v});
                }
            }
        }
        return dist;
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
