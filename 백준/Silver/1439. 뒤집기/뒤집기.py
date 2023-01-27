line = list(map(int, input()))

zero_cnt = 0
one_cnt = 0

if line[0] == 0:
    zero_cnt += 1
if line[0] == 1:
    one_cnt += 1

for i in range(len(line) - 1):
    if line[i] != line[i + 1]:
        if line[i + 1] == 0:
            zero_cnt += 1
        else:
            one_cnt += 1

print(min(zero_cnt, one_cnt))