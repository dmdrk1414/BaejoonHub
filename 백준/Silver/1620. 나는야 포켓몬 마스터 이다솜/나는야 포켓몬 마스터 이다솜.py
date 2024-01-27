# https://www.acmicpc.net/problem/1620

"""
26 5
Bulbasaur
Ivysaur
Venusaur
Charmander
Charmeleon
Charizard
Squirtle
Wartortle
Blastoise
Caterpie
Metapod
Butterfree
Weedle
Kakuna
Beedrill
Pidgey
Pidgeotto
Pidgeot
Rattata
Raticate
Spearow
Fearow
Ekans
Arbok
Pikachu
Raichu
25
Raichu
3
Pidgey
Kakuna

"""
import sys

N, M = map(int, input().split())
poket = {}

for i in range(1, N + 1):
    a = input()
    poket[i] = a
    poket[a] = i

for i in range(M):
    quest = input()
    if quest.isdigit():
        print(poket[int(quest)])
    else:
        print(poket[quest])
