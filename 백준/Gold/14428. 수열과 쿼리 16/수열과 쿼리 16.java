import java.io.*;
import java.util.*;

/*
5
5 4 3 2 1
6
2 1 3
2 1 4
1 5 3
2 3 5
1 4 3
2 3 5

 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int[] tree;
    static StringBuilder sb;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        arr = new int[N + 1];
        tree = new int[N * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = Integer.MAX_VALUE;

        init(1, 1, N);
    }

    private static int init(final int node, final int nodeLeft, final int nodeRight) {
        if(nodeLeft == nodeRight) {
            return tree[node] = nodeLeft;
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int left = init(node * 2, nodeLeft, mid);
        int right = init(node * 2 + 1, mid + 1, nodeRight);

        return tree[node] = getIndex(left, right);
    }

    private static void pro() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int query = Integer.parseInt(st.nextToken());

            if (query == 1) {
                int index = Integer.parseInt(st.nextToken());
                int update = Integer.parseInt(st.nextToken());
                arr[index] = update;
                updateRec(index, 1, 1, N);
            } else if (query == 2) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(getRec(a, b, 1, 1, N)).append("\n");
            }
        }

        bw.write(sb.toString());
    }

    private static int updateRec(final int index, final int node, final int nodeLeft, final int nodeRight) {
        if(index < nodeLeft || nodeRight < index){
            return tree[node];
        }

        if(nodeLeft == nodeRight) {
            return tree[node];
        }


        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = updateRec(index, node * 2, nodeLeft, mid);
        int rightVal = updateRec(index, node * 2 + 1, mid + 1, nodeRight);

        return tree[node] = getIndex(leftVal, rightVal);
    }

    private static int getRec(final int left, final int right, final int node, final int nodeLeft, final int nodeRight) {
        if(right < nodeLeft || nodeRight < left){
            return 0;
        }

        if(left <= nodeLeft && nodeRight <= right) {
            return tree[node];
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        int leftVal = getRec(left, right, node * 2, nodeLeft, mid);
        int rightVal = getRec(left, right, node * 2 + 1, mid + 1, nodeRight);

        return getIndex(leftVal, rightVal);
    }

    static int getIndex(int left, int right) {
        if(arr[left] == arr[right]) return Math.min(left, right);

        else if(arr[left] < arr[right]) return left;

        else return right;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();

        bw.flush();
        bw.close();
        br.close();
    }
}
