import java.util.*;
import java.io.*;

/*
n자리 중복 순열을 구하기
아름다운 수 인지 체크하는 함수를 만들어 다 만든 수가 아름다운 수 조건을 충족할 경우 ans++
*/

public class Main {
    static int ans, n;
    static int[] numbers;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        recur(0);
        System.out.println(ans);
    }

    static void recur(int cnt) {
        if(cnt==n) {
            if(check()) {
                // System.out.println(Arrays.toString(numbers));
                ans++;
            }
            return;
        }

        for(int i = 1; i <= 4; i++) {
            numbers[cnt] = i;
            recur(cnt+1);
        }
    }

    static boolean check() {
        for(int i = 0; i < n; i += numbers[i]) {
            if(i + numbers[i] - 1 >= n) { // 배열의 범위를 벗어나면 
                return false;
            }

            // 연속하여 해당 숫자만큼 같은 숫자가 있는지 확인
            for(int j = i; j < i + numbers[i]; j++) {
                if(numbers[j] != numbers[i]) { // 하나라도 다른 숫자가 있다면 아름다운 수가 아님
                    return false;
                }
            }
        }
        return true;
    }
}