sen = input()

sen = sen.split('-')

chunk = []
for i in range(0, len(sen)):
    numList = list(map(int, sen[i].split('+')))
    nowSum = sum(numList)
    chunk.append(nowSum)

result = chunk[0]
for i in range(1, len(chunk)):
    result -= chunk[i]

print(result)

