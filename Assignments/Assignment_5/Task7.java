import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Task7{
    static int R;
    static int H;
    static int [] r = {-1,1,0,0};
    static int [] c = {0,0,-1,1};
    static boolean [][] visited;
    static char [][] charac;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        charac = new char[R][H];
        visited = new boolean [R][H];

        for(int k=0; k<R; k++) charac[k] = br.readLine().toCharArray();

        int maxD = 0;

        for(int i=0; i<R; i++){
            for(int j=0; j<H; j++){
                if(!visited[i][j] && charac[i][j]!='#') maxD = Math.max(maxD,BFS(i,j));
            }
        }

        pw.println(maxD);
        pw.close();
    }

    static int BFS(int idx1, int idx2){
        Queue <int []> q = new LinkedList<>();
        q.add(new int[]{idx1,idx2});
        visited[idx1][idx2] = true;
        int D = 0;

        if(charac[idx1][idx2]=='D') D = 1;

        int curr [];
        int row = 0;
        int col = 0;
        int newr = 0;
        int newc = 0;
        while(!q.isEmpty()){
            curr = q.poll();
            row = curr [0];
            col = curr [1];

            for(int i=0; i<4; i++){
                newr = row + r[i];
                newc = col + c[i];

                if((newr>=0 && newr<R && newc>=0 && newc<H) && (!visited[newr][newc]) && charac[newr][newc]!='#'){
                    visited[newr][newc] = true;
                    if(charac[newr][newc]=='D') D++;
                    q.add(new int[]{newr, newc});
                }
            }
        }

        return D;
    }
}

