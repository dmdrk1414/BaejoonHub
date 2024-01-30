from collections import deque

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def dfs(start):
    visited[start] = True
    print(start, end=" ")

    for value in graph[start]:
        if not visited[value]:
            dfs(value)


def bfs(start):
    que = deque([start])
    visited[start] = True

    while que:
        value = que.popleft()
        print(value, end=" ")

        for i in graph[value]:
            if not visited[i]:
                visited[i] = True
                que.append(i)


# 정렬
for i in graph:
    i.sort()

visited = [False] * (N + 1)
dfs(V)

print()

visited = [False] * (N + 1)
bfs(V)
