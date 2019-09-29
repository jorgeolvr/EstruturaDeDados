/**
 * Torre de Hanói com Pilha Dinâmica
 * @author Jorge Allan de Castro Oliveira e Pedro Dornelas Aguiar
 * @version 1 05/2017
 */

import java.util.Scanner;

public class Torre {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in); //Instanciando objeto da classe Scanner para leitura de dados

        Pilha p1 = new Pilha('A');
        Pilha p2 = new Pilha('B');
        Pilha p3 = new Pilha('C');

        System.out.print("Digite o número de discos: ");
        int num = read.nextInt(); //Leitura do número de discos da jogada

        if(num > 0 && num < 16) { //Condicional que verifica se o valor atende ao número de discos impostos pela regra
            for(int i = num; i > 0; i--) {
                p1.inserir(i); //Inserção de todos os discos no primeiro pino ao iniciar a jogada
            }
            movimento(p1.tamanho(), p1, p2, p3);
        } else {
            System.out.println("Valor inválido, digite um número entre 1 e 15!");
        }
    }

    public static void movimento(int num, Pilha p1, Pilha p2, Pilha p3) throws Exception {
        if(num > 0) {
            movimento(num - 1, p1, p3, p2);
            p3.inserir(p1.remover());
            System.out.println("Mova o disco "+num+" do pino "+p1.getLetra()+" para o pino "+p3.getLetra());  
            movimento(num - 1, p2, p1, p3);
        }
    }
}

class Celula {
    public int elemento; //Valor inserido na célula
    public Celula prox; //Ponteiro de referência para a próxima célula

    /**
     * Construtor da classe.
     */
    public Celula() {

    }
 
    /**
     * Construtor da classe.
     * @param elemento int valor que será inserido na célula.
     */
    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

class Pilha {
    private Celula topo;
    private char letra;
 
    /**
     * Construtor da classe que cria uma pilha dinâmica sem elementos.
     */
    public Pilha(char letra) {
        topo = null;
        this.letra = letra;
    }

    /**
     * @return Letra correspondente a pilha.
     */
    public char getLetra() {
        return this.letra;
    }
 
    /**
     * Insere elemento na pilha (First in, last out).
     * @param x int elemento a inserir.
     */
    public void inserir(int x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
    }

    /**
     * Remove elemento da pilha (First in, last out).
     * @return Elemento removido.
     * @throws Exception Se a sequência não contiver elementos.
     */
    public int remover() throws Exception {
        //Validar remoção
        if (topo == null) {
            throw new Exception("Erro ao remover!");
        }
        
        int resp = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;

        return resp;
    }

    /**
     * Calcula e retorna o tamanho (Número de elementos da pilha).
     * @return tamanho int tamanho da pilha.
     */
    public int tamanho() {
        Celula tmp = topo;
        int tamanho;
        for(tamanho = 1; tmp.prox != null; tamanho++, tmp = tmp.prox);
        tmp = null;

        return tamanho;
    }
 
    /**
     * Mostra os elementos da pilha separados por espaços, começando do topo.
     */
    public void mostrar() {
        for(Celula i = topo; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
    }
}