import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static int[][] board = new int[9][9];
    
    public static void main(String[] args) {
        input();
        solve(0, 0);
    }

    static void input() {
        for (int i = 0; i < 9; i++) {
            String[] input = scan.nextLine().split("");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    static boolean solve(int row, int col) {
        if (col == 9) {
            return solve(row + 1, 0);
        }
        if (row == 9) {
            printBoard();
            return true;
        }
        if (board[row][col] != 0) {
            return solve(row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (solve(row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
