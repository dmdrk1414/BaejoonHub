# https://www.acmicpc.net/problem/14940
"""
지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.

문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.

지도의 크기 n과 m이 주어진다.
n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)

다음 n개의 줄에 m개의 숫자가 주어진다.
0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다.
입력에서 2는 단 한개이다.

각 지점에서 목표지점까지의 거리를 출력한다.
원래 갈 수 없는 땅인 위치는 0을 출력하고,
원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.

15 15
2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1


"""
import sys
from collections import deque


def bfs(target):
    visited[target[0]][target[1]] = 0
    que = deque([target])
    while que:
        yy, xx = que.popleft()

        for i in range(4):
            ny = yy + dy[i]
            nx = xx + dx[i]
            if 0 > ny or ny >= n or 0 > nx or nx >= m:
                continue
            if 0 <= ny < n and 0 <= nx < m and visited[ny][nx] == -1:
                if graph[ny][nx] == 0:
                    visited[ny][nx] = 0
                elif graph[ny][nx] == 1:
                    visited[ny][nx] = visited[yy][xx] + 1
                    que.append([ny, nx])


input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[-1] * (m) for _ in range(n)]
dy = [0, 0, -1, 1]
dx = [-1, 1, 0, 0]

for y in range(n):
    for x in range(m):
        if graph[y][x] == 2 and visited[y][x] == -1:
            bfs([y, x])
            break

for i in range(n):
    for k in range(m):
        if graph[i][k] == 0:
            print(0, end=" ")
        else:
            print(visited[i][k], end=" ")

    print()
