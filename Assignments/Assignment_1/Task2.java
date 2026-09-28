import java.io.*;
import java.util.regex.*;

public class Task2{

    public static void main(String [] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);

        int T=Integer.parseInt(br.readLine());
        Double num1,num2,answer=0.0;

        Pattern pat= Pattern.compile("^calculate (\\d+) (.) (\\d+)$");

        for(int i=1;i<=T;i++){
            String s=br.readLine();
            Matcher mat=pat.matcher(s);
            if(mat.find()){
                num1=Double.parseDouble(mat.group(1));
                s=mat.group(2);
                num2=Double.parseDouble(mat.group(3));
                
                switch(s){
                    case "+":answer=num1+num2; break;
                    case "-":answer=num1-num2; break;
                    case "*":answer=num1*num2; break;
                    case "/":answer=num1/num2; break;
                }
            }

            pw.printf("%6f\n",answer);
        }
        pw.close();
    }

}