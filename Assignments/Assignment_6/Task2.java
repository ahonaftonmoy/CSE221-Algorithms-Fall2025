import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList <ArrayList<Integer>> List = new ArrayList<>();

        for(int i=0; i<=N ;i++) List.add(new ArrayList<>());

        for(int t=0; t<M; t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            List.get(i).add(j);
            List.get(j).add(i);
        }

        boolean visited [] = new boolean [N+1];
        char team [] = new char [N+1];
        
        Queue <Integer> q = new LinkedList<>();

        int max = 0;

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited [i] = true;
                q.add(i);
                team [i] = 'H';
                int Human = 1;
                int Robot = 0;

                while(!q.isEmpty()){
                    int current = q.poll();

                    for(int k : List.get(current)){
                        if(!visited[k]){
                            q.add(k);
                            visited [k] = true;
                            if(team [current]=='R'){
                                team [k] ='H';
                                Human++;
                            }
                            else{
                                team [k] ='R';
                                Robot++;
                            }
                        }
                    }
                }
                max += Math.max(Human,Robot);
            }
        }

        pw.println(max);
        pw.close();
    }
}