import java.io.*;
import java.util.StringTokenizer;

public class Task6 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N=Integer.parseInt(br.readLine());
        long [] arr=new long[N];

        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            if(st.hasMoreTokens()) arr[i]=Long.parseLong(st.nextToken());
        }

        boolean swapped=true;
        while(swapped){
            swapped=false;
            for(int j=0;j<N-1;j++){
                if(((arr[j]%2==0 && arr[j+1]%2==0) || (arr[j]%2!=0 && arr[j+1]%2!=0)) && arr[j]>arr[j+1]){
                    swap(j,j+1,arr);
                    swapped=true;
                }
            }
        }
        for(int k=0;k<N-1;k++){
            pw.print(arr[k]+" ");
        }
        pw.println(arr[N-1]);
        pw.close();
    }

    public static void swap(int n1, int n2, long[] arr){
        long temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
