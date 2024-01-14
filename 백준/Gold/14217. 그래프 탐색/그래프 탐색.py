import sys
from collections import deque

# https://www.acmicpc.net/problem/14217

input = sys.stdin.readline

n, m = map(int, input().split())
INF = 9999
L = [[0] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    L[a][b] = 1
    L[b][a] = 1

q = int(input())

# print("   0, 1, 2, 3, 4, 5 ")
# for idx,  l in enumerate(L):
#     print(idx, end=" ")
#     print(l)

def bfs(start):
    que = deque([start])
    visited = [False] * (n + 1)
    distance = [INF for _ in range (n + 1)]
    visited[start[0]] = True
    distance[start[0]] = start[1]

    while que:
        value, path = que.popleft()
        if distance[value] > path:
            distance[value] = path

        for idx in range(len(L[value])):
            if L[value][idx] == 1 and not visited[idx]:
                que.append([idx, distance[value] + 1])
                # que.append([idx, path + 1])
                visited[idx] = True
    return distance


for _ in range(q):
    a, i, j = map(int, input().split())
    if (a == 1):
        L[i][j] = 1
        L[j][i] = 1
    else:
        L[i][j] = 0
        L[j][i] = 0
    distance = bfs([1, 0])

    for i in range(1, n+1):
        if distance[i] == INF:
            print(-1, end=" ")
        else:
            print(distance[i], end=" ")
    print()
"""
5 6
1 2
1 3
2 4
2 5
3 5
4 5
5
2 1 2
1 1 4
2 2 4
2 2 5
1 1 2


"""
