import java.util.*;
import java.io.*;

public class Main {
    static int MIN_VALUE = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numbers[] = new int[n];
        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[n]; // dp[i]: 도착 위치가 i일 때의 최대 점프 횟수 
        for(int i=1; i<n; i++) {
            dp[i] = MIN_VALUE;
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                // if(dp[j] == MIN_VALUE) { // dp[j]가 아직 초깃값 그대로라면 이 위치에는 도달하지 못한 경우라는 뜻이므로 이후 계산 과정 생략
                //     continue;
                // }

                if(j+numbers[j]<i) { // 점프한 위치가 기준 위치에 도달하지 못한 경우는 이후 계산 과정 생략 
                    continue;
                }
                
                dp[i] = Math.max(dp[i], dp[j]+1); 

            }
        }

        int ans = 0;
        for(int i=1; i<n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}