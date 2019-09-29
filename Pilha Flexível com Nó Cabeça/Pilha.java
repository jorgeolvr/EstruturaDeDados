/**
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class Pilha {
	private Celula topo;

	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
	public Pilha() {
		topo = new Celula();
	}

	/**
	 * Insere elemento na pilha (politica FILO).
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
      	tmp = null;
	}

	/**
	 * Remove elemento da pilha (politica FILO).
	 * @return Elemento removido.
	 * @trhows Exception Se a sequencia nao contiver elementos.
	 */
	public int remover() throws Exception {
		if (tamanho() == 1) {
			throw new Exception("Erro ao remover!");
		}

		int resp = topo.elemento;
      	Celula tmp = topo;
		topo = topo.prox;
      	tmp.prox = null;
      	tmp = null;

		return resp;
	}

	public int tamanho() {
		int cont = 0;
		for(Celula i = topo; i != null; i = i.prox) {
			cont++;
		}
		return cont;
	}

	/**
	 * Mostra os elementos separados por espacos, comecando do topo.
	 */
	public void mostrar() {
		System.out.print("[ ");
		int cont = 0;
		for(Celula i = topo; cont != tamanho() - 1; i = i.prox, cont++) {
			System.out.print(i.elemento + " ");
      }
		System.out.println("] ");
	}
}
