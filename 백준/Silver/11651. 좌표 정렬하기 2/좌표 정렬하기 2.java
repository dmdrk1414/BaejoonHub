import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            int left = Integer.parseInt(arr[0]);
            int right = Integer.parseInt(arr[1]);
            list.add(new int[]{left, right});
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for (int[] ints : list) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}