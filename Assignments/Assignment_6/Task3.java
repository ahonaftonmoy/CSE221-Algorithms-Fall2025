import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int i1 = Integer.parseInt(st.nextToken());
        int j1 = Integer.parseInt(st.nextToken());
        int i2 = Integer.parseInt(st.nextToken());
        int j2 = Integer.parseInt(st.nextToken());

        int movesOfi [] = {2, 1, -1, -2, -2, -1, 1, 2};
        int movesOfj [] = {1, 2, 2, 1, -1, -2, -2, -1};

        boolean visited [][] = new boolean [N+1][N+1];
        Queue <Position> q = new LinkedList<>();

        visited[i1][j1] = true;
        q.add(new Position(i1, j1, 0));

        int ans = -1;

        while(!q.isEmpty()){
            Position current = q.poll();

            if(current.i==i2 && current.j==j2){
                ans = current.moves;
                break;
            }

            for(int i=0; i<8; i++){
                int newi = current.i + movesOfi[i];
                int newj = current.j + movesOfj[i];

                if(newi>=1 && newi<=N && newj>=1 && newj<=N && !visited[newi][newj]){
                    visited[newi][newj] = true;
                    q.add(new Position(newi, newj, current.moves+1));
                }
            }
        }
        pw.println(ans);
        pw.close();
    }

    static class Position {
        int i;
        int j;
        int moves;

        Position(int i, int j, int moves){
            this.i = i;
            this.j = j;
            this.moves = moves;
        }
    }
}