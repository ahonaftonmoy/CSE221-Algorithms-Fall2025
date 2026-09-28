import java.io.*;
import java.util.*;
public class TopologicalSort {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList <ArrayList<Integer>> List = new ArrayList<>();
        int inDegree [] = new int[N+1];

        for(int i=0; i<=N ;i++) List.add(new ArrayList<>());

        for(int t=0; t<M; t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            List.get(i).add(j);
            inDegree[j]++;
        }

        Queue <Integer> zeroDegree = new LinkedList<>();

        for(int k=1; k<=N; k++) if(inDegree[k]==0) zeroDegree.add(k);

        int NodeCount = 0;
        int Order [] = new int[N];
        int i = 0;

        while(!zeroDegree.isEmpty()){
            int current = zeroDegree.poll();
            Order [i++] = current;
            NodeCount++;

            for(int k=0; k<List.get(current).size(); k++){
                int idx = List.get(current).get(k);
                inDegree[idx]--;
                if(inDegree[idx]==0) zeroDegree.add(idx);
            }
        }

        if(NodeCount==N){
            for(int k=0; k<N; k++){
                pw.print(Order[k]+" ");
            }
        }
        else pw.print(-1);

        pw.close();
    }
}
