/**
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
#include <stdio.h>
#include <stdlib.h>
#include <err.h>

//TIPO CELULA
typedef struct Celula {
	int elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(int elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

//PILHA DINAMICA
Celula* topo; // Sem celula cabeca.

/**
 * Cria uma fila sem elementos.
 */
void start () {
   topo = NULL;
}

/**
 * Insere elemento na pilha (politica FILO).
 * @param x int elemento a inserir.
 */
void inserir(int x) {
   Celula* tmp = novaCelula(x);
   tmp->prox = topo;
   topo = tmp;
   tmp = NULL;
}

/**
 * Remove elemento da pilha (politica FILO).
 * @return Elemento removido.
 */
int remover() {
   if (topo == NULL) {
      errx(1, "Erro ao remover!");
   }

   int resp = topo->elemento;
   Celula* tmp = topo;
   topo = topo->prox;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}

int tamanho() {
   Celula* tmp = topo;
   int tamanho;
   for(tamanho = 0; tmp->prox != NULL; tamanho++, tmp = tmp->prox);
      tmp = NULL;
   return tamanho;
}

Celula* copy(Celula* uma) {
   int cont = 0;
	int tam = tamanho();
   start();
   Celula* i;
   Celula* j;

   for(i = uma; i->prox != NULL; i = i->prox);
   inserir(i->elemento);

   while(cont != tam) {
      for(j = uma; j->prox != i; j = j->prox);
      i = j;
      cont++;
      inserir(i->elemento);
   } 
	return topo;
}

Celula* merge(Celula* primeira, Celula* segunda) {
   start();
   Celula* i = primeira;
   Celula* j = segunda;

   while(i != NULL || j != NULL) {
      inserir(i->elemento);
      i = i->prox;
      inserir(j->elemento);
      j = j->prox;
   }
   return topo;
}

//METODO PRINCIPAL
int main(int argc, char** argv){
   	printf("PILHA FLEXÍVEL\n");

   	start();

   	inserir(0);
   	inserir(1);
   	inserir(2);
   	inserir(3);
   	inserir(4);
   	inserir(5);

   	Celula* copia = copy(topo);
      Celula* mix = merge(topo, copia);

   	for(Celula* i = mix; i != NULL; i = i->prox) {
		printf("%d ", i->elemento);
	}
}
