import java.io.*;
import java.util.*;

/**
 3
 2 B A
 4 A B C D
 2 A C

 A={
    B={
        {C={
            {D={ {} }} }
        }
    },
    C={ {} }}
 },

 B={ {A={ {} }} }
 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static Node root;
    static StringBuilder sb;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        root = new Node();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node curr = root;

            for (int j = 0; j < K; j++) {
                String info = st.nextToken();

                if (curr.child.containsKey(info)) {
                    curr = curr.child.get(info);
                }else{
                    curr.child.put(info, new Node());
                    curr = curr.child.get(info);
                }

            }
        }
    }

    private static void pro() throws IOException {
        root.print(sb, "");
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        Map<String, Node> child;
        public Node() {
            this.child = new HashMap<>();
        }

        @Override
        public String toString() {
            return "{ " + child + " }";
        }

        private void makeSb (StringBuilder sb, String dash) {
            List<String> list = new ArrayList<>(child.keySet());
            Collections.sort(list);

            for (String key : list) {
                sb.append(dash).append(key).append("\n");
                Node curr = child.get(key);
                curr.makeSb(sb, dash + "--");
            }
        }
        public void print(StringBuilder sb, String dash) {
            makeSb(sb, dash);

            System.out.println(sb.toString());
        }
    }
}
/**
 A={
     B={
         {C={
             {D={ {} }} }
         }
     },
     C={ {} }}
 },

 B={
    A={ {} }
 }
 */