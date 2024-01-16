# https://www.acmicpc.net/problem/10026

"""
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다.
따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다.
그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다.
또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
(색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에
R R R B B
G G B B B
B B B R R
B B R R R
R R R R R

R R R B B
R R B B B
B B B R R
B B R R R
R R R R R
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다.
(빨강 2, 파랑 1, 초록 1) 하지만,
적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.


입력
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR


4 3
"""
import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

graph = [list(input().rstrip()) for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0,0, -1, 1]

visited = [[False] * (N) for _ in range(N)]
nomal = True
color = False

def bfs(start):
    visited[start[0]] [start[1]] = True
    que = deque([start])
    color = graph[start[0]][start[1]]
    while que:
        y_before, x_before = que.popleft()

        for i in range (len(dx)):
            y_value = y_before + dy[i]
            x_value = x_before + dx[i]

            if y_value < 0 or y_value >= N or x_value < 0 or x_value >= N:
                continue
            if not visited[y_value][x_value] and color == graph[y_value][x_value]:
                visited[y_value][x_value] = True
                que.append([y_value, x_value])

paint = []
count = 0;
for y_id in range (N):
    for x_id in range (N):
        if not visited[y_id][x_id]:
            bfs([y_id, x_id])
            count += 1

for y_id in range (N):
    for x_id in range (N):
        if graph[y_id][x_id] == "G":
            graph[y_id][x_id] = "R"

visited = [[False] * (N) for _ in range(N)]
count_not = 0;
for y_id in range (N):
    for x_id in range (N):
        if not visited[y_id][x_id]:
            bfs([y_id, x_id])
            count_not += 1
print(count)
print(count_not)

