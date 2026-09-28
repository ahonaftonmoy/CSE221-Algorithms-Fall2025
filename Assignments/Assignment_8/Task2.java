import java.io.*;
import java.util.*;

public class Task2{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] edges = new int[M][3];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        Union uf = new Union(N);

        long count = 0;
        int used = 0;

        for (int[] edge : edges) {
            if (uf.unionF(edge[0], edge[1])) {
                count += edge[2];
                used++;
                if (used ==(N-1)) {
                    break;
                }
            }
        }

        pw.println(count);
        pw.close();
    }
}
class Union{
    int[] parent;
    int[] rank;

    public Union(int N) {
        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int a) {
        if (parent[a] != a) parent[a] = find(parent[a]);
        return parent[a];
    }

    
    public boolean unionF(int x, int y) {
        int rX = find(x);
        int rY = find(y);

        if (rX == rY) return false;

        if (rank[rX] < rank[rY]) parent[rX] = rY;

        else if (rank[rX] > rank[rY]) parent[rY] = rX;
        else {
            parent[rY] = rX;
            rank[rX]++;
        }

        return true;
    }
}
