import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Task6{
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> Graph;
    static boolean [] visited;
    static boolean [] back;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int i = 0;
        int j = 0;

        Graph = new ArrayList<>();
        for(int k=0; k<=N; k++) Graph.add(new ArrayList<>());

        for(int t=0; t<M; t++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            Graph.get(i).add(j);
        }

        visited = new boolean [N+1];
        back = new boolean [N+1];

        boolean found = false;

        for(int k=1; k<=N; k++){
            if(!visited[k] && DFS(k)){
                found = true;
                break;
            }
        }

        if(found) pw.println("YES");
        else pw.println("NO");
        pw.close();
    }

    static boolean DFS(int idx){
        visited [idx] = true;
        back [idx] = true;
        int n1 = 0;

        for(int i=0; i<Graph.get(idx).size(); i++){
            n1 = Graph.get(idx).get(i);
            if((!visited[n1] && DFS(n1)) || back[n1]) return true;
        }

        back[idx] =false;
        return false;
    }
}

