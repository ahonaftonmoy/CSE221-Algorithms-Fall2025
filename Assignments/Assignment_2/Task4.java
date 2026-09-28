import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task4 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int A [] = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken()); 
        }

        int M = Integer.parseInt(br.readLine());
        int B [] = new int [M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken()); 
        }

        int C [] =new int [N+M];

        int p1 = 0;
        int p2 = 0;
        int idx = 0;

        while(p1<N && p2<M){
            if(A[p1]<B[p2])C[idx++] = A[p1++];
            else C[idx++] = B[p2++];
        }

        while(p1<N) C[idx++] = A[p1++];

        while(p2<M) C[idx++] = B[p2++];

        for(int i=0; i<(N+M); i++){
            pw.print(C[i]+" ");
        }

        pw.close();
    } 
}
