//Aşkın Yavuz Tuna 150121016
#include <stdio.h>


//this code reverses numbers last N digits;
void reverseN(int *number, int N){
int a,tempReverse=0;
int temp=*number;
for(a=0;a<N;a++){
	tempReverse=tempReverse*10+temp%10;
	temp/=10;
}
for(;a>0;a--){
temp*=10;	
}
temp+=tempReverse;
*number=temp;
}

int main() {
	//Next 3 lines takes 2 number from user;
	int entered;
	int digitChange;
	scanf("%d %d",&entered,&digitChange);
	//Next 3 lines controls how many digit number which is entered to reverse has.
	int digitNumber,current;
	for(digitNumber=0,current=entered;current>0;digitNumber++)
	current/=10;
	/*If number which will be changed has less digit than number of numbers which will be changed,
	this 2 line prints error massage. */ 
	if(digitNumber<digitChange)
	printf("N must be less than %d!",digitNumber+1);
	//if inputs are valid next 3 line reverses numbers last N digits and prints it.
	else{
		reverseN(&entered,digitChange);
		printf("%d",entered);	
	}

	return 0;
}
