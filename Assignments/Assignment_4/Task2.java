import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task2 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        Node List [] = new Node [N];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        for(int T=0; T<M; T++){
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st3.nextToken());

            if(List[i]==null) List[i] = new Node(j, cost);
            else{
                Node temp = List[i];
                while(temp.next!=null) temp = temp.next;
                temp.next = new Node(j, cost); 
            }
        }

        for(int k=0; k<List.length; k++){
            pw.print((k+1)+":");
            Node temp = List[k];
            while(temp!=null){
                pw.print(" ("+temp.index+","+temp.cost+")"); 
                temp=temp.next;
            }
            pw.println();
        }

        pw.close();
    }
}

class Node {
    int index;
    int cost;
    Node next;

    Node(int index, int cost){
        this.index = index;
        this.cost = cost;
        this.next = null;
    }
}
