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
# safe_zone의 길이 -3 (벽을 3개 세우니까) 을 하고
# ch_virus를 만든다(여기서 고생)
# virus 위치를 건들지 않고 각각 다른 ch_board를 탐색하려면 virus 위치도 처음에 있는 위치로 고정해두어야 한다
# 나머지는 상하좌우를 탐색하고 ch_board가 비어있을 경우 append하며 끝까지 탐색하면 된다
def BFS():
    global res
    cnt = len(safe_zone)-3 # safe_zone의 길이 -3 (벽을 3개 세우니까) 을 하고
    ch_virus = deque([]) # ch_virus를 만든다(여기서 고생)
    for x,y in virus:
        ch_virus.append((x,y)) # virus 위치를 건들지 않고 각각 다른 ch_board를 탐색하려면 virus 위치도 처음에 있는 위치로 고정해두어야 한다
    while ch_virus:
        xx,yy = ch_virus.popleft()
        for i in range(4):
            nx = xx + dx[i] # 좌, 우 탐색
            ny = yy + dy[i] # 상, 하 탐색
            if 0<=nx<N and 0<=ny<M and ch_board[nx][ny] == 0:
                ch_board[nx][ny] = 2 # 감염이 되었으니 2로 만들어 준다.
                ch_virus.append((nx,ny))
                cnt-=1 # 바이러스가 감염되었으니 sefe_zone이 줄어든다.
    res = max(res,cnt)

# 준비 1
safe_zone = []
virus = []
res = 0
dx = [-1,1,0,0]
dy = [0,0,-1,1]

#  준비 2
# 준비는 safe_zone과 virus존의 그래프를 만들어라
for i in range(N):
    for j in range(M):
        if board[i][j] == 0:
            safe_zone.append([i,j])
        elif board[i][j] == 2:
            virus.append([i,j])

#  조합
for comb in combinations(safe_zone,3): # safe_zone 중에 3개을 조합으로 뽑는다.
    ch_board = copy.deepcopy(board)
    for x,y in comb:
        ch_board[x][y] = 1
    BFS()
print(res)