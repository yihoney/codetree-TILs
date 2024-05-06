import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> list = new LinkedList();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
       for(int i=0; i<N; i++) {
       st = new StringTokenizer(br.readLine());
        String command = st.nextToken();
        int n;
        switch(command) {
            case "push_front":
                n = Integer.parseInt(st.nextToken()); 
                list.addFirst(n);
                break;
            case "push_back":
                n = Integer.parseInt(st.nextToken()); 
                list.addLast(n);
                break;  
            case "pop_front":
                System.out.println(list.pollFirst());
                break;
            case "pop_back":
                System.out.println(list.pollLast());
                break;  
            case "size":
                System.out.println(list.size());
                break;
            case "empty":
                int ans = list.isEmpty()?1:0;
                System.out.println(ans);
                break;
            case "front":
                System.out.println(list.peekFirst());
                break;
            case "back":
                System.out.println(list.peekLast());
                break;
        }
       }
    }
}