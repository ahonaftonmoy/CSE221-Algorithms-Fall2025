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
        long M = Long.parseLong(st.nextToken());

        int Matrix [][] = new int [N][N];

        for(int T=0; T<M; T++){
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            
            Matrix[i][j] = cost;
        }

        for(int r=0; r<Matrix.length; r++){
            for(int c=0; c<Matrix[0].length; c++){
                pw.print(Matrix[r][c]+" ");
            }
            pw.println();
        }

        pw.close();
    }
}
