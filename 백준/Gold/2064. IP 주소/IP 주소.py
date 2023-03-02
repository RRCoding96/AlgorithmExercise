import sys

n = int(sys.stdin.readline().rstrip())

ip_list = []
temp = []
for _ in range(n):
    temp = list(map(int, sys.stdin.readline().rstrip().split('.')))
    ip_list.append(temp)

ip_list = sorted(ip_list)
# print('ip 리스트')
# print(ip_list, sep='\n')

is_single = False
if len(ip_list) == 1:
    is_zero = False
    if temp[0] == 0 and temp[1] == 0 and temp[2] == 0 and temp[3] == 0:
        print('0.0.0.0')
        print('255.255.255.255')
        is_zero = True
        is_single = True

    if not is_zero:
        net_result = ''
        for i in range(4):
            net_result += str(temp[i])
            net_result += '.'
        net_result = net_result[:-1]
        print(net_result)

        sub_result = ''
        for i in range(4):
            if temp[i] != 0:
                sub_result += str(255)
            elif temp[i] == 0:
                sub_result += '0'
            sub_result += '.'
        sub_result = sub_result[:-1]
        print(sub_result)
        is_single = True

if not is_single:
    min_ip = ip_list[0]
    max_ip = ip_list[-1]

    if min_ip == max_ip:
        net_result = ''
        for i in range(4):
            net_result += str(temp[i])
            net_result += '.'
        net_result = net_result[:-1]
        print(net_result)

        sub_result = ''
        for i in range(4):
            if temp[i] != 0:
                sub_result += str(255)
            elif temp[i] == 0:
                sub_result += '0'
            sub_result += '.'
        sub_result = sub_result[:-1]
        print(sub_result)

    else:

        min_ip_bin = []
        max_ip_bin = []
        for i in range(4):
            tmp1 = list(bin(min_ip[i])[2:])
            while len(tmp1) < 8:
                tmp1.insert(0, '0')
            min_ip_bin.append(tmp1)

            tmp2 = list(bin(max_ip[i])[2:])
            while len(tmp2) < 8:
                tmp2.insert(0, '0')
            max_ip_bin.append(tmp2)

        sub_idx = [-1, -1]
        for i in range(4):
            min_chunk = min_ip_bin[i]
            max_chunk = max_ip_bin[i]
            if min_chunk != max_chunk:
                for j in range(8):
                    if min_chunk[j] != max_chunk[j]:
                        sub_idx = [i, j - 1]
                        break
            if sub_idx != [-1, -1]:
                break

        ans_sub = ''
        c_cnt = 0
        for i in range(4):
            if i < sub_idx[0]:
                for j in range(8):
                    ans_sub += '1'

            else:
                if c_cnt == 0:
                    for j in range(sub_idx[1] + 1):
                        ans_sub += '1'
                    for j in range(sub_idx[1] + 1, 8):
                        ans_sub += '0'
                    c_cnt += 1
                else:
                    for j in range(0, 8):
                        ans_sub += '0'

            ans_sub += '.'
        ans_sub = ans_sub[:-1]
        # print('서브넷 주소 구한거')
        # print(ans_sub)

        ans_ip = ''
        c_idx = 0
        n_idx = 0
        for i in range(len(ans_sub)):
            if ans_sub[i] == '.':
                ans_ip += '.'
                c_idx += 1
                n_idx = 0
            elif ans_sub[i] == '1':
                ans_ip += min_ip_bin[c_idx][n_idx]
                n_idx += 1
            elif ans_sub[i] == '0':
                ans_ip += '0'
                n_idx += 1

        # print('네트워크 주소 구한거')
        # print(ans_ip)

        net_result = ''
        net_list = list(ans_ip.split('.'))
        # print(net_list)
        for i in range(4):
            net_result += str(int(net_list[i], 2))
            net_result += '.'

        net_result = net_result[:-1]
        print(net_result)

        sub_result = ''
        sub_list = list(ans_sub.split('.'))
        # print(sub_list)
        for i in range(4):
            sub_result += str(int(sub_list[i], 2))
            sub_result += '.'

        sub_result = sub_result[:-1]
        print(sub_result)
