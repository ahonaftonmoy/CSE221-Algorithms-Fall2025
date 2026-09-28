import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task5 {
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int count=0;
        String [] indexes = new String[N*N];
        for(int i=0;i<N-2;i++){
            for(int j=0;j<N-2-i;j++){
                if(arr[j]>arr[j+2]){
                int temp=arr[j];
                arr[j]=arr[j+2];
                arr[j+2]=temp;

                indexes[count++]=(j+1)+" "+(j+3);
                }
            }
        }

        boolean sorted=true;
        for(int i=0;i<N-1;i++){
            if(arr[i]>arr[i+1]){
                sorted=false;
                break;
            }
        }

        if(sorted){
            pw.println("YES"+"\n"+count);
            for(int i=0;i<count;i++){
                pw.println(indexes[i]);
            }
        }
        else{
            pw.println("NO");
        }
        pw.close();
    }
}
