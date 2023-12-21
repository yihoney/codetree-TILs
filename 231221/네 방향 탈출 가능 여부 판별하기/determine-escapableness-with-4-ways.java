import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        bfs();

        System.out.println(visited[n-1][m-1]? 1:0);
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d=0; d<dirs.length; d++) {
                int nx = cur[0]+dirs[d][0];
                int ny = cur[1]+dirs[d][1];

                if(canGo(nx,ny)) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

        }
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x,y)) {
            return false;
        }

        if(visited[x][y] || map[x][y]==0) {
            return false;
        }

        return true;
    }

    static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}