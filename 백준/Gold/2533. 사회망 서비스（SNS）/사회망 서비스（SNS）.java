import java.io.*;
import java.util.*;

/**
 8
 1 2
 1 3
 1 4
 2 5
 2 6
 4 7
 4 8

 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[][] dp;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];

        adj = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }
    }

    private static void pro() throws IOException {
//        int e = 0;
//        for (List<Integer> integers : adj) {
//            System.out.println(e++ + ": " + integers);
//        }

//        System.out.println();
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }
//        Out.print("확인", dp);
        visited[1] = true;
        recur(1);
//        Out.print("확인", dp);

        System.out.println(Math.min(dp[1][1], dp[1][0]));
    }

    static void recur(int value) {
        // leaf node

        for (Integer child : adj[value]) {
            if (!visited[child]) {
//                System.out.println(value + " " + child);
                visited[child] = true;
                recur(child);
                dp[value][0] += dp[child][1];
                dp[value][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();

        bw.flush();
        bw.close();
        br.close();
    }
}