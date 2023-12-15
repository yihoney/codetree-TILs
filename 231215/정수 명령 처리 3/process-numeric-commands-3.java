import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        while(N-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch(cmd) {
                case "pop_front":
                    sb.append(q.pollFirst()).append("\n");
                break;
                case "pop_back":
                    sb.append(q.pollLast()).append("\n");
                break;
                case "size":
                    sb.append(q.size()).append("\n");
                break;
                case "empty":
                    sb.append(q.isEmpty()?1:0).append("\n");
                break;
                case "front":
                    sb.append(q.peekFirst()).append("\n");
                break;
                case "back":
                    sb.append(q.peekLast()).append("\n");
                break;
                default:
                    int num = Integer.parseInt(st.nextToken());
                    switch(cmd) {
                        case "push_front":
                            q.addFirst(num);
                        break;
                        case "push_back":
                            q.addLast(num);
                        break;
                    }
            }
        }
        System.out.println(sb);
    }
}