#include <stdio.h>

void search(int a[],int len, int x){
    
    printf("search for %d:\n",x);
    int find = 0;
    for(int i=0;i<20;i++){
        if (a[i] == x){
            printf("%d in the array\n",x);
            find = 1;
            break;
        }
    }
    if (find == 0){
        printf("the value %d is not in the array\n",x);
    }
}

void printary(int a[],int len){
    for(int i=0;i<len;i++){
        printf(" %d ",a[i]);
    }
    printf("\n");
}
int compare_ints(const void* a, const void* b)
{
    int arg1 = *(const int*)a;
    int arg2 = *(const int*)b;
 
    if (arg1 < arg2) return -1;
    if (arg1 > arg2) return 1;
    return 0;
 
}
int main(void) {
    int a[20] = {1,4,8,4,3,34,67,35,9,7,8,14,23,13,37,11,2,0,2,7};
    search(a,20,34);
    search(a,20,88);
    printf("array before sort:\n");
    printary(a,20);
    qsort(a, 20, sizeof(int), compare_ints);
    printf("array after sort:\n");
    printary(a,20);
    return 0;
}