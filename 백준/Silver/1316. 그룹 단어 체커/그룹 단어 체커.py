
N = int(input())

sentences = []
for i in range(N):
    s = input()
    sentences.append(s)

# print(sentences)

answer = 0
for text in sentences:
    check = []
    check.append(text[0])
    for i in range(1, len(text)):
        if text[i-1] != text[i]:
            check.append(text[i])
        else:
            continue

    dupCheck = set()
    for c in check:
        dupCheck.add(c)

    if len(dupCheck) == len(check):
        answer += 1


print(answer)


