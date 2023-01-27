N = int(input())

numbers = list()
for i in range(N):
    numbers.append(int(input()))

posi = []
nega = []
answer = 0
for i in numbers:
    if i > 1:
        posi.append(i)
    elif i == 1:
        answer += 1
    else:
        nega.append(i)

nega.sort()
posi.sort(reverse=True)

if len(nega) % 2 == 0:
    result = 0
    for i in range(0, len(nega), 2):
        result += nega[i] * nega[i + 1]
    answer += result
else:
    result = 0
    for i in range(0, len(nega)-1, 2):
        result += nega[i] * nega[i + 1]
    result += nega[-1]
    answer += result


if len(posi) % 2 == 0:
    result = 0
    for i in range(0, len(posi), 2):
        result += posi[i] * posi[i + 1]
    answer += result
else:
    result = 0
    for i in range(0, len(posi)-1, 2):
        result += posi[i] * posi[i + 1]
    result += posi[-1]
    answer += result

print(answer)
