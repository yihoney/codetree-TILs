import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 식빵의 개수
        int m = Integer.parseInt(st.nextToken()); // 레시피 암호문의 개수
        List<Character> list = new ArrayList<>();
        String str = br.readLine();
        for(int i=0; i<n; i++) {
            list.add(str.charAt(i));
        }
        ListIterator<Character> it = list.listIterator(list.size());
        for(int i=0; i<m; i++) {
            String cmd = br.readLine();
            switch(cmd) {
                case "L":
                    if(it.hasPrevious()) {
                        it.previous();
                    }
                    break;
                case "R":
                    if(it.hasNext()) {
                        it.next();
                    }
                    break;
                case "D":
                    if(it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                    break;
                default:
                    st = new StringTokenizer(cmd);
                    if("P".equals(st.nextToken())) {
                        it.add(st.nextToken().charAt(0));
                    }
            }
        }
        it = list.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next());
        }

    }
}