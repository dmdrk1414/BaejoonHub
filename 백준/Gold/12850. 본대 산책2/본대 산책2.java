import java.io.*;
import java.util.*;

public class Main {
    static long[][] v = {
            { 0, 1, 0, 1, 0, 0, 0, 0 },
            { 1, 0, 1, 1, 0, 0, 0, 0 },
            { 0, 1, 0, 1, 1, 1, 0, 0 },
            { 1, 1, 1, 0, 0, 1, 0, 0 },
            { 0, 0, 1, 0, 0, 1, 1, 0 },
            { 0, 0, 1, 1, 1, 0, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 1 },
            { 0, 0, 0, 0, 0, 1, 1, 0 }
    };

    final static long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());

        long[][] ans = doPow(D);

        System.out.println(ans[0][0]);
    }

    private static long[][] doPow(int n) {
        if (n == 1) {
            return v;
        }

        long[][] tmp = doPow(n / 2);
        tmp = multyply(tmp, tmp);
        if (n % 2 == 1) {
            tmp = multyply(tmp, v);
        }

        return tmp;
    }

    private static long[][] multyply(long[][] a, long[][] b) {
        long[][] tmp = new long[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    tmp[i][j] = (tmp[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return tmp;
    }

}