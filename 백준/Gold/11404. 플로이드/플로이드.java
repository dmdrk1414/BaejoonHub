import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int INF = 987654321;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;

    public static void main(String[] args) throws IOException {
//        String[] inputArr = br.readLine().split(" ");
//        int n = Integer.parseInt(inputArr[0]);
//        int m = Integer.parseInt(inputArr[1]);

        String[] inputArr;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // graph 초기화
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = INF;

                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int first = 1; first <= m; first++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            int c = Integer.parseInt(inputArr[2]);

            graph[a][b] = Math.min(graph[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}