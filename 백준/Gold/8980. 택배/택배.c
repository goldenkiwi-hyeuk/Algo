#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int start, end, amount;
} TackBae;

// 비교 함수 (도착 마을 기준 정렬, 같으면 출발 마을 오름차순)
int compare(const void *a, const void *b) {
    TackBae *t1 = (TackBae*)a;
    TackBae *t2 = (TackBae*)b;
    if (t1->end == t2->end) {
        return t1->start - t2->start;
    }
    return t1->end - t2->end;
}

int main() {
    int N, C, M;
    scanf("%d %d", &N, &C);
    scanf("%d", &M);

    TackBae tackBaes[M];
    int arr[N+1]; // 각 마을 간의 트럭 적재량을 저장할 배열
    for (int i = 0; i <= N; i++) arr[i] = 0; // 초기화

    // 입력 받기
    for (int i = 0; i < M; i++) {
        scanf("%d %d %d", &tackBaes[i].start, &tackBaes[i].end, &tackBaes[i].amount);
    }

    // 정렬 수행
    qsort(tackBaes, M, sizeof(TackBae), compare);

    int ans = 0;
    // 각 배송 요청 처리
    for (int i = 0; i < M; i++) {
        int maxC = C;
        
        // 구간 내 최대 적재 가능 용량 계산
        for (int j = tackBaes[i].start; j < tackBaes[i].end; j++) {
            if (C - arr[j] < maxC) {
                maxC = C - arr[j];
            }
        }

        int can = (tackBaes[i].amount < maxC) ? tackBaes[i].amount : maxC;

        // 구간 업데이트
        for (int j = tackBaes[i].start; j < tackBaes[i].end; j++) {
            arr[j] += can;
        }

        ans += can;
    }

    printf("%d\n", ans);
    return 0;
}
