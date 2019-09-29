#include <string.h>
#include "Pessoa.h"

int contains(char *linha, const char *constante){
	if (strstr(linha, constante) != NULL)
		return 1;
	else
		return 0;
}

char *getSubstringEntre(char *linha, const char* inicio, const char*fim){
	int i =0;
	char substring[200];
	char* begin = strstr(linha, inicio);
	char* end = strstr(linha, fim);
	begin+=strlen(inicio);

	while(begin != end){
		substring[i] = *begin;
		i++;
		begin++;
	}
	substring[i] = '\0';
	return strdup(substring);
}

char *getData(char *linha){
	int i =0;
	char substring[200];
	char* begin = linha;
	char* end = strstr(linha, "(");

	while(begin != end){
		substring[i] = *begin;
		i++;
		begin++;
	}
	substring[i] = '\0';
	return strdup(substring);
}

char *removeTags(char *linha){
	char *resp = (char*) malloc(200);
	int i=0, k=0;
	while(linha[i]!='\n'){
		if(linha[i] == ' '){
			i++;
		}else if(linha[i] == '<'){
			while(linha[i]!='>'){
				i++;
			}
			i++;
		} else {
			while(linha[i]!='<'){
				if(linha[i]== '&'){
					while (linha[i]!=';') i++;
				}else{
					resp[k] = linha[i];
					k++;
				}
				i++;
			}
		}
	}
	resp[k] = '\0';
	return strdup(resp);
}

char *removeTagsData(char *linha){
	char *resp = (char*) malloc(200);
	int i=0, k=0;
	while(linha[i]!='\n'){
		if(linha[i] == '<'){
			while(linha[i]!='>'){
				i++;
			}
			i++;
		} else {
			while(linha[i]!='<'){
				if(linha[i]== '&'){
					while (linha[i]!=';') i++;
				}else{
					resp[k] = linha[i];
					k++;
				}
				i++;
			}
		}
	}
	resp[k] = '\0';
	return strdup(resp);
}

Pessoa *novaPessoa(){
	Pessoa *pessoa = (Pessoa *) malloc(sizeof(Pessoa));
	pessoa->id = 0;
	pessoa->idade = 0;
	memset(pessoa->nome, 0, 100);
	memset(pessoa->nacionalidade, 0, 100);
	memset(pessoa->nascimento, 0, 100);
	memset(pessoa->localNascimento, 0, 100);
	memset(pessoa->morte, 0, 100);
	memset(pessoa->localMorte, 0, 100);
	return pessoa;
}

void printPessoa(Pessoa *pessoa){
	printf("%d\n", pessoa->id);
	printf("%d\n", pessoa->idade);
	printf("%s\n", pessoa->nome);
	printf("%s\n", pessoa->nacionalidade);
	printf("%s\n", pessoa->nascimento);
	printf("%s\n", pessoa->localNascimento);
	printf("%s\n", pessoa->morte);
	printf("%s\n", pessoa->localMorte);
}

Pessoa* lerArquivo(char *nomeArquivo){
	Pessoa *pessoa = novaPessoa();

	FILE *fp = fopen(nomeArquivo, "r");
	char *buff = (char*)malloc(2000);

	pessoa->id = atoi(getSubstringEntre(nomeArquivo, "tmp/", ".html"));

	while (!contains(buff, "<h1")){
		fgets(buff, 2000, (FILE*)fp);
	}
	strcpy(pessoa->nome, getSubstringEntre(buff, "lang=\"pt\">", "</h1>"));

	while (!contains(buff, "Nacionalidade")){
		fgets(buff, 2000, (FILE*)fp);
	}
	fgets(buff, 2000, (FILE*)fp);
	strcpy(pessoa->nacionalidade, removeTags(buff));

	while (!contains(buff, "Nascimento")){
		fgets(buff, 2000, (FILE*)fp);
	}
	fgets(buff, 2000, (FILE*)fp);
	strcpy(pessoa->nascimento, removeTagsData(buff));

	int tam1 = strlen(pessoa->nascimento);
	if(pessoa->nascimento[tam1-1] == ')'){
		char *tmp1 = getSubstringEntre(pessoa->nascimento, "(", "anos)");
		pessoa->idade = atoi(tmp1);
		strcpy(pessoa->nascimento, getData(pessoa->nascimento));
		strcpy(pessoa->morte, "vivo");
		strcpy(pessoa->localMorte, "vivo");
	}else{
		strcpy(pessoa->morte, "");
		strcpy(pessoa->localMorte, "");
	}

	while (!contains(buff, "Local")){
		fgets(buff, 2000, (FILE*)fp);
	}
	fgets(buff, 2000, (FILE*)fp);
	strcpy(pessoa->localNascimento, removeTags(buff));

	if(strlen(pessoa->morte)==0){
		while (!contains(buff, "Morte")){
			fgets(buff, 2000, (FILE*)fp);
		}
		fgets(buff, 2000, (FILE*)fp);
		strcpy(pessoa->morte, removeTagsData(buff));

		int tam2 = strlen(pessoa->morte);
		if(pessoa->morte[tam2-1] == ')'){
			char *tmp2 = getSubstringEntre(pessoa->morte, "(", "anos)");
			pessoa->idade = atoi(tmp2);
			strcpy(pessoa->morte, getData(pessoa->morte));
		}

		while (!contains(buff, "Local")){
			fgets(buff, 2000, (FILE*)fp);
		}
		fgets(buff, 2000, (FILE*)fp);
		strcpy(pessoa->localMorte, removeTags(buff));
	}

	fclose(fp);

	return pessoa;
}
