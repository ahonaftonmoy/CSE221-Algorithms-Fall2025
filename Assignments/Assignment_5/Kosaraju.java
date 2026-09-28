import java.io.*;
import java.util.*;

public class Kosaraju {
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int Edges = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Integer>> List = new ArrayList<>();

        for(int i=0; i<N; i++) List.add(new ArrayList<>());

        for(int i=0; i<Edges; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); 
            int v = Integer.parseInt(st.nextToken()); 
            
            List.get(u).add(v);
        }

        kosaraju(List,pw);
        pw.close();
    }

    static void kosaraju(ArrayList<ArrayList<Integer>> List, PrintWriter pw){
        
        Stack <Integer> path = new Stack<>();
        Stack <Integer> p = new Stack<>();

        boolean visited [] = new boolean [List.size()];

        for(int i=0; i<List.size(); i++){
            if(!visited[i]) {
                p = path(i,List, visited);
                path.addAll(p);
            }
        }

        List = transpose(List);
        Arrays.fill(visited, false);

        while(!path.isEmpty()){
            int current = path.pop();
            if(!visited[current]){
                SCC(current,List,visited, pw);
                pw.println();
            }
        }
    }

    static Stack <Integer> path(int start, ArrayList<ArrayList <Integer>> List, boolean visited []){

        Stack <Integer> s = new Stack<>();
        Stack <Integer> p = new Stack<>();

        s.push(start);
        visited[start] = true;

        while(!s.isEmpty()){
            int current = s.pop();
            p.push(current);

            for(int i : List.get(current)){
                if(!visited[i]){
                    visited[i] = true;
                    s.push(i);
                }
            }
        }

        Stack <Integer> path = new Stack<>();
        while(!p.isEmpty()) path.push(p.pop());

        return path;
    }

    static int count = 1;
    static void SCC(int start, ArrayList<ArrayList<Integer>> newList, boolean visited [], PrintWriter pw){
        
        Stack <Integer> s = new Stack<>();

        s.push(start);
        visited[start] = true;

        while(!s.isEmpty()){
            int current = s.pop();
            pw.print(current +" ");

            for(int i : newList.get(current)){
                if(!visited[i]){
                    visited[i] = true;
                    s.push(i);
                }
            }
        }
        pw.print("--> "+ count++ +" SCC(s)");
    }

    static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> List){
        ArrayList<ArrayList<Integer>> newList = new ArrayList<>();

        for(int i=0; i<List.size(); i++) newList.add(new ArrayList<>());

        for(int i=0; i<List.size(); i++) for(int j : List.get(i)) newList.get(j).add(i);

        return newList;
    }
}
