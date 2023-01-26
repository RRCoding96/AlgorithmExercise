arr = input()

change_zero = 0
change_one = 0

if arr[0] == '0':
    change_one += 1
else:
    change_zero += 1

for i in range(len(arr) - 1):
    if arr[i] != arr[i+1]:
        if arr[i+1] == '0':
            change_one += 1
        else:
            change_zero += 1

result = min(change_one, change_zero)

print(result)
