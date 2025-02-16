import sys

# 입력 받기
N, C = map(int, sys.stdin.readline().split())
M = int(sys.stdin.readline())

tackBaes = []
for _ in range(M):
    start, end, amount = map(int, sys.stdin.readline().split())
    tackBaes.append([start, end, amount])

# 정렬: 도착 마을 기준 내림차순, 같으면 출발 마을 내림차순
tackBaes.sort(key=lambda x: (-x[1], -x[0]))

# 마을별 적재량 배열
arr = [0] * (N + 1)
ans = 0

# 택배 배송 처리
for start, end, amount in tackBaes:
    maxC = C

    for i in range(start + 1, end + 1):
        maxC = min(maxC, C - arr[i])

    can = min(amount, maxC)  # 적재 가능한 박스 개수 결정

    for i in range(start + 1, end + 1):
        arr[i] += can

    ans += can

print(ans)
