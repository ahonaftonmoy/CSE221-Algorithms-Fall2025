import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemB {

    static long count = 0;

    public static int [] mergeSort(int [] A){
        if(A.length <=1) return A;

        int mid = A.length/2;

        int [] left = new int [mid];
        int [] right = new int [A.length - mid];

        for(int i=0; i<mid; i++) left [i] = A[i];
        for(int i=mid; i<A.length; i++) right [i - mid] = A[i];

        left = mergeSort(left);
        right = mergeSort(right);

        return Merge(left,right);
    }

    public static int[] Merge(int [] left, int [] right){
        int [] A = new int [left.length + right.length];
        int i =0, j = 0, k = 0;
        
        if(right.length >= 1){
            int [] r = new int [right.length];
            for(int l=0; l<right.length;l++) r [l] = Math.abs(right[l]);
            Arrays.sort(r);
            int idx = 0;
            for(int s=0; s<left.length; s++){
                if(left[s] < 1) continue;
                while(idx < right.length){
                    long base = r[idx];
                    long squared = base * base;
                    if(squared < left[s]) idx++;
                    else break;
                }
                count+=idx;
            }
        }

        while(i<left.length && j<right.length){
            if(left[i]<=right[j]) A[k++] = left[i++];
            else A[k++] = right[j++];
        }
        while(i<left.length) A[k++] = left[i++];
        while(j<right.length) A[k++] = right[j++];

        return A;
    }
    public static void main(String [] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int A [] = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());

        A = mergeSort(A);
        pw.println(count);
        pw.close();
    }
}
