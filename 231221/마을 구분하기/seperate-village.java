import java.io.*;
import java.util.*;

public class Main {
    static int map[][], n, townN;
    static int dirs[][] = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    static boolean visited[][];
    static int[] ansArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n][n];
        ansArr = new int[n*n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(canGo(i, j)) {
                    townN++;
                    dfs(i,j);
                }
            }
        }

        System.out.println(townN); // 마을의 개수
        Arrays.sort(ansArr); // 오름차순 정렬
        for(int p: ansArr) {
            if(p!=0) {
                System.out.println(p); // 각 마을 내 사람의 수
            }
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        ansArr[townN]++;
        
        for(int d=0; d<dirs.length; d++) {
            int nx = x+dirs[d][0];
            int ny = y+dirs[d][1];

            if(canGo(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x,y)) { // 맵의 범위를 벗어난 경우
            return false;
        }

        if(map[x][y]==0 || visited[x][y]) { // 벽이거나 이미 방문한 곳일 경우 
            return false;
        }

        return true;
    }

    static boolean inRange(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}