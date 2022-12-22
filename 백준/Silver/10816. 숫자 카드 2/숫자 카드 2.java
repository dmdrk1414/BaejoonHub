import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 리스트
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        String[] arr = br.readLine().split(" ");
        for (String str : arr) {
            list.add(Integer.valueOf(str));
        }

        // 두번째 리스트
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> list_2 = new ArrayList<>();

        arr = br.readLine().split(" ");
        for (String str : arr) {
            list_2.add(Integer.valueOf(str));
        }

        TreeMap<Integer, Integer> serchMap = new TreeMap<>();
        for (Integer num : list) {
            if (serchMap.containsKey(num)) {
                int value = serchMap.get(num);
                serchMap.put(num, value + 1);
            } else {
                serchMap.put(num, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : list_2) {
            if (serchMap.containsKey(num)) {
                int value = serchMap.get(num);
                sb.append(value + " ");
            } else {
                sb.append("0" + " ");
            }
        }
        System.out.println(sb);
    }
}