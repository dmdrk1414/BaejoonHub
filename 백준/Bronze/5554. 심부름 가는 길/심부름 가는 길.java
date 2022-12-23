import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int one = Integer.parseInt(br.readLine());
        int two = Integer.parseInt(br.readLine());
        int tree = Integer.parseInt(br.readLine());
        int fouer = Integer.parseInt(br.readLine());

        int sum = one + two + tree + fouer;

        int hour = sum / 60;
        int minite = sum - hour * 60;
        System.out.println(hour);
        System.out.println(minite);
    }
}