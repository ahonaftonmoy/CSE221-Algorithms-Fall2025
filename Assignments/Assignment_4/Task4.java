import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task4 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        int edgeCount [] = new int[N];

        st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int e0 = Integer.parseInt(st1.nextToken())-1;
            int e1 = Integer.parseInt(st2.nextToken())-1;
            edgeCount[e0]++;
            edgeCount[e1]++;
        }
        
        int degCount = 0;
        for(int j=0; j<N; j++){
            if(edgeCount[j]%2!=0) degCount++;
        }

        if(degCount==0 || degCount==2) pw.println("YES");
        else pw.println("NO");

        pw.close();
    }
}
