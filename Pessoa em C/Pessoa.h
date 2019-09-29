#ifndef PESSOA_H
#define PESSOA_H

#include<stdio.h>
#include<stdlib.h>

typedef struct Pessoa{
	int id;
	int idade;
	char nome[100];
	char nacionalidade[100];
	char nascimento[100];
	char localNascimento[100];
	char morte[100];
	char localMorte[100];
}Pessoa;

int contains(char *linha, const char *constante);
char *getSubstringEntre(char* linha, const char* inicio, const char* fim);
char *getData(char *linha);
char *removeTags(char *linha);
char *removeTagsData(char *linha);
Pessoa *novaPessoa();
void printPessoa(Pessoa *pessoa);
Pessoa* lerArquivo(char *nomeArquivo);

#endif
