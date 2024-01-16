# https://www.acmicpc.net/problem/16953


"""
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다.
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

2 162
2 → 4 → 8 → 81 → 162

5
"""
import sys
from collections import deque
input = sys.stdin.readline

A, B = map(int, input().split())
que = deque([(A, 1)])
while que:
    a, count = que.popleft()
    if a > B:
        continue
    if a == B:
        print(count)
        break
    que.append([int(str(a) + "1"), count+1])
    que.append([a * 2, count + 1])
else:
    print(-1)
