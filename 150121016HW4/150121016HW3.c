//Aþkýn Yavuz Tuna 150121016
#include <stdio.h>
//This struct represents String.
typedef struct{
	char characters[50];
	int length;
}String;
//next 5 line are prototypes of functions which will be used.
int charAt(String *s, int index);
String *concat(String *s1, String *s2);
unsigned int strSearch(String *s1, String *s2);
unsigned int findScore(String *s1);
int isLetter(char a);

int main() {
	/*next codes takes input file name and output file name and
	if there isn't file with output file name creates output file and prints output to this file,
	if there is file with output file name its content changes.*/
	FILE *enterFile;
	FILE *outFile;
	char entered[120];
	int shouldExit=0;
	char inputFileName[40];
	char outputFileName[40];
	printf("enter input file name: ");
	scanf("%s",&inputFileName);
	printf("enter output file name: ");
	scanf("%s",&outputFileName);
	enterFile=fopen(inputFileName,"r");
	outFile=fopen(outputFileName,"w");
	fclose(outFile);
	outFile=fopen(outputFileName,"a");
	int totalLetter=0;
	int totalWords=0;
	//this while loop takes input and makes what input file wants.
	while(shouldExit!=4){
		shouldExit=0;
		fgets(entered,120,enterFile);
		int a;
		String s1;
		s1.length=0;
		String s2;
		s2.length=0;
		for(a=0;entered[a]!=':'&&entered[a]!='\0';a++){
			s1.characters[a]=entered[a];
			if(isLetter(entered[a])){
				totalLetter++;
			}
			if(entered[a]==' '){
				totalWords++;
			}
			s1.length++;
		}
		totalWords++;
		
		int operation=entered[a+1];
		switch (operation){
			//if operation number is 1 this case happens.
			case '1':;
			int index=entered[14]-48;
			fprintf(outFile,"%c\n",charAt(&s1, index));
			break;
			//if operation number is 2 this case happens.
			case '2': ;
			int j;
			for(j=a+3;entered[j]!='\0';j++){
				s2.characters[j-a-3]=entered[j];
				if(isLetter(entered[j])){
					totalLetter++;
				}
				if(entered[j]==' '){
				totalWords++;
				}
			}
			totalWords++;
			*concat(&s1,&s2);
			fprintf(outFile,"%s",s1.characters);
			break;
			case '3': ;
			//if operation number is 3 this case happens.
			int m;
			for(m=a+3;isLetter(entered[m]);m++){
				s2.characters[m-a-3]=entered[m];
				s2.length++;
				if(isLetter(entered[m])){
					totalLetter++;
				}
				if(entered[m]==' '){
					totalWords++;
				}
				
			}
			totalWords++;
			fprintf(outFile,"%d\n",strSearch(&s1,&s2));
			break;
			//if operation number is 4 this case happens.
			case '4': ;
			int score=findScore(&s1);
			fprintf(outFile,"%d\n",score);
			break;
			
			default:;break;
		}
		//if input is stat next 10 line prints the number of words and number of letters to output file.
		if(entered[0]=='s'||entered[0]=='S')
			if(entered[1]=='t'||entered[1]=='T')
						if(entered[2]=='a'||entered[2]=='A')
									if(entered[3]=='T'||entered[3]=='t'){
										totalLetter-=4;
										totalWords--;
										fprintf(outFile,"The number of words: %d\n",totalWords);
										fprintf(outFile,"The number of alphabetic letters: %d\n",totalLetter);
									}
		
		//if input is quit or exit next 18 lines prints terminate massage to output file and terminates the program.
		if(entered[0]=='e'||entered[0]=='E')
			if(entered[1]=='x'||entered[1]=='X')
						if(entered[2]=='I'||entered[2]=='i')
									if(entered[3]=='T'||entered[3]=='t'){
										totalLetter-=4;
										totalWords--;
										fprintf(outFile,"Program ends. Bye");
										break;
									}
		if(entered[0]=='Q'||entered[0]=='q')
			if(entered[1]=='U'||entered[1]=='u')
						if(entered[2]=='I'||entered[2]=='i')
									if(entered[3]=='T'||entered[3]=='t'){
										totalLetter-=4;
										totalWords--;
										fprintf(outFile,"Program ends. Bye");
										break;
									}	
		//next 6 line deletes contents of the entered, s1 and s2.
		int m;
		for(m=0;m<120;m++){
			entered[m]='\0';
			s1.characters[m]='\0';
			s2.characters[m]='\0';
		}
	}
	
	
return 0;
}
//Next function gives the character stored at the location index.
int charAt(String *s, int index){
	int a=(*s).characters[index];
	if(index<(*s).length)
		return a;
	else 
		return-1;
}
//Next function concats two String.
String *concat(String *s1, String *s2){
	int k;
	for(k=(*s1).length;k<50;k++){
		(*s1).characters[k]=(*s2).characters[k-(*s1).length];
	}
	return (s1);
}
//Next function searches first string and finds the length of first word which consists of only second strings letter.
unsigned int strSearch(String *s1, String *s2){
	unsigned int a=0,b=0,c=0;
	while(a<(*s1).length){
		for(b=a;isLetter((*s1).characters[a]);a++){
			
		}
		int d=0;
		for(c=b;c<a;c++){
			int e;
			for(e=0;e<(*s2).length;e++){
				if((*s2).characters[e]==(*s1).characters[c]){
					d++;
					break;
				}
			}
		}
		if(d==a-b){
			return d;
		}
		a++;
	}
	
	return-1;
	
	
}
//Next function finds score according to input string.
unsigned int findScore(String *s1){
	unsigned int score=0;
	int a;
	for(a=0;a<(*s1).length;a++){
		char k=(*s1).characters[a];
		if(k=='A'||k=='E'||k=='I'||k=='O'||k=='U'||k=='L'||k=='N'||k=='R'||k=='S'||k=='T')
		score+=1;
		else if(k=='a'||k=='e'||k=='i'||k=='o'||k=='u'||k=='l'||k=='n'||k=='r'||k=='s'||k=='t')
		score+=1;
		else if(k=='D'||k=='G'||k=='d'||k=='g')
		score+=2;
		else if(k=='B'||k=='C'||k=='M'||k=='P'||k=='b'||k=='c'||k=='m'||k=='p')
		score+=3;
		else if(k=='F'||k=='H'||k=='V'||k=='W'||k=='Y'||k=='f'||k=='h'||k=='v'||k=='w'||k=='y')
		score+=4;
		else if(k=='K'||k=='k')
		score+=5;
		else if(k=='J'||k=='X'||k=='j'||k=='x')
		score+=2;
		else if(k=='Q'||k=='Z'||k=='q'||k=='z')
		score+=2;
	}
	return score;
}
//Next function controls whether input character is letter or not.
int isLetter(char a){
	if(a>='a'&&a<='z')
	return 1;
	else if(a>='A'&&a<='Z')
	return 1;
	return 0;
	
}
