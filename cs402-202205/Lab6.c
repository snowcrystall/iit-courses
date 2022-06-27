#include <stdio.h>

int ag = 100;

int sum(int a,int b);
int increaseVal(int a,int b);

int main(int argc, char const *argv[])
{
    int a=10;
    int b = 20;
    int c = 0;

    printf("value of global variable ag in main()=%d\n",ag);
    printf("value of a in main() =%d\n",a);
    printf("value of b in main() =%d\n",b);

    c = increaseVal(a,b);
    printf("value of c in main() after increaseVal() =%d\n",c);
    c = sum(a,b);
    printf("value of c in main() =%d\n",c);
    return 0;
}
int sum(int a,int b){
    return a+b;
}
int increaseVal(int a,int b){
    a += ag;
    b += ag; 
    return a+b;
}
