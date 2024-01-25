# https://www.acmicpc.net/problem/16948

"""
게임을 좋아하는 큐브러버는 체스에서 사용할 새로운 말 "데스 나이트"를 만들었다.

데스 나이트가 있는 곳이 (r, c)라면,

(r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)로 이동할 수 있다.

크기가 N×N인 체스판과 두 칸 (r1, c1), (r2, c2)가 주어진다.

데스 나이트가 (r1, c1)에서 (r2, c2)로 이동하는 최소 이동 횟수를 구해보자. 체스판의 행과 열은 0번부터 시작한다.

데스 나이트는 체스판 밖으로 벗어날 수 없다.

7
6 6 0 1

(r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
-2,  -2,  0,   0,   +2,   +2,
-1 , +1 , -2 , +2 ,  -1 , +1
"""
import sys
from collections import deque

input = sys.stdin.readline
dx = [-2, -2, 0, 0, 2, 2]
dy = [-1, 1, -2, 2, -1, 1]

N = int(input())
r1, c1, r2, c2 = map(int, input().split())
graph = [[-1] * (N) for _ in range(N)]

que = deque([(r1, c1)])
graph[c1][r1] = 0
while que:
    xx, yy = que.popleft()

    for i in range(len(dx)):
        ny = yy + dy[i]
        nx = xx + dx[i]

        if 0 <= ny < N and 0 <= nx < N:
            if graph[ny][nx] == -1:
                graph[ny][nx] = graph[yy][xx] + 1
                que.append([nx, ny])
# for li in graph:
#     print(li)
print(graph[c2][r2])
