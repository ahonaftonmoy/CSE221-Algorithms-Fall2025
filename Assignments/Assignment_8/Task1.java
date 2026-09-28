import java.io.*;
import java.util.*;

public class Task1{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        union uf = new union(N);

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int size = uf.unionF(A, B);
            pw.println(size);
        }

        pw.close();
    }
}

class union {
    int[] parent;
    int[] size;

    public union(int N) {
        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int a) {
        if (parent[a] != a) parent[a] = find(parent[a]);
        return parent[a];
    }

    public int unionF(int x, int y) {
        int rX = find(x);
        int rY = find(y);

        if (rX == rY) return size[rX];

        if (size[rX] < size[rY]) {
            parent[rX] = rY;
            size[rY] += size[rX];
            return size[rY];
        } 
        else{
            parent[rY] = rX;
            size[rX] += size[rY];
            return size[rX];
        }
    }
}