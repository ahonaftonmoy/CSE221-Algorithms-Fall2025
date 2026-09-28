import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Task3 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int i [] = new int [M];
        int j [] = new int [M];

        st = new StringTokenizer(br.readLine());
        for(int k=0; k<M; k++) i[k] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int k=0; k<M; k++) j[k] = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> List = new ArrayList<>();
        for(int k=0; k<=N; k++) List.add(new ArrayList<>());

        for(int k=0; k<M; k++){
            List.get(i[k]).add(j[k]);
            List.get(j[k]).add(i[k]);
        }

        for(int k=1; k<=N; k++) Collections.sort(List.get(k));

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

        if(des[D]==-1) pw.println(-1);
        else{
            pw.println(des[D]);
            ArrayList <Integer> newList = new ArrayList<>();

            curr = D;
            while(curr!=-1){
                newList.add(curr);
                curr = par[curr];
            }

            Collections.reverse(newList);
            
            for(int k=0; k<newList.size(); k++) pw.print(newList.get(k)+" ");

            pw.println();
        }

        pw.close();
    }
}
