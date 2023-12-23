import java.util.*;
import java.io.*;
/*
[BFS 문제]
<< 이동을 k번 반복한 후의 위치 구하기 >>

- 인접한 네 방향 중 시작 위치의 숫자보다 작은 곳으로만 이동 가능
* 이동 우선 순위
    1. 이동할 수 있는 곳들 중 최댓값이 적혀있는 곳
    2. 1번 조건을 만족하는 곳이 여러 곳 있다면, 행 번호가 가장 작은 곳
    3. 2번 조건을 만족하는 곳이 여러 곳 있다면, 열 번호가 가장 작은 곳
- 이동할 곳이 없다면 프로그램 종료
*/

class Point {
    int num;
    int x;
    int y;

    Point(int num, int x, int y) {
        this.num = num;
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static int n, k, base, ans[], cur[], map[][];
    static boolean isMoved, visited[][];

    static int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    static final int NOT_EXISTS = -1;

    static Queue<int[]> q = new ArrayDeque<>();
    static List<Point> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 격자의 크기
        k = Integer.parseInt(st.nextToken()); // 반복할 횟수

        map = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        // 출발 초기 위치 설정
        cur = new int[]{r,c};

        while(k-- > 0) {
            
            // 1. 갈 수 있는 모든 위치 탐색
            bfs();

            // 2. 우선순위가 높은 위치 구하기
            setMovePos();

            // 3. 위치 이동

            // 만약 움직일 위치가 없다면 반복문 탈출
            if(ans[0] == NOT_EXISTS && ans[1] == NOT_EXISTS) {
                break;
            } else { // 움직일 위치가 있다면 이동
                cur = new int[]{ans[0], ans[1]};
            }
        }

        System.out.println(ans[0]+" "+ans[1]);
    }

    static void bfs() {
        nums = new ArrayList<>();
        visited = new boolean[n+1][n+1]; // 방문 배열 초기화

        base = map[cur[0]][cur[1]]; // 기준값 설정
        visited[cur[0]][cur[1]] = true; // 방문 플래그 설정
        q.offer(new int[]{cur[0], cur[1]}); // 시작 위치

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int d=0; d<dirs.length; d++) {
                int nx = cx+dirs[d][0];
                int ny = cy+dirs[d][1];

                if(canGo(base, nx, ny)) {
                    visited[nx][ny] = true;
                    nums.add(new Point(map[nx][ny], nx, ny));
                    q.offer(new int[]{nx, ny});

                }
            }

        }
    }

    static void setMovePos() {
        ans = new int[]{NOT_EXISTS, NOT_EXISTS}; // 최종적으로 움직인 위치 저장 배열

        for(int i=0; i<nums.size(); i++) {
            int nx = nums.get(i).x;
            int ny = nums.get(i).y;
            
            // 방문이 불가능하거나 현재 위치는 과정 생략
            if(!visited[nx][ny] || nx==cur[0] && ny==cur[1]) {
                    continue;
            }  
            
            if(neededToUpdate(nx, ny)) {
                ans = new int[]{nx, ny};
            }
        }
    }

    static boolean neededToUpdate(int nx, int ny) {
        int cx = ans[0];
        int cy = ans[1];

        // 첫 이동 가능 위치라면 이동할 위치 업데이트
        if(cx == NOT_EXISTS && cy == NOT_EXISTS) {
            return true;
        }

        if(map[cx][cy] != map[nx][ny]) { // 기존 값과 새로운 값이 같지 않다면
           // 기존 값보다 새로운 값이 더 크다면 업데이트
           return map[cx][cy] < map[nx][ny];    
        }

        if(cx != nx) { // 값이 같고 행이 같지 않다면
            // 기존행이 새로 갈 위치의 행보다 더 크다면 업데이트 
            return cx > nx;
        }

        // 값과 행이 같고 열이 같지 않다면
        // 기존열이 새로 갈 위치의 열보다 더 크다면 업데이트 
        return cy > ny;
    }

    static boolean canGo(int base, int nx, int ny) {
        // 이동할 위치가 map 이내에 있고, 아직 방문하지 않은 곳이고 기준값보다 작다면 이동 가능
        return inRange(nx,ny) && !visited[nx][ny] && map[nx][ny]<base;
    }

    static boolean inRange(int x, int y) {
        return x>0 && x<=n && y>0 && y<=n;
    }
}