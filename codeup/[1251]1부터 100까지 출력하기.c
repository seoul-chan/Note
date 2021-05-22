#include <stdio.h>
int main() {
	int n,sum=0,i=1;
	scanf("%d", &n);

	while (i <= n) {
		sum += i;
		i++;
	}
	printf("%d",sum);
}