#include <stdio.h>
int main() {
	printf("\\    /\\\n");
	printf(" )  ( ')\n");
	printf("(  /  )\n");
	printf(" \\(__)|\n");
	test();
}

test() {
	char c[100] = "¾È³ç¾È³ç";
	printf("%s",c);
}
