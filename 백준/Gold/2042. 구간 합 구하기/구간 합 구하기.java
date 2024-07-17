
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5

 */
public class Main {
    static long[] arr, tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 사이즈를 구하는 위의 과정이 귀찮으면, 단순히 N에 4를 곱한 사이즈를 사용해도 무방함.
        tree = new long[N * 4];

        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long dif = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, dif);
            } else if (a == 2) {
                sb.append(sum(b, (int) c, 1, 1, N))
                  .append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // start: 시작 인덱스, end: 끝 인덱스
    public static long init(int node, int nodeLeft, int nodeRight) {
        // 리프 노드 관리
        if (nodeLeft == nodeRight) {
            return tree[node] = arr[nodeLeft];
        }

        // 중간 값
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;

        // 재귀적으로 두 부분으로 나눈 뒤에 그 합을 자기 자신으로 함.
//        return tree[node] = init(nodeLeft, mid, node * 2) + init(mid + 1, nodeRight, node * 2 + 1);
        return tree[node] = init(node * 2, nodeLeft, mid) + init( node * 2 + 1, mid + 1, nodeRight);
    }

    /**
     *
     * @param left 원래 입력 배열에서의 범위
     * @param right 원래 입력 배열에서의 범위
     * @param node node에 부여한 번호
     * @param nodeLeft 해당 노드가 cover하는 입력 배열의 범위
     * @param nodeRight 해당 노드가 cover하는 입력 배열의 번위
     * @return
     */
    public static long sum(int left, int right, int node, int nodeLeft, int nodeRight) {
        // 범위 밖에 있는 경우
        // 구간 범위을 벗어나면 0(기본값을)리던
        if(right < nodeLeft || nodeRight < left){
            return 0;
        }

        // 범위 안에 있는 경우
        // 완전 포함되는 경우는 현재 값을 그냥 return(leaf 포함)
        if(left <= nodeLeft && nodeRight <= right){
            return tree[node];
        }

        // 그렇지 않다면, 두 부분으로 나누어 합을 구하기
        // Tree의 준간 node라면 구간을 2개로 나눠 recur 한 후
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        long leftVal = sum(left, right, node * 2, nodeLeft, mid);
        long rightVal = sum(left, right, node * 2 + 1, mid + 1, nodeRight);

        return leftVal + rightVal;
    }

    public static long updateRec(int index, int newValue, int node, int nodeLeft, int nodeRight) {
        if (index < nodeLeft || nodeRight < index) {
            return tree[node];
        }

        if (nodeLeft == nodeRight) {
            return tree[node] = newValue;
        }

        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        long leftVal = updateRec(index, newValue, node * 2, nodeLeft, mid);
        long rightVal = updateRec(index, newValue, node * 2 + 1, mid + 1, nodeRight);
        return tree[node] = leftVal + rightVal;
    }

    // start: 시작 인덱스, end: 끝 인덱스
    // idx: 구간 합을 수정하고자 하는 노드
    // dif: 수정할 값
    public static void update(int start, int end, int node, int idx, long dif) {
        // 범위 밖에 있는 경우
        if (idx < start || idx > end) {
            return;
        }

        // 범위 안에 있으면 내려가며 다른 원소도 갱신
        tree[node] += dif;
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }

}