//Aþkýn Yavuz Tuna 150121016
//My program sometimes can't sorts songs exactly true way most of them become sorted but some of them can't sorted.
//Sometimes 2 song changes their location.
#include <stdio.h>
#include <stdlib.h>
//next struct type represents song;
struct song{
	char songName[25];
	int duration;
	struct song *next;
	};
	struct song * insertNode(struct song *pointer1,struct song *pointer2);
	void printList(struct song *pointer);
	void deleteNode(struct song *pointer1,char Name[]);
	void printListToFile(struct song *pointer);
	int isDigit(char a);
	int m;

int main() {
	//this strcts will be used.
	struct song *firstSong=NULL;
	struct song *lastSong=NULL;
	struct song *currentSong=NULL;
//	this part takes input from file and makes a list according to inputs.
	FILE *inputFile;
	if((inputFile=fopen("songs.txt","r"))==NULL){
		printf("input file is not exist");
	}
	else{
		while(!feof(inputFile)){
			currentSong=malloc(sizeof(struct song));
			char songName[25];
			int duration=0;
			int minutes=0;
			int second=0;
			char entered[31];
			fgets(entered,31,inputFile);
			int a;
			int b;
			for(a=0;a<31&&entered[a]!='\n';a++){
				if(entered[a]=='\n')
				break;
				if(entered[a]==':'){
					b=a;
				}
			}
			for(a=2;a>0;a--){
				if(isDigit(entered[b+a])){
				minutes*=10;
				minutes+=entered[b-a]-'0';
				}
			}
			for(a=1;a<3;a++){
				if(isDigit(entered[b+a])){
				second*=10;
				second+=entered[b+a]-'0';
				}
			}
			for(a=0;a<b-3;a++){
				songName[a]=entered[a];
			}
			
			duration=minutes*60+second;
			
			currentSong->duration=duration;
			for(a=0;a<25;a++){
				currentSong->songName[a]=songName[a];
				}
			if(firstSong==NULL){
				firstSong=malloc(sizeof(struct song));
				*firstSong=*currentSong;
				lastSong=malloc(sizeof(struct song));
				*lastSong=*currentSong;
			}
			else{
				insertNode(currentSong,firstSong);
			}
			
			
			m++;
			int j;
			for(j=0;j<25;j++){
				entered[j]='\0';
				songName[j]='\0';
			}
			for(;j<31;j++){
				entered[j]='\0';
			}
		}
	}
	fclose(inputFile);
	
	//nest loop prints user options and takes input about what user wants to do.
	int finished=1;
	printList(firstSong);
	while(finished){
		printf("\nEnter your choice:");
		printf("\n    1 to insert a song into the list.");
		printf("\n    2 to delete a song from the list.");
		printf("\n    3 to print the songs in the list.");
		printf("\n    4 to print the songs to an output file.");
		printf("\n    5 to end.");
		printf("\n? ");
		int operation;
		scanf("%d",&operation);
		char entered[31];
		char tempName [25];
		int tempMinutes=0;
		int tempSecond=0;
		int duration;
		int j;
		for(j=0;j<25;j++){
			tempName[j]=' ';
		}
		//this switch case takes input from user and do what user wants.
		switch (operation){
			case 1:
				printf("Enter a song name with duration:\n");
				scanf("%d",'1');
				gets(entered);
				int a,b=0;
				for(a=0;a<31;a++){
					if(entered[a]==':'){
					b=a;
					break;						
					}
				}
			for(a=2;a>0;a--){
				if(isDigit(entered[b-a])){
				tempMinutes*=10;
				tempMinutes+=entered[b-a]-'0';
				}
			}
			for(a=1;a<3;a++){
				if(isDigit(entered[b+a])){
				tempSecond*=10;
				tempSecond+=entered[b+a]-'0';
				}
			}
			for(a=0;a<b-3;a++){
				tempName[a]=entered[a];
			}
			duration=tempMinutes*60+tempSecond;
			struct song *currentSong=malloc(sizeof(struct song));
			*currentSong=*firstSong;
			currentSong->duration=duration;
			
			for(a=0;a<25;a++){
				currentSong->songName[a]=tempName[a];
			}
			if(firstSong==NULL){
				firstSong=malloc(sizeof(struct song));
				*firstSong=*currentSong;
				lastSong=malloc(sizeof(struct song));
				*lastSong=*currentSong;
			}
			else{
				insertNode(currentSong,firstSong);
			}
			m++;
			break;
			case 2:
				printf("Enter a song name:");
				scanf("%d",'1');
				gets(entered);
				int c;
				for(c=0;c<25;c++){
					tempName[c]=entered[c];
				}
				tempName[16]=firstSong->songName[16];
				tempName[17]=firstSong->songName[17];
				tempName[18]=firstSong->songName[18];
				tempName[24]=firstSong->songName[24];
				for(c=0;c<25;c++){
					int d;
					if(firstSong->songName[c]==tempName[c]){
						d++;
					}
				}
				deleteNode(firstSong,tempName);
			
			break;
			case 3:
			printList(firstSong);
			break;
			case 4:
			printListToFile(firstSong);
			break;
			case 5:
			finished=0;
			break;
			
		}	
	}
	
	return 0;
}
// this function adds song to the list.
	struct song * insertNode(struct song *pointer1,struct song *pointer2){
		struct song *currentPointer=malloc(sizeof(struct song));
		currentPointer=pointer2;
		int x,y=0;
		for(x=0;x<m;x++){
			if(currentPointer->duration<pointer1->duration){
				y++;
			}
			if(x==m-1){
				break;
			}
			(currentPointer)=(currentPointer->next);
		}
		*&(currentPointer)=*&(pointer2);
		for(x=0;x<y-1;x++){
			*&(currentPointer)=*&(currentPointer->next);		
		}
		*&(pointer1->next)=*&(currentPointer->next);
		*&(currentPointer->next)=*&pointer1;
			
	}
	//this function deletes input song from list. 
	void deleteNode(struct song *pointer,char Name[]){
		struct song *pointer1=malloc(sizeof(struct song));
		*pointer1=*pointer;
		int x,y,z;
		for(x=0,y=0;x<25;x++){
			if(Name[x]==pointer1->songName[x]){
				y++;
			}
		}
		if(y==25){
			*pointer1=*(pointer1->next);
			*pointer=*(pointer->next);
			m--;
			printf("The song %s is deleted from the list!",Name);
			return;
			
		}
		x=0,y=0,z=0;
		*pointer1=*pointer;
		for(x=0;x<m-2;x++){
			y=0;
			for(z=0;z<25;z++){
				if(z!=16&&z!=17&&z!=18&&z!=24){
					if(pointer1->next->songName[z]==Name[z]){
						y++;
					}	
				}
				
				
			}
		
			if(y==21){
				*(pointer1->next)=*(pointer1->next->next);
				m--;
				printf("The song %s is deleted from the list!",Name);
				return;
			}
			*pointer1=*(pointer1->next);
			
		}
		*pointer1=*pointer;
		for(x=0;x<m-2;x++){
			pointer1=pointer1->next;
		}
		y=0;
		for(z=0;z<25;z++){
			if(z!=16&&z!=17&&z!=18&&z!=24){
				if(pointer1->next->songName[z]==Name[z]){
					y++;
				}	
			}
			
		}
		if(y==21){
			
			*&(pointer1->next)=*&(pointer1->next->next);
			m--;
			printf("The song %s is deleted from the list!",Name);
			return;
		}
		printf("The list doesn't contain %s",Name);
		
	}
	//this function prints current list to the screen.
