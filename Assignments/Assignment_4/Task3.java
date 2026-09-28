import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task3 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int Matrix [][] = new int [N][N];
        int j;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            while(st.hasMoreTokens()){
                j = Integer.parseInt(st.nextToken());
                Matrix[i][j] = 1;
            }
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
