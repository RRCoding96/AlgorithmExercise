man = []
for _ in range(9):
    man.append(int(input()))

# print(man)
man.sort()
total_height = sum(man)

# print(total_height)

flag = False
for i in range(0, 8):
    for j in range(i + 1, 9):
        choice_sum = man[i] + man[j]

        if total_height - choice_sum == 100:
            # print(man[i], man[j])

            # man.remove(man[i])
            # print(man)
            #
            # man.remove(man[j])
            # print(man)

            man.pop(i)
            man.pop(j - 1)

            flag = True
            break
    if flag:
        break

for i in range(7):
    print(man[i])
