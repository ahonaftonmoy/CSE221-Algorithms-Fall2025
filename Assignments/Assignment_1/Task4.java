import java.io.*;
import java.util.StringTokenizer;

public class Task4 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());
        long [] arr;

        for(int i=1; i<=T; i++){
            long N = Long.parseLong(br.readLine());
            arr = new long[(int)N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[j]=Long.parseLong(st.nextToken());
            }

            boolean nonDecreasing=true;
            for(int k=0; k<N-1; k++){
                if(arr[k]>arr[k+1]){
                    nonDecreasing= false; 
                    break;
                }
            }

            if(nonDecreasing) pw.println("YES");
            else pw.println("NO");
        }
        pw.close();
    }
}
