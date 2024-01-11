import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int sizeOfFriends = friends.length;
        Map<String, Integer> nameDic = new HashMap<>();
        int[] giftState = new int[sizeOfFriends];
        int[][] giveAndTakeGraph = new int[sizeOfFriends][sizeOfFriends];

        // nameDic 설정
        for (int i = 0; i < sizeOfFriends; i++) {
            String friend = friends[i];
            nameDic.put(friend, i);
        }

        // giftState 설정
        for (String gift : gifts) {
            String[] giftSplit = gift.split(" ");
            String give = giftSplit[0];
            String take = giftSplit[1];

            Integer giveFriendIndex = nameDic.get(give);
            Integer takeFriendIndex = nameDic.get(take);
            giftState[giveFriendIndex]++;
            giftState[takeFriendIndex]--;
            giveAndTakeGraph[giveFriendIndex][takeFriendIndex]++;
        }

        for (int giveIndex = 0; giveIndex < sizeOfFriends; giveIndex++) {
            int num = 0;
            for (int takeIndex = 0; takeIndex < sizeOfFriends; takeIndex++) {

                if (giveIndex == takeIndex) {
                    continue;
                }

                if (giveAndTakeGraph[giveIndex][takeIndex] > giveAndTakeGraph[takeIndex][giveIndex]) {
                    num++;
                }

                if (giveAndTakeGraph[giveIndex][takeIndex] == giveAndTakeGraph[takeIndex][giveIndex] &&
                        giftState[giveIndex] > giftState[takeIndex]
                ) {
                    num++;
                }

                if (answer < num) {
                    answer = num;
                }
            }
        }

        return answer;
    }
}