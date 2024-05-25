import java.io.*;
import java.util.*;

public class Main {
  static FastReader scan = new FastReader();
  static int K, N, M;
  static int[][] graph;
  static boolean[][][] visited;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};
  static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
  static int[] hy = {1, -1, 2, -2, 2, -2, 1, -1};

  /*
1
4 4
0 0 0 0
1 0 0 0
0 0 1 0
0 1 0 0

   */
  static void input() {
    K = scan.nextInt();
    M = scan.nextInt();
    N = scan.nextInt();

    visited = new boolean[N][M][K + 1];
    graph = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        graph[i][j] = scan.nextInt();
      }
    }
  }


  private static int bfs(final int x, final int y) {
    Queue<State> q = new LinkedList<>();
    q.add(new State(x, y, K, 0));
    visited[x][y][K] = true;

    while (!q.isEmpty()) {
      State cur = q.poll();
      if (cur.x == N - 1 && cur.y == M - 1) return cur.step;

      // 일반 이동
      for (int i = 0; i < dx.length; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (isValid(nx, ny, cur.k)) {
          q.add(new State(nx, ny, cur.k, cur.step + 1));
          visited[nx][ny][cur.k] = true;
        }
      }

      // 말 이동
      if (cur.k > 0) {
        for (int i = 0; i < hx.length; i++) {
          int nx = cur.x + hx[i];
          int ny = cur.y + hy[i];
          if (isValid(nx, ny, cur.k - 1)) {
            q.add(new State(nx, ny, cur.k - 1, cur.step + 1));
            visited[nx][ny][cur.k - 1] = true;
          }
        }
      }
    }
    return -1;
  }

  static boolean isValid(int x, int y, int k) {
    return x >= 0 && x < N && y >= 0 && y < M && graph[x][y] == 0 && !visited[x][y][k];
  }

  static void pro() {
    System.out.println(bfs(0, 0));
  }

  public static void main(String[] args) {
    input();
    pro();
  }

  static void print(int[][] graph) {
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        System.out.print(graph[i][j] + " ");
      }
      System.out.println();
    }
  }

  static class State {
    int x, y, k, step;

    public State(int x, int y, int k, int step) {
      this.x = x;
      this.y = y;
      this.k = k;
      this.step = step;
    }
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
