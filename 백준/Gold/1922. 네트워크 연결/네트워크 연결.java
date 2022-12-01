import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]>[] graph;
    static int N, M;

    public static int prim() {
        int sum = 0;

        // 방문을 알려주는 함수.
        // false 배열 초기화
        boolean[] visit = new boolean[N + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });


        // 1에서의 간선은 0으로 넣는다.
        // 첫번째 노드의 간선을 0으로 하고 queue에 넣는다.
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            // 방문 하였는지 확인
            // 노드 방문을 한거면 다음 노드 탐색
            if (visit[curr[0]]) continue;

            visit[curr[0]] = true;
            sum += curr[1];

            // graph의 노드들의 연결 수만큼 for문
            // curr[ 노드 이름 , 노드 간선 weight ]
            for (int i = 0; i < graph[curr[0]].size(); i++) {
                // 현제 탐구하는 노드의 . 연결된 노드 의 배열
                // 현재노드 -> [연결된 노드, weight]
                int[] next = graph[curr[0]].get(i);

                // 반문을 했으면 true
                if (visit[next[0]]) continue;

                // 방문을 안했으면 add한다.
                pq.add(next);
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];

        // 그래프 초기화
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<int[]>();

        // M개의 간선을 넣는다.
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            // 무향 그래프의 푸쉬 방법.
            // from의 간선 add
            // to의 간선 add
            graph[from].add(new int[]{to, value});
            graph[to].add(new int[]{from, value});
        }

        System.out.println(prim());
    }
}