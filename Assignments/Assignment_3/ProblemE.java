import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemE {

    static long pow(long a , long b, long m){
        long res = 1;
        while(b>0){
            if(b%2!=0) res = (res * a) % m + b - b--;
            else{
                a = (a * a) % m;
                b/=2;
            }
        } 
        return res;
    }

    static long FSDrift(long a, long n, long m){
        if(n==0) return 0;
        else if(n==1) return a % m;

        long n1 = FSDrift(a, n/2, m);
        long n2 = pow(a, n/2, m);
        long res = 0;

        if(n%2!=0) res = (((n1 * (1 + n2)) % m)+(((n2 * n2 ) % m) * a) % m) % m;
        else res = n1 * (1 + n2) % m;

        if (res<0) res+=m;

        return res;
    }
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken()); 
            long m = Long.parseLong(st.nextToken());
            pw.println(FSDrift(a, n, m));
        }

        pw.close();
    }
}
