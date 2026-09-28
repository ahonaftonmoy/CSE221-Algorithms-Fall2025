
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
   public static void main(String[] var0) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      ArrayList <ArrayList<Integer>> List = new ArrayList<>();

      for(int k = 0; k <= N; ++k) List.add(new ArrayList<>());

      for(int k = 0; k < M; k++) {
         st = new StringTokenizer(br.readLine());
         int i = Integer.parseInt(st.nextToken());
         int j = Integer.parseInt(st.nextToken());
         
         List.get(i).add(j);
         List.get(j).add(i);
      }

      boolean[] visited = new boolean[N + 1];
      Queue <Integer> q = new LinkedList<>();

      q.add(1);
      visited[1] = true;

      while(!q.isEmpty()) {
         Integer current = q.poll();
         pw.print("" + current + " ");

         for(int i = 0; i < List.get(current).size(); i++) {
            int idx = List.get(current).get(i);

            if (!visited[idx]) {
               visited[idx] = true;
               q.add(idx);
            }
         }
      }

      pw.close();
   }
}
