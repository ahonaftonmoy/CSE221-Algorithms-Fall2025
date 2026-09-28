import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemF {
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int A [] = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());    
        
        BSTHelper(A,0, N-1);
        pw.close();
    }

    public static void BSTHelper(int [] A, int left, int right){
        if(left>right) return;
        pw.print(A[(left+right)/2]+ " ");
        BSTHelper(A, left,((left+right)/2) - 1);
        BSTHelper(A, ((left+right)/2) + 1, right);
    }
}
