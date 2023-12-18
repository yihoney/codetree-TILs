import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numbers[] = new int[N];
        for(int n=0; n<N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[N];
        for(int n=0; n<N; n++) {
            dp[n] = 1;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1); 
                }

            }
        }

        int ans = Integer.MIN_VALUE;
        for(int n=0; n<N; n++) {
            ans = Math.max(ans, dp[n]);
        }

        System.out.println(ans);
    }
}