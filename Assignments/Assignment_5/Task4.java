import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Task4 {
    static int N;
    static ArrayList<ArrayList<Integer>> List;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int i = 0;
        int j = 0;

        List = new ArrayList<>();
        for(int k=0; k<=N; k++) List.add(new ArrayList<>());

        for(int t=0; t<M; t++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            List.get(i).add(j);
        }

        ArrayList <Integer> StoK = BFS(S,K); 
        ArrayList <Integer> KtoD = BFS(K,D); 

        if(StoK==null || KtoD==null) pw.println(-1);
        else{
            for(int k=1; k<KtoD.size(); k++) StoK.add(KtoD.get(k));
            pw.println(StoK.size()-1);

            for(int k=0; k<StoK.size(); k++)pw.print(StoK.get(k)+" ");
            pw.println();
        }

        pw.close();
    }

    static ArrayList <Integer> BFS(int S, int D){
        int des [] = new int [N+1];
        int par [] = new int [N+1]; 

        for(int k=0; k<N+1; k++){
            des [k] = -1;
            par [k] = -1;
        }

        Queue <Integer> q = new LinkedList<>();
        q.add(S);

        des[S] = 0;
        Integer curr = 0;

        while(!q.isEmpty()){
            curr = q.poll();

            for(int k=0; k<List.get(curr).size(); k++){
                Integer idx = List.get(curr).get(k);
                if(des[idx]==-1){
                    des[idx] = des[curr]+1;
                    par[idx] = curr;
                    q.add(idx);
                }
            }
        }

        if(des[D]==-1) return null;
        
        ArrayList <Integer> newList = new ArrayList<>();
        
        curr = D;
        while(curr!=-1){
            newList.add(curr);
            curr = par[curr];
        }
        Collections.reverse(newList);

        return newList;
    }
}

