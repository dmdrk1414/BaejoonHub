import sys
from collections import deque

input = sys.stdin.readline
INF = 9999;

# 첫째 줄에는 도시의 개수 n,도로의 개수 m이 주어진다.
n, m = map(int, input().split())
L = [[0] * (n + 1) for _ in range(n + 1)]

# 다음 m개의 줄에는 두 도시가 주어진다.(2≤n≤500,1≤m≤n*(n-1)/2)
for _ in range (m):
    a, b = map(int, input().split())
    L[a][b] = 1
    L[b][a] = 1

q = int(input())

def bfs(start):
    que = deque([start])
    visited = [False for _ in range(n + 1)]
    distance = [INF for _ in range(n + 1)]
    visited[start[0]] = True
    distance[start[0]] = start[1]

    while que:
        value, path = que.popleft()
        if(distance[value] > path):
            distance[value] = path
        for idx in range(len(L[value])):
            if not visited[idx] and L[value][idx] == 1:
                que.append([idx, distance[value] + 1])
                visited[idx] = True
    return distance
for _ in range(q):
    check, a, b = map(int, input().split())
    if check == 1:
        L[a][b] = 1
        L[b][a] = 1
    else :
        L[a][b] = 0
        L[b][a] = 0

    distance = bfs([1, 0])

    for inx in range (1, n + 1):
        if distance[inx] == INF:
            print("-1", end=" ")
        else:
            print(distance[inx], end=" ")
    print()