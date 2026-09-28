import java.io.*;
import java.util.regex.*;

public class Task8 {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N=Integer.parseInt(br.readLine());
        String [] train = new String [N];
        
        Pattern pt = Pattern.compile("^(\\w+) will departure for \\w+ at (\\d\\d):(\\d\\d)$");
        
        for(int i=0; i<N; i++){
            train[i]=br.readLine();
        }

        Matcher m1,m2;
        String name1="", name2="";
        int hour1=0, hour2=0, minutes1=0, minutes2=0,time1=0,time2=0;
        for(int j=0; j<N-1; j++){
            for(int k=0; k<N-1-j; k++){
                m1=pt.matcher(train[k]);
                if(m1.find()){
                    name1=m1.group(1);
                    hour1=Integer.parseInt(m1.group(2));
                    minutes1=Integer.parseInt(m1.group(3)); 
                }

                m2=pt.matcher(train[k+1]);
                if(m2.find()){
                    name2=m2.group(1);
                    hour2=Integer.parseInt(m2.group(2));
                    minutes2=Integer.parseInt(m2.group(3));
                }

                if(name1.compareTo(name2)>0){
                    swap(k, k+1,train);
                }
                else if(name1.compareTo(name2)==0){
                    time1=(hour1*60)+minutes1;
                    time2=(hour2*60)+minutes2;
                    if(time1<time2){
                        swap(k,k+1,train);
                    }
                }
            }
        }

        for(int l=0;l<N;l++){
            pw.println(train[l]);
        }
        pw.close();
    }

    public static void swap(int n1, int n2, String[] arr){
        String temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
