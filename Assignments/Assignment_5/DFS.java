import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS {
    public static void main(String []args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int i [] = new int[M];  
        for(int r=0; r<M; r++) i[r] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int j [] = new int[M];  
        for(int r=0; r<M; r++) j[r] = Integer.parseInt(st.nextToken());

        ArrayList <ArrayList<Integer>> List = new ArrayList<>();
        for(int c=0; c<=N; c++) List.add(new ArrayList<>());

        for(int t=0; t<M; t++){
            List.get(i[t]).add(j[t]);
            List.get(j[t]).add(i[t]);
        }

        boolean visited [] = new boolean[N+1];
        Stack <Integer> s = new Stack<>();

        s.push(1);
        visited[1] = true;

        while(!s.isEmpty()) {
            Integer current = s.pop();
            pw.print(" " + current + " ");

            for(int k = List.get(current).size()-1; k>=0; k--) {
                int idx = List.get(current).get(k);

                if (!visited[idx]) {
                    visited[idx] = true;
                    s.push(idx);
                }
            }
        }

        pw.close();
    }

    static void dfs(int current, ArrayList<ArrayList<Integer>> List, boolean[] visited, PrintWriter pw) {
        visited[current] = true;
        pw.print(current + " ");

        for (int k : List.get(current)) {
            if (!visited[k]) dfs(k, List, visited, pw);
        }
    }
}
