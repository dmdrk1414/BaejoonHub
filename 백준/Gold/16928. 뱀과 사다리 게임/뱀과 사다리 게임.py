# https://www.acmicpc.net/problem/16928
"""
뱀과 사다리 게임을 즐겨 하는 큐브러버는 어느 날 궁금한 점이 생겼다.

주사위를 조작해 내가 원하는 수가 나오게 만들 수 있다면,

최소 몇 번만에 도착점에 도착할 수 있을까?

게임은 정육면체 주사위를 사용하며, 주사위의 각 면에는 1부터 6까지 수가 하나씩 적혀있다.

게임은 크기가 10×10이고, 총 100개의 칸으로 나누어져 있는 보드판에서 진행된다. 보드판에는 1부터 100까지 수가 하나씩 순서대로 적혀져 있다.

플레이어는 주사위를 굴려 나온 수만큼 이동해야 한다. 예를 들어,

플레이어가 i번 칸에 있고, 주사위를 굴려 나온 수가 4라면, i+4번 칸으로 이동해야 한다. 만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다.
도착한 칸이 사다리면, 사다리를 타고 위로 올라간다.
뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다.
즉, 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고, 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.

게임의 목표는 1번 칸에서 시작해서 100번 칸에 도착하는 것이다.

게임판의 상태가 주어졌을 때, 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값을 구해보자

"""
# 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고, 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.
# 사다리 이용 -> 기존의 칸의 번호보다 크고
# 뱀을 이용 -> 기존의 칸보다 작아진다.

"""
3 7
32 62
42 68
12 98
95 13
97 25
93 37
79 27
75 19
49 47
67 17


"""
from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

snack = dict()
ladder = dict()
for _ in range(N):
    i,j = map(int,input().split())
    ladder[i] = j
for _ in range(M):
    i,j = map(int,input().split())
    snack[i] = j

dices = [1, 2, 3, 4, 5, 6]
visited = [False for _ in range(100 + 1)]
result = 0
counts = [9999 for _ in range(100 + 1)]
def bfs():
    start = 1
    counts[start] = 0
    visited[start] = True
    que = deque([start])

    while que:
        stand = que.popleft()
        if(stand == 100):
            break
        for i in range(len(dices)):
            afterStand = stand + dices[i]
            if afterStand <= 100 and not visited[afterStand]:
                if afterStand in ladder.keys():
                    afterStand = ladder[afterStand]

                if afterStand in snack.keys():
                    afterStand = snack[afterStand]
                visited[afterStand] = True
                counts[afterStand] = min(counts[afterStand], counts[stand] + 1)
                que.append(afterStand)

bfs()
print(counts[100])