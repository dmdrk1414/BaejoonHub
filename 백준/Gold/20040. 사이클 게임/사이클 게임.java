import java.io.*;
import java.util.*;

public class Main {
  /*
6 5
0 1
1 2
1 3
0 3
4 5

답 : 4

6 5
0 1
1 2
2 3
5 4
0 4

답 : 0
   */
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();
  static int N, M, ans;
  static int[] par;

  static int[][] inputs;

  static void input() {
    N = scan.nextInt();
    M = scan.nextInt();
    inputs = new int[M][2];
    par = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      par[i] = i;
    }

    for (int i = 0; i < M; i++) {
      inputs[i] = new int[]{scan.nextInt(), scan.nextInt()};
    }

//    for (int[] input : inputs) {
//      System.out.println(Arrays.toString(input));
//    }
  }

  static void pro() {
    for (int[] input : inputs) {
      int a = input[0];
      int b = input[1];

      int a_root = find(a);
      int b_root = find(b);

      if (a_root == b_root) {
        System.out.println(++ans);
        System.exit(0);
      } else {
        ans++;
        union(a_root, b_root);
      }
    }

    System.out.println(0);
  }

  public static void main(String[] args) {
    input();
    pro();
  }

  static int find(int root) {
    if (par[root] == root) return par[root];

    return par[root] = find(par[root]);
  }

  static void union(int a, int b) {
    int a_root = find(a);
    int b_root = find(b);

    if (a_root != b_root) {
      if (a_root < b_root)
        par[b_root] = a_root;
      else
        par[a_root] = b_root;
    }
  }

  static void print(int[] par) {
    System.out.println(Arrays.toString(par));
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