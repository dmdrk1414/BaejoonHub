import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> first_que = new LinkedList<>();
        Queue<Integer> second_que = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for (int i = 1; i <= input; i++) {
            first_que.add(i);
        }

        while (first_que.size() > 1) {
            first_que.remove();
            int temp = first_que.remove();
            first_que.add(temp);
        }


//        for (int i = 1; i <= input; i++) {
//            if (!first_que.isEmpty()) {
//                int remove = first_que.remove();
//                System.out.print("remove: " + remove + " || ");
//                if (first_que.size() == 1) {
//                    break;
//                }
//            }
//            if (!first_que.isEmpty()) {
//                int temp = first_que.remove();
//                first_que.add(temp);
//            }
//            System.out.println("first_que = " + first_que);
//        }
        System.out.println(first_que.peek());
    }
}