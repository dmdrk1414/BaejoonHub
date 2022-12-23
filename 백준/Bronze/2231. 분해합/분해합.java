import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inStr = br.readLine();
        int N = Integer.parseInt(inStr);
        boolean is = false;
        int sdf = 0;
        for (int i = 1; i <= N; i++) {
            int sumIndivisual = getWant(i);
            int sum_i = sumIndivisual + i;
            if (N == sum_i) {
                sdf = i;
                is = true;
                break;
            } else {
                is = false;
            }
        }

        if (!is) {
            System.out.println(0);
        } else {
            System.out.println(sdf);
        }
    }

    private static int getWant(int i) {
        String str = i + "";
        String[] strArr = str.split("");
        int sumAt = 0;
        for (int j = 0; j < strArr.length; j++) {
            sumAt += Integer.parseInt(strArr[j]);
        }
        return sumAt;
    }
}
