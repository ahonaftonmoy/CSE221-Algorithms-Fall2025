import java.io.*;
import java.util.*;

public class Task3 {
    static ArrayList<ArrayList<int[]>> List;
    static int[] pt;
    static int[] size;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{U, V, W});
        }

        List = new ArrayList<>(N + 1);
        for(int i=0; i<=N; i++) List.add(new ArrayList<>());

        pt = new int[N + 1];
        size = new int[N + 1];
        for(int i=1; i<=N; i++){
            pt[i] = i;
            size[i] = 1;
        }

        ArrayList<int[]> unused = new ArrayList<>();

        long weight=0;
        int count=0;
        while(!pq.isEmpty()){
            int[] edge = pq.poll();

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(find(u) != find(v)){
                union(u, v);
                List.get(u).add(new int[]{v, w});
                List.get(v).add(new int[]{u, w});
                weight += w;
                count++;
            } 
            else unused.add(edge);
            
        }

        if(count != N - 1){
            pw.println("-1");
            pw.flush();
            pw.close();
            return;
        }

        long min = Long.MAX_VALUE;
        for(int i = 0; i < unused.size(); i++){
            int[] edge = unused.get(i);

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int[] maxEdges = maxEdge(u, v, N);

            int max1 = maxEdges[0];
            int max2 = maxEdges[1];

            long increase = Long.MAX_VALUE;

            if(w > max1) increase = w - max1;
            else if(w == max1 && max2 != -1)increase = w - max2;

            if(increase != Long.MAX_VALUE && increase > 0) min = Math.min(min, increase);
            
        }

        if(min == Long.MAX_VALUE) pw.println("-1");
        else pw.println(weight + min);
        
        pw.close();
    }

    public static void union(int i, int j) {
        int r1 = find(i);
        int r2 = find(j);

        if(r1 != r2){
            if(size[r1] < size[r2]){
                int temp = r1;
                r1 = r2;
                r2 = temp;
            }

            pt[r2] = r1;
            size[r1] += size[r2];
        }
    }
    
    public static int find(int a) {
        if(pt[a] == a) return a;

        pt[a] = find(pt[a]);
        return pt[a];
    }

    public static int[] maxEdge(int start, int end, int n) {
        int[] node = new int[n + 1];
        int[] weight= new int[n + 1];

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        node[start] = -1;

        boolean found = false;
        while(!q.isEmpty()){
            int u = q.poll();
            if(u == end){
                found = true;
                break;
            }
            for(int i [] : List.get(u)){
                int v = i[0];
                int w = i[1];

                if(!visited[v]){
                    visited[v] = true;
                    node[v] = u;
                    weight[v] = w;
                    q.offer(v);
                }
            }
        }

        if(!found) return new int[]{-1, -1};

        int max1 = -1;
        int max2 = -1;
        int curr = end;

        while(curr != start){
            int w = weight[curr];
            if(max2 < w){
                if(max1 < w){
                    max2 = max1;
                    max1 = w;
                } 
                else max2 = w;  
            }
            curr = node[curr];
        } 
        return new int[]{max1, max2};
    }
}