import java.io.*;
import java.util.*;

public class Task4{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] inter = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            inter[i][0] = Integer.parseInt(st.nextToken());
            inter[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inter, (a, b) -> Integer.compare(a[1], b[1]));

        List <int[]> selected = new ArrayList<>();

        int end = -1;
        for (int[] in : inter) {
            if (in[0] > end) {
                selected.add(in);
                end = in[1];
            }
        }

        pw.println(selected.size());

        for (int[] task : selected) pw.println(task[0] + " " + task[1]);

        pw.close();
    }
}
