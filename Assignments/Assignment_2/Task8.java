import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task8 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()); 
            int n = k%(x-1);  
            if(n!=0)pw.println((x*(k/(x-1)))+(k%(x-1)));
            else pw.println((x*(k/(x-1)))-1);
        }
        pw.close();
    }
}
