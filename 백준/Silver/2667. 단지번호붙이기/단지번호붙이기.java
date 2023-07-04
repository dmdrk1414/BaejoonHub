import java.util.*;
import java.io.*;

public class Main {
    static int arr[][];
    static boolean visit[][];
    static int dirX[] = {0, 0, -1, 1}; // X축 방향: 왼쪽, 오른쪽, 위, 아래
    static int dirY[] = {-1, 1, 0, 0}; // Y축 방향: 위, 아래, 왼쪽, 오른쪽

    static int count = 0, number = 0;
    static int nowX, nowY, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();

            for(int j=0; j<N; j++) {               
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                if(visit[i][j] == false && arr[i][j] == 1) {
                    count = 0;
                    number++;
                    DFS(i, j);   
                    list.add(count);
                }

            }
        }

        Collections.sort(list);
        bw.append(number + "\n");
        for(int num : list) {
            bw.append(num + "\n");
        }

        bw.flush();
        bw.close();     
    } // main 메서드의 끝

    static void DFS(int x, int y) {
        visit[x][y] = true;
        arr[x][y] = number;
        count ++;

        for(int i=0; i<4; i++) {
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;

            if(Range_check() && visit[nowX][nowY] == false && arr[nowX][nowY] == 1) {
                visit[nowX][nowY] = true;
                arr[nowX][nowY] = number;

                DFS(nowX, nowY);
            }
        }       

    } // DFS 메서드의 끝

    static boolean Range_check() {
        return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
    } // Range_check 메서드의 끝
} // 클래스의 끝
