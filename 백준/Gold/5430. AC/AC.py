# https://www.acmicpc.net/problem/5430
import sys

"""
선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. 
AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 
배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.

함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 
예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.

배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.


4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]


"""
import sys
from collections import deque

input = sys.stdin.readline
t = int(input().rstrip())

for i in range(t):
    method = input().rstrip()
    n = int(input())
    arr = deque(input().rstrip()[1:-1].split(","))

    if n == 0:
        arr = deque()
    error = False
    revers = 0

    for c in method:
        if c == 'R':
            revers += 1
        if c == 'D':
            if len(arr) < 1:
                print("error")
                error = True
                break
            else:
                if (revers % 2) != 0:
                    arr.pop()
                else:
                    arr.popleft()

    if not error:
        if revers % 2 != 0:
            arr.reverse()
            print("[" + ",".join(arr) + "]")
        else:
            print("[" + ",".join(arr) + "]")
