import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        recursive(0);

        System.out.println(sb);
    }

    static void recursive(int cnt) {
        if (cnt==N) { // 호출 횟수가 최대 호출 횟수와 같아지면 호출 종료 
            for(int n=0; n<N; n++) {
                sb.append(numbers[n]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int n=1; n<=K; n++) {
            numbers[cnt] = n;
            recursive(cnt+1);
        }
        


    }
}