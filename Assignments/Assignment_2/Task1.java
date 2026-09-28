import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task1 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int [] arr = new int[N];
        int targetSum = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = N-1;
        
        while(p1<p2 && p1<N && p2<N){
            if(arr[p1]+arr[p2]==targetSum){
                pw.println((p1+1)+" "+ (p2+1));
                pw.close();
                return;
            }
            else if(arr[p1]+arr[p2]<targetSum)p1+=1;
            else p2-=1;
        }
        pw.println(-1);
        pw.close();
    }
}
