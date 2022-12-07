import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            pq.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long ans = 0;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                ans += a + b;
                pq.add(a + b);
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}