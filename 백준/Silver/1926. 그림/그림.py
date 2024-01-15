# https://www.acmicpc.net/problem/1926
"""
어떤 큰 도화지에 그림이 그려져 있을 때,
그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라.
단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자.
가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다.
그림의 넓이란 그림에 포함된 1의 개수이다.

첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다.
두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다.
(단 그림의 정보는 0과 1이 공백을 두고 주어지며,
0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)

첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라.
단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.

6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1


4
9
"""
import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
graph = [ list(map(int, input().split())) for _ in range(N) ]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(start):
    que = deque([start])
    graph[start[0]][start[1]] = 0
    count = 1

    while que:
        yValue, xValue = que.popleft()
        for i in range(len(dy)):
            yPath = yValue + dy[i]
            xPath = xValue + dx[i]

            if yPath < 0 or yPath >= N or xPath < 0 or xPath >= M:
                continue

            if graph[yPath][xPath] == 1:
                graph[yPath][xPath] = 0
                que.append([yPath, xPath])
                count += 1
    return count

paint = []
for yidx in range(N):
    for xidx in range(M):
        if graph[yidx][xidx] == 1:
            paint.append(bfs([yidx, xidx]))
if len(paint) == 0:
    print(len(paint))
    print(0)
else:
    print(len(paint))
    print(max(paint))