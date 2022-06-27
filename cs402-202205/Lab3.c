#include <stdio.h>

int main(int argc, char const *argv[])
{
    int a = 10;
    int b = 20;
    int result1;
    float result2;

    printf("add: a + b= %d\n",a+b);
    printf("subtract: a - b= %d\n",a-b);

    printf("multiplication: a * b= %d\n",a*b);

    result1 = a/b;
    result2 = a/b;
    printf("result1 division: a / b= %d  result2 division: a / b= %f\n",result1,result2);
    printf("modulo operation: a %% b= %d\n",a%b);
    
    return 0;
}
