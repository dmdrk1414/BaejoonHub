# https://www.acmicpc.net/problem/14217
import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
L = [[0] * (n + 1) for _ in range(n + 1)]
INF = 9999;
distance = [INF for _ in range(n + 1)]
distance[1] = 0

for _ in range(m):
    a, b = map(int, input().split())
    L[a][b] = 1
    L[b][a] = 1

q = int(input())

def bfs(start):
    visited = [False for _ in range(n+1)]
    que = deque([start])
    visited[start[0]] = True

    while que:
        value, path = que.popleft()
        if(distance[value] > path):
            distance[value] = path
        for idx in range(len(L[value])):
            if not visited[idx] and L[value][idx] == 1:
                visited[idx] = True
                que.append([idx, distance[value] + 1])

for _ in range(q):
    a, b = map(int, input().split())
    L[a][b] = 1;
    L[b][a] = 1;

    bfs([1, 0])

    for idx in range(1, n+1):
        if (distance[idx] == INF):
            print(-1, end=" ")
        else:
            print(distance[idx], end=" ")
    print()

"""
5 3
1 2
1 3
2 4
5
2 3
4 5
3 4
1 4
1 5


"""
