import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        graph = new ArrayList[N+1];

        for(int n=1; n<=N; n++) {
            graph[n] = new ArrayList<Integer>();
        }

        for(int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        visited[1] = true;
        dfs(1);   
        System.out.println(ans);
    }

    static void dfs(int v) {
        for(int n=0; n<graph[v].size(); n++) {
            int cur = graph[v].get(n);
            if(!visited[cur]) {
                ans++;
                visited[cur] = true;
                dfs(cur);
            }
        }
    }
}