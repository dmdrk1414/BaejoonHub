import java.util.*;

class Solution {
  static StringBuilder sb = new StringBuilder();
  static Scanner sc = new Scanner(System.in);
  static int V, E, find_one, find_two;
  static int com_par;
  static int[] par;
  static boolean[] visited;
  static List<Integer>[] adj;
  static int[] dp;

  private static void input() {
    V = sc.nextInt();
    E = sc.nextInt();
    find_one = sc.nextInt();
    find_two = sc.nextInt();
    com_par = 0;
    dp = new int[V + 1];
    Arrays.fill(dp, 1);
    par = new int[V + 1];
    visited = new boolean[V + 1];
    visited[1] = true; // 조상은 무조건 true;
    adj = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 1; i <= E; i++) {
      int parVal = sc.nextInt();
      int child = sc.nextInt();

      adj[parVal].add(child);
      par[child] = parVal;
    }
  }

  private static void pro() {
    // 공통의 조상으 찾는다.
    find(find_one);
    com_par = find(find_two);

    // 서브 트리의 노드 갯수 세기
    dfs(1);
  }

  // 서브 트리의 노드 갯수 세기
  private static void dfs(final int pre_node) {
    if (adj[pre_node].size() == 0) {
      return;
    } else {
      for (Integer next_node : adj[pre_node]) {
        dfs(next_node);
        dp[pre_node] += dp[next_node];
      }
    }
  }

  // 공통 조상 찾기
  private static int find(final int node) {
    if (visited[node]) return node;
    if (node == 1) return 0;

    visited[node] = true;
    return find(par[node]);
  }

  public static void main(String args[]) throws Exception {
    int T;
    T = sc.nextInt();

    for (int test_case = 1; test_case <= T; test_case++) {
      input();
      pro();

      System.out.printf("#%d %d %d\n", test_case, com_par, dp[com_par]);
    }
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}