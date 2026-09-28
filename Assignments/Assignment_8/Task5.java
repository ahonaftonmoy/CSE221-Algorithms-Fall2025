import java.io.*;
import java.util.*;
 
public class Task5{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer  st;

        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Task[] task = new Task[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                task[j] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(task, Comparator.comparingInt(h -> h.y));

            TreeMap <Integer, Integer> map = new TreeMap<>();

            int finish = 0;
            int used = 0;

            for (Task t: task) {
                Integer best = map.lowerKey(t.x);
                if (best != null) {
                    finish++;
                    int c = map.get(best);

                    if (c == 1) map.remove(best);
                    else map.put(best, c - 1);
                    
                    map.put(t.y, map.getOrDefault(t.y, 0) + 1);
                } 
                else if (used< M) {
                    finish++;
                    used++;
                    map.put(t.y, map.getOrDefault(t.y, 0) + 1);
                }
               
            }
            sb.append(finish).append("\n");
        }
        pw.print(sb);
        pw.close();
    }

    static class Task {
        int x, y;
        Task(int x, int y) { 
            this.x = x; 
            this.y = y; 
        }
    }
}
