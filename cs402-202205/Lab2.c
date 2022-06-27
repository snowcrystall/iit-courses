/*#include <stdio.h>

#define NUM1 1
#define STR1 "111"
#define CONFLOAT 11.11

int main(int argc, char const *argv[])
{
    printf("NUM1: %d STR1: %s CONFLOAT %f ",NUM1, STR1, CONFLOAT);
    return 0;
}*/
#include <stdio.h>

int main(int argc, char const *argv[])
{
    const int NUM1 = 1;
    const char STR1[] = {"111"};
    const float CONFLOAT = 11.11;
    printf("NUM1: %d STR1: %s CONFLOAT %f ",NUM1, STR1, CONFLOAT);
    return 0;
}

#include <stdio.h>
 
#define square(x) x* x
int main()
{
    // Expanded as 36/6*6
    int x = 36 / square(6);
    printf("%d", x);
    return 0;
}



