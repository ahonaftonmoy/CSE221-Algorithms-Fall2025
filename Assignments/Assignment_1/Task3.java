import java.io.*;

public class Task3 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            Long N=Long.parseLong(br.readLine());
            N=(N*(N+1))/2;
            pw.println(N);
        }
        pw.close();
    }
}
