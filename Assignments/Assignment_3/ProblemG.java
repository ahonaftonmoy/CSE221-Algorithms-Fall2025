import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemG{

    static int idx = 0;
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int in [] = new int [N];
        int pre [] = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i <N; i++) in[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i =0; i <N; i++) pre[i] = Integer.parseInt(st.nextToken());

        post(in, pre, 0, N-1);
        
        pw.close();
    }

    static void post(int [] in, int [] pre, int i, int j){
        if(i > j) return;

        int n = pre[idx++];
        int root = -1;

        for(int k=i; k<=j; k++){
            if(in[k]==n){
                root = k;
                break;
            }
        }

        post(in, pre , i, root - 1);
        post(in, pre ,root + 1, j);

        pw.print(n+" ");
    }
}