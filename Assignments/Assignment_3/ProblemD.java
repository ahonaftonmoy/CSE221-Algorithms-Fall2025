import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemD {

    static PrintWriter pw = new PrintWriter(System.out);

    static long [][] product(long [][] A, long [][] B){
        long [][] C = new long [2][2];
        for(int r=0; r<2; r++){
            for(int c=0; c<2; c++){
                C [r][c] = ((A [r][0] * B[0][c]) + (A [r][1] * B[1][c])) % (1000000007);
            }
        }
        return C;
    }

    static long [][] power(long [][] a, long b){
        long [][] ans = {{1,0},{0,1}}; 
        while(b>0){
            if(b%2!=0) ans = product(ans, a);
            a=product(a,a);
            b/=2;
        }
        return ans;
    }
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        long A [][] = new long [2][2];

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            A [0][0] = Long.parseLong(st.nextToken());
            A [0][1] = Long.parseLong(st.nextToken());
            A [1][0] = Long.parseLong(st.nextToken());
            A [1][1] = Long.parseLong(st.nextToken());

            long X = Long.parseLong(br.readLine());
            long [][] ans = power(A,X);
            pw.println(ans[0][0] + " " + ans[0][1]);
            pw.println(ans[1][0] + " " + ans[1][1]);
        }
        pw.close();
    }
}
