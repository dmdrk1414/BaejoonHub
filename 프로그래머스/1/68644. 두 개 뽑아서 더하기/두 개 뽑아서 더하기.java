import java.util.*;

class Solution {
    static TreeSet<Integer> set = new TreeSet<>();
    
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        
        int[] answer = {};
        for(int i = 0; i < N ; i++){
            for(int j = 0; j < N ; j++){
                if(i == j ) continue;
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] result = new int[set.size()];
        for(int i = 0; i < result.length ; i++){
            result[i] = set.pollFirst();
        }
        
        return result;
    }
}