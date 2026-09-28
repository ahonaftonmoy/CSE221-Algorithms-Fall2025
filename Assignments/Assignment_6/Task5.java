import java.io.*;
import java.util.*;

public class Task5 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int k=0; k<T; k++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if(s==t){
                pw.println(0);
                continue;
            }
            else if(s>t){
                pw.println(-1);
                continue;
            }

            int distance [] = new int [t+1];
            for(int i=0; i<=t; i++) distance[i] = -1;

            Queue <Integer> q = new LinkedList<>();

            q.add(s);
            distance[s] = 0;

                    
            while(!q.isEmpty()){
                int current = q.poll();
                int dis = distance[current];

                for(int i=2; i*i<=current; i++){
                    if(current%i==0){
                        if(isPrime(i)) add(current, i, t, distance, dis, q);
                        int n = current/i;
                        if(n!=i && isPrime(n)) add(current, n, t, distance, dis, q);
                    }
                }
            }

            pw.println(distance[t]);
        }

        pw.close();
    }

    static void add(int current, int primeFactor, int t, int [] distance, int dis,  Queue <Integer> q){
        int n = current + primeFactor;
        if(n<=t && distance[n]==-1){
            distance[n] = dis+1;
            q.add(n);
        }
    }

    static boolean isPrime(int n){
        if (n<2) return false;
        for(int i=2; i*i<=n; i++){
            if (n%i==0) return false;
        }
        return true;
    }
}