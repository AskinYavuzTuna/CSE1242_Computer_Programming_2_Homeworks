//Aþkýn Yavuz Tuna 150121016
#include <stdio.h>
//Next 2 lines are function prototypes.
double calculateWeightBackIteration(int row, int col);
double calculateWeightBackRecursion(int row, int col);
//Next function returns a^y;
double power(double x,int y){
	int a;
	int total=1;
	for(a=0;a<y;a++)
	total*=x;
	return total;
}
//Next function calculates combination according to formula.
double combination(double x,double y){
	double result=1;
	for(;y>0;y--,x--){
		result=result*x/y;
	}
	if(x<y)
	return 0;
	return result;
}

int main() {
	//next 9 codes calculates results and prints them.
	printf("Person whose index is 20,11 carries:");
	printf("\n%f kilos",calculateWeightBackIteration(20,11));
	printf("\n%f kilos",calculateWeightBackRecursion(20,11));
	
	printf("\n\nPerson whose index is 4,2 carries:/n");
	printf("\n%f kilos",calculateWeightBackIteration(4,2));
	printf("\n%f kilos",calculateWeightBackRecursion(4,2));
	
	printf("\n\nPerson whose index is 17,3 carries:/n");
	printf("\n%f kilos",calculateWeightBackIteration(17,3));
	printf("\n%f kilos",calculateWeightBackRecursion(17,3));
	

	return 0;
}
//This function takes the row and column index of a person and returns the total weight on his/her back by using Iteration.
	double calculateWeightBackIteration(int row, int col){
		if(row<col*2){
			col=row-col;
		}
		int a=row;
		double total=0;
		int k;
		for(;a>0;a--) {
			k=row-a+1;
			int c;
			for(c=col;c>-1&&k>0;c--,k--) {
				total+=80/power(2,a)*combination(a,c);
			}
		}
		
		
		return total;
	}
//This function takes the row and column index of a person and returns the total weight on his/her back by using Recursion.
double calculateWeightBackRecursion(int row, int col){
	double total=0;
	if(row==0&&col==0)
	total=0;
	else if(col==0)
			total=calculateWeightBackRecursion(row-1,0)/2+40;
	else if(col==row)
			total=calculateWeightBackRecursion(row-1,col-1)/2+40;
	else
	total=calculateWeightBackRecursion(row-1,col-1)/2+calculateWeightBackRecursion(row-1,col)/2+80;
	return total;
	
}

