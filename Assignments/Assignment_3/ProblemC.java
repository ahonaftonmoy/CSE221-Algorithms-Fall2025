import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemC {
        public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long ans = 1;

        while(b>0){
            if(b%2!=0) ans=(ans*a)%107;
            a=(a*a)%107;
            b/=2;
        }

        pw.println(ans);
        pw.close();
    }
}
