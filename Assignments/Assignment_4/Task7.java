import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task7 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int Board [][] = new int[N][M];

        int x = 0;
        int y = 0;

        for(int i =0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            Board[x][y] = 1;
        }

        int moves [][] = {{-2,-2,-1,-1,1,1,2,2},{-1,1,-2,2,-2,2,-1,1}};

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(Board[r][c]==1 && check(Board,moves,r,c)) {
                    pw.println("YES");
                    pw.close();
                    return;
                }
            }
        }

        pw.println("NO");
        pw.close();
    }

    static boolean check(int [][] Board, int [][] moves, int r, int c){
        int new_r = 0;
        int new_c = 0;

        for(int i=0; i<8; i++){
            new_r = r + moves[0][i];
            new_c = c + moves[1][i];

            if(new_r>=0 && new_r<Board.length && new_c>=0 && new_c<Board[0].length && Board[new_r][new_c]==1){
                return true;
            }
        }
        
        return false;
    }
}
