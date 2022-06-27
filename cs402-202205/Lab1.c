#include <stdio.h>

#define TRUE 1
#define FALSE 0
typedef char bool;

int main() {
    bool b = TRUE;

    char ch1 = 'A';
    char ch2 = 'C';

    int val1 = 10, val2 = 20;
    int sum = val1 + val2;

    float f = 1.7;
    printf("Boolean variable b = %d \n",b);
    printf("Character variable ch1 = %c, ch2 = %c \n",ch1,ch2);
    printf("Integer variable val1 = %d, val2 = %d \n",val1,val2);
    printf("sum = val1 + val2; sum=%d \n",sum);
    printf("Float variable f = %f; \n",f);

    return 0;
}