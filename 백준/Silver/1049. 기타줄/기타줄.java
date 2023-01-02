import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// 개수 N과 브랜드 M개가 주어지고,
// 6개가 패키지의 가격, 낱개 가격이 주어질 때
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            arr = br.readLine().split(" ");
            list.add(new int[] {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])});
        }

        int allPackMoney = 0;
        int packCnt = 0;
        int cnt = 0;

        if(N >= 6){
            packCnt = N / 6;
        }
        // 낱개
        cnt = N % 6;

        int MIN_pack = 9999999;
        int MIN_count = 9999999;

        for (int[] ints : list) {
            if(MIN_pack > ints[0] ){
                MIN_pack = ints[0];
            }

            if (MIN_count > ints[1]){
                MIN_count = ints[1];
            }
        }

        allPackMoney = (packCnt + 1) * MIN_pack;
        int result_pack = MIN_pack * packCnt;
        int result_count = MIN_count * cnt;
        int result_sum = result_pack+ result_count;

        int third_sum = N * MIN_count;

        int[] resultArr = new int[]{third_sum, allPackMoney, result_sum};
        Arrays.sort(resultArr);
        System.out.println(resultArr[0]);
//        for (int[] ints : list) {
//            System.out.println(Arrays.toString(ints));
//        }
    }
}