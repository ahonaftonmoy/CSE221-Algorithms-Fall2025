import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task5 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        int inDeg [] = new int[N];
        int outDeg [] = new int [N];

        st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int out = Integer.parseInt(st1.nextToken())-1;
            outDeg[out]++;

            int in = Integer.parseInt(st2.nextToken())-1;
            inDeg[in]++;
        }
        
        for(int j=0; j<N; j++) pw.print(inDeg[j]-outDeg[j]+" ");

        pw.close();
    }
}
