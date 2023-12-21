import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dirs = new int [][]{ {0,1}, {1,0}}; // 우, 하 두방향으로만 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        graph = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        dfs(0, 0);   

        System.out.println(visited[n-1][m-1]?1:0);
    }

    static void dfs(int x, int y) {
        if(x==n-1 && y==m-1) {
            return;
        }

        for(int d=0; d<dirs.length; d++) {
            int nx = x+dirs[d][0];
            int ny = y+dirs[d][1];

            if(canGo(nx, ny)) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) { // 그래프 범위를 벗어난다면 
            return false;
        }

        if(visited[x][y] || graph[x][y]==0) { // 이미 방문했거나 뱀이 있다면
            return false;
        }

        return true;
    }

    static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}