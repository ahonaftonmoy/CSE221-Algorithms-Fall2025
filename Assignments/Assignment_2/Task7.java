import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task7 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A [] = new int [N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int lower = Integer.parseInt(st.nextToken());
            int higher = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = N;
            int mid = 0;
            while(left<right){
                mid = (left+right)/2;
                if(A[mid]<lower) left = mid+1;
                else right = mid;
            }
            lower = left;

            left = 0;
            right = N;
            mid = 0;
            while(left<right){
                mid = (left+right)/2;
                if(A[mid]<=higher) left = mid+1;
                else right = mid;
            }
            higher = left;

            pw.println(higher-lower);
        }
        pw.close();
    }
}
