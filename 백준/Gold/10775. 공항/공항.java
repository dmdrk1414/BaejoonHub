import java.io.*;
import java.util.*;

/**
 4
 6
 2
 2
 3
 3
 4
 4

 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, result;
    static int[] par, air;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        par = new int[N + 1];
        for (int i = 0; i <= N; i++) par[i] = i;

        air = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            air[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        for (int i = 1; i <= M; i++) {
            int gate = air[i];

            int root_gate = find(gate);

            if(root_gate == 0) break;

            union(root_gate, root_gate - 1);
            result++;
//            Out.print(i + ": 번째, arr: " + air[i], par);
        }

        bw.write(result + "");
    }


    private static void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if(root_a == root_b) return;

        if (root_a > root_b) {
            par[root_a] = root_b;
        } else {
            par[root_b] = root_a;
        }
    }

    private static int find(int value){
        if (par[value] == value) return value;

        return par[value] = find(par[value]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();

        bw.flush();
        bw.close();
        br.close();
    }
}