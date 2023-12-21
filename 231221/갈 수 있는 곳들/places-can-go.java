import java.util.*;
import java.io.*;

public class Main {
    static int n, k, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    static Queue<int[]> q = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            visited[r][c] = true;
            q.offer(new int[]{r,c});
        }

        bfs();

        System.out.println(ans);
    }

    static void bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            ans++;

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

        if(visited[x][y] || map[x][y]==1) {
            return false;
        }

        return true;
    }

    static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}