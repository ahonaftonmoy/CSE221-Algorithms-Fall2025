import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Task3 {
    public static void main(String [] args)throws Exception{     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        
        int A [] = new int [n];
        int originalIdx [] = new int [n];
        Integer sortedIdx [] = new Integer [n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A[i] = Integer.parseInt(st.nextToken());
            originalIdx[i]=i+1;
            sortedIdx[i]=i;
        }
        
        Arrays.sort(sortedIdx, (idx1,idx2) -> Integer.compare(A[idx1],A[idx2]));

        long sum=0;
        for(int i=0; i<n; i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                sum = A[sortedIdx[i]] + A[sortedIdx[l]] + A[sortedIdx[r]];
                if(sum==x){
                    pw.println(originalIdx[sortedIdx[i]]+" "+originalIdx[sortedIdx[l]]+" "+originalIdx[sortedIdx[r]]);
                    pw.close();
                    return;
                }
                else if(sum < x)l++;
                else r--;
            }
        }
        pw.println(-1);
        pw.close();
    }
}
