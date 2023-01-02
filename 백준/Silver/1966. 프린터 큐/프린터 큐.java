import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static LinkedList<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < numCase; i++) {
            String arr[] = br.readLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
            arr = br.readLine().split(" ");

            for (int j = 0; j < arr.length; j++) {
                queue.add(new int[]{j, Integer.parseInt(arr[j])});
            }
            int cnt = 0;

            // 케이스별 반복
            while (!queue.isEmpty()) {
                // 우선 순위 정렬
                boolean isMax = true;
                int[] first = queue.removeFirst();
                int firstPri = first[1];

                // 중요도 비교
                for (int j = 0; j < queue.size(); j++) {
                    if (firstPri < queue.get(j)[1]) {
                        queue.addLast(first);
                        isMax = false;
                        break;
                    }
                }

                if(!isMax) continue;

                int firstIndex = first[0];
                cnt++;
                if (M == firstIndex) {
                    break;
                }
            }
            queue.clear();
            System.out.println(cnt);
        }
    }
}