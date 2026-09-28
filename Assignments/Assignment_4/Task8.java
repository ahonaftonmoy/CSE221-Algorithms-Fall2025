import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task8{
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int Matrix [][] = new int [N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i!=j && gcd(i+1,j+1)==1) Matrix[i][j] = 1;
            }
        }

        int X = 0;
        int K = 0;
        int count;
        boolean found;
        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken())-1;
            K = Integer.parseInt(st.nextToken());

            found = false;
            count = 0;
            for(int Y=0; Y<N; Y++){
                if(Matrix[X][Y]==1){
                    count++;
                    if(count==K){
                        pw.println(Y+1);
                        found = true;
                        break;
                    }
                }
            }
            if(!found) pw.println(-1);
        }

        pw.close();
    }

    static int gcd(int n1, int n2){
        int red = 0;
        while(n2!=0){
            red = n1 % n2;
            n1 = n2;
            n2 = red;
        }
        return n1;
    }
}