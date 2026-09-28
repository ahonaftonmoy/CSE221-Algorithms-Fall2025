import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task5 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int A [] = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int p1 = 0;
        int p2 = 0;
        int sum=0;
        int subArray=0;

        while(p1<N){
            sum+=A[p1];
            while(sum>K){
                sum-=A[p2++];
            }
            subArray=Math.max(subArray,p1-p2+1);
            p1++;
        }

        pw.println(subArray);
        pw.close();
    }
}
