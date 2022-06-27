#include <stdio.h>

int max(int num1,int num2);
int min(int num1, int num2);
int add(int num1,int num2){
    return num1+num2;
}
int sub(int num1,int num2){
    return num1-num2;
}
int mul(int num1,int num2){
    return num1*num2;
}
int div(int num1,int num2){
    return num1/num2;
}
int mod(int num1,int num2){
    return num1%num2;
}
int main(int argc, char const *argv[])
{
    int a = 100;
    int b = 200;
    int ret ;
    ret = max(a,b);
    printf("Max value is %d\n",ret);
    ret = min(a,b);
    printf("Min value is %d\n",ret);
    printf("Add min max : %d\n",min(a,b)+max(a,b));

    printf("add a b : %d\n",add(a,b));
    printf("sub a b : %d\n",sub(a,b));
    printf("mul a b : %d\n",mul(a,b));
    printf("div a b : %d\n",div(a,b));
    printf("mod a b : %d\n",mod(a,b));
    return 0;
}

int max(int num1, int num2){
    if (num1>num2){
        return num1;
    }
    return num2;
}

int min(int num1, int num2){
    if (num1<num2){
        return num1;
    }
    return num2;
}

