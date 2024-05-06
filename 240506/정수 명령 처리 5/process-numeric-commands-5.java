import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
       for(int i=0; i<N; i++) {
       st = new StringTokenizer(br.readLine());
        String command = st.nextToken();
        int n;
        switch(command) {
            case "push_back":
                n = Integer.parseInt(st.nextToken()); 
                list.add(n);
                break;
            case "pop_back":
                list.remove(list.size()-1);
                break;
            case "size":
                System.out.println(list.size());
                break;
            case "get":
                n = Integer.parseInt(st.nextToken());
                System.out.println(list.get(n-1));
                break;
        }
       }
    }
}