void printList(struct song *pointer){
	int k=0;
	printf("\n\nThe list in duration-time order:");
	while(k<m){
		int duration=pointer->duration%60;
		int a;
		char songName[25];
		for(a=0;a<25;a++){
			songName[a]=pointer->songName[a];
		}
		printf("\n\t%d. %s %d:%d",k+1,songName,pointer->duration/60,duration);
		pointer=pointer->next;
		k++;
		}
		printf("\n\n");
	}
	//this function takes input from user and prints current list to the file.
void printListToFile(struct song *pointer){
	FILE *outputFile;
	char outFileName [30];
	printf("Enter a file name:");
	scanf("%s",outFileName);
	outputFile=fopen(outFileName,"w");
	int k=0;
	fprintf(outputFile,"\nThe list in duration-time order:");
	while(k<m){
		int duration=pointer->duration%60;
		fprintf(outputFile,"\n\t%d.%s\t%d:%d",k+1,pointer->songName,pointer->duration/60,duration);
		pointer=pointer->next;
		k++;
		}
		fclose(outputFile);
		printf("\nOutput is printed to the file %s",outFileName);
	}
	//this function controls whether entered digit digit or not.
	int isDigit(char a){
		if(a>='0'&&a<='9')
		return 1;
		return 0;
	}
