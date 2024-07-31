import java.io.*;
import java.util.*;

/**
 5
 4
 1 3 1 2
 3
 1 3 2

 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N, M;
    static long[] a_sum, b_sum;
    static int[] a_arr, b_arr;
    static long result;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        result = 0;
        a_arr = new int[N];
        a_sum = new long[N * (N + 1) / 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a_arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        b_arr = new int[M];
        b_sum = new long[M * (M + 1) / 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b_arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void pro() throws IOException {
        make_sum(a_sum, N, a_arr);
        make_sum(b_sum, M, b_arr);

        int L = 0, R = b_sum.length - 1;

        while (L < a_sum.length && R >= 0) {
            long sum = a_sum[L] + b_sum[R];

            if (sum == T) {
                long a_cnt = 0;
                long b_cnt = 0;
                long a = a_sum[L];
                long b = b_sum[R];

                while(L < a_sum.length && a_sum[L] == a) {
                    a_cnt++;
                    L++;
                }

                while(R >= 0 && b_sum[R] == b) {
                    b_cnt++;
                    R--;
                }

                result += a_cnt * b_cnt;

            } else if (sum < T) {
                L++;
            } else if (sum > T) {
                R--;
            }
        }

        // 0도 가능
        bw.write(result + "");
    }

    private static void make_sum( long[] sum,  int n,  int[] arr) {
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int temp = 0;

            for (int j = i; j < n; j++) {
                temp += arr[j];
                sum[idx++] = temp;
            }
        }

        Arrays.sort(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();

        bw.flush();
        bw.close();
        br.close();
    }
}