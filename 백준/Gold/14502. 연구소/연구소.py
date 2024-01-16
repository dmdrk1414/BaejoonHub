# https://www.acmicpc.net/problem/14502

"""
인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고,
바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.

연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다.
연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.

일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다.
새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.

2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

0은 빈 칸, 1은 벽, 2는 바이러스
"""

import sys
from collections import deque
from itertools import combinations
import copy

input = sys.stdin.readline
N,M = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(N)]



#  BFS
def BFS():
    global res
    cnt = len(safe_zone)-3
    ch_virus = deque([])
    for x,y in virus:
        ch_virus.append((x,y))
    while ch_virus:
        xx,yy = ch_virus.popleft()
        for i in range(4):
            nx = xx + dx[i]
            ny = yy + dy[i]
            if 0<=nx<N and 0<=ny<M and ch_board[nx][ny] == 0:
                ch_board[nx][ny] = 2
                ch_virus.append((nx,ny))
                cnt-=1
    res = max(res,cnt)

# 준비 1
safe_zone = []
virus = []
res = 0
dx = [-1,1,0,0]
dy = [0,0,-1,1]

#  준비 2
for i in range(N):
    for j in range(M):
        if board[i][j] == 0:
            safe_zone.append((i,j))
        elif board[i][j] == 2:
            virus.append((i,j))

#  조합
for comb in combinations(safe_zone,3):
    ch_board = copy.deepcopy(board)
    for x,y in comb:
        ch_board[x][y] = 1
    BFS()
print(res)