import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Task5{
    static int N;
    static int R;
    static ArrayList<ArrayList<Integer>> Tree;
    static int [] subSize;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int i = 0;
        int j = 0;

        Tree = new ArrayList<>();
        for(int k=0; k<=N; k++) Tree.add(new ArrayList<>());

        for(int t=0; t<N-1; t++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            Tree.get(i).add(j);
            Tree.get(j).add(i);
        }

        subSize = new int [N+1]; 
        boolean visited [] = new boolean [N+1];
        DFS(R,visited);

        int Q = Integer.parseInt(br.readLine());
        for(int k=0; k<Q; k++){
            i = Integer.parseInt(br.readLine());
            pw.println(subSize[i]);
        }

        pw.close();
    }

    static int DFS(int idx, boolean [] visited){
        visited[idx] = true;
        int n1 = 1;
        int n2 = 0;

        for(int i=0; i<Tree.get(idx).size(); i++){
            n2 = Tree.get(idx).get(i);
            if(!visited[n2]){
                n1+=DFS(n2,visited);
            }
        }

        subSize[idx] = n1;
        return n1;
    }
}

