import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int sum = 0;
		int min = 10000;
		
		int square[] = new int[101];
		for(int i = 1;i<=100;i++) {
			square[i] = i * i;
			if(square[i] >= m && square[i] <= n) {
				sum += square[i];
				if(square[i] < min) {
					min = square[i];
				}
				
			}
			
			
		}
		if(sum == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(min);
		}
		
		

	}

}