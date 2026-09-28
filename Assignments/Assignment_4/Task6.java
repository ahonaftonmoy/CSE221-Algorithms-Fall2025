import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Task6 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());

        int movesOfi [] = {-1,-1,-1,0,0,1,1,1};
        int movesOfj [] = {-1,0,1,-1,1,-1,0,1};

        ArrayList <int []> Moves = new ArrayList<>();

        int newi = 0;
        int newj = 0;

        for(int k=0; k<8; k++){
            newi = i + movesOfi[k];
            newj = j + movesOfj[k];

            if(newi>=1 && newi<=N && newj>=1 && newj<=N){
                Moves.add(new int[] {newi, newj});
            }
        }

        pw.println(Moves.size());
        for(int l=0; l<Moves.size(); l++){
            pw.println(Moves.get(l)[0] +" "+ Moves.get(l)[1]);
        }

        pw.close();
    }
}
