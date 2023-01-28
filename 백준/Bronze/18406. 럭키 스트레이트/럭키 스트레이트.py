

full_point = input()

full_len = len(full_point)

left_point = list(map(int, full_point[0:(full_len // 2)]))
right_point = list(map(int, full_point[(full_len // 2):]))

left_sum = sum(left_point)
right_sum = sum(right_point)

if left_sum == right_sum:
    print('LUCKY')
else:
    print('READY')