import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str_1 = new StringBuilder(br.readLine());
        StringBuilder str_2 = new StringBuilder(br.readLine());


        int firstIndex = str_1.length() + 1;
        int secondIndex = str_2.length() + 1;
        d = new int[firstIndex][secondIndex];

        for (int first = 1; first < firstIndex; first++) {
            for (int second = 1; second < secondIndex; second++) {
                char char_first = str_1.charAt(first - 1);
                char char_second = str_2.charAt(second - 1);

                if (Character.compare(char_first, char_second) == 0) {
                    d[first][second] = d[first - 1][second - 1] + 1;
                } else {
                    d[first][second] = Math.max(d[first - 1][second], d[first][second - 1]);
                }
            }
        }
        System.out.println(d[firstIndex - 1][secondIndex - 1]);
    }

    public static void prinfList() {
        for (int[] ints : d) {
            System.out.println(Arrays.toString(ints));
        }
    }
}