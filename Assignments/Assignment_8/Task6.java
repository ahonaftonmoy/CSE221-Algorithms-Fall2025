import java.io.*;
import java.util.*;

public class Task6{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] task = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            task[i][0] = Integer.parseInt(st.nextToken()); 
            task[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(task, (a, b) -> Integer.compare(a[0], b[0]));

        long reward = 0;
        long time = 0;
        for (int[] t : task) {
            time += t[0]; 
            reward += t[1] - time;             
        }
        
        pw.println(reward);
        pw.close();
    }
}
