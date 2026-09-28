import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task2 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] A = new int [N];
        int [] B = new int [M];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = M-1;

        int min = Math.abs(A[0]+B[M-1]-K);
        int sum = 0;
        int diff = 0;

        int i = 0;
        int j = M-1;
        while(p1<N && p2>-1){
            sum = A[p1]+B[p2];
            diff = Math.abs(sum-K);
            if(diff<min){
                min=diff;
                i=p1;
                j=p2;
            }
            if(sum>K)p2-=1;
            else p1+=1;
        }

        pw.println((i+1)+" "+(j+1));
        pw.close();
    }
}
