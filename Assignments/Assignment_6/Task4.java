import java.io.*;
import java.util.*;

public class Task4 {

    static int [] distance;
    static ArrayList<ArrayList<Integer>> List;
    static boolean [] visited;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List = new ArrayList<>();

        for(int i=0; i<=N;i++) List.add(new ArrayList<>());

        for(int t=0; t<N-1; t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            List.get(i).add(j);
            List.get(j).add(i);
        }

        int A = BFS(1,N);
        int B = BFS(A,N);

        pw.println(distance[B]+"\n"+A+" "+B);
        pw.close();
    }

    static int BFS(int start, int N){
        Queue <Integer> q = new LinkedList<>();
        visited = new boolean [N+1];
        distance= new int [N+1];

        q.add(start);
        visited[start] = true;
        distance[start] = 0;

        int n = start;

        while(!q.isEmpty()){
            int current = q.poll();

            for(int i : List.get(current)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    distance[i] = distance[current]+1;

                    if(distance[i] > distance[n]) n = i;
                }
            }
        }
        return n;
    }
}