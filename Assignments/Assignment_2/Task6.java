import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task6 {
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
        int repeat [] = new int [N+1];
        int subArrayLen = 0;
        int unique = 0;

        while(p2<N){
            if(repeat[A[p2]]==0)unique++;
            repeat[A[p2]]++;

            while(unique>K)if(--repeat[A[p1++]]==0)unique--;
            
            subArrayLen=Math.max(subArrayLen,p2-p1+1);
            p2++;
        }

        pw.println(subArrayLen);
        pw.close();
    }  
}
