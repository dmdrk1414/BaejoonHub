import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    static int N, M;
    static String[] first_list;
    static String[] second_list;
    static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        first_list = br.readLine().split(" ");
        M = Integer.parseInt(br.readLine());
        second_list = br.readLine().split(" ");

        Arrays.sort(first_list);

        for (String s : first_list) {
            treeSet.add(Integer.valueOf(s));
        }

        for (String s : second_list) {
            if (treeSet.contains(Integer.valueOf(s))) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
        br.close();
    }
}