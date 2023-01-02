import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        ArrayList<Integer> list  = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.valueOf(arr[i]));
        }

        Collections.sort(list);

        int [] results = new int[N];
        results[0] = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            results[i] = results[i-1] + list.get(i);
        }
        int sum = 0;
        for (int result : results) {
            sum+=result;
        }
        System.out.println(sum);
    }
}