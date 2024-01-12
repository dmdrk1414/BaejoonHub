def getTotalDayFromString(string):
    year, month, day = map(int, string.split("."))
    return year * 12 * 28 + month * 28 + day


def solution(today, terms, privacies):
    answer = []
    toTalToDay = getTotalDayFromString(today)
    termsDic = dict()
    for term in terms:
        termsType, termsDay = term.split()
        termsDic[termsType] = int(termsDay) * 28

    for idx, privacie in enumerate(privacies):
        privacieStringDay, privacieType = privacie.split()
        totalDayPrivacieStringDay = getTotalDayFromString(
            privacieStringDay) + termsDic[privacieType]

        if toTalToDay >= totalDayPrivacieStringDay:
            answer.append(idx + 1)

    return answer


today = "2022.05.19"
terms = ["A 6", "B 12", "C 3"]
privacies = ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
answer = solution(today=today, terms=terms, privacies=privacies)

print(answer)
