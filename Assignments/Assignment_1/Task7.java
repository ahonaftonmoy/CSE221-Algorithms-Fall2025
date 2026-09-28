import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task7 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int T = Integer.parseInt(br.readLine()), N, swaps;

        for(int i=0; i<T; i++){
            swaps=0;
            N = Integer.parseInt(br.readLine());
            
            int [] id = new int[N];
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                if(st.hasMoreTokens()) id[j]=Integer.parseInt(st.nextToken());
            }

            int [] marks = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<N; k++){
                if(st.hasMoreTokens()) marks[k]=Integer.parseInt(st.nextToken());
            }

            int max;
            for(int l=0; l<N-1; l++){
                max=l;
                for(int m=l+1; m<N; m++){
                    if(marks[m]>marks[max] || (marks[m]==marks[max] && id[m]<id[max])){
                        max=m;
                    }  
                }
                if(max!=l){
                    swap(l,max,marks);
                    swap(l,max,id);
                    swaps++;
                }
            }

            pw.println("Minimum swaps: "+swaps);
            for(int n=0; n<N; n++){
                pw.println("ID: "+id[n]+" Mark: "+marks[n]);
            }
        }        
        pw.close();
    }   

    public static void swap(int n1, int n2, int[] arr){
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
