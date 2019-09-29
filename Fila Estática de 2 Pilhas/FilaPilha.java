
class FilaPilha {
	private Pilha entrada;
	private Pilha saida;

	FilaPilha() {
		this(5);
	}

	FilaPilha(int tamanho) {
		entrada = new Pilha(tamanho);
		saida = new Pilha(tamanho);
	}

	public void inserir(int x) throws Exception {
		entrada.inserir(x);
	}

	public int remover() throws Exception{
		int deletado;
		int i = 0;

		while(!entrada.isVazia()) {
			deletado = entrada.remover();
			saida.inserir(deletado);
			i++;
		}

		int resp = saida.remover();

		while(i > 1) {
			deletado = saida.remover();
			entrada.inserir(deletado);
			i--;
		}
		return resp;
	}

	public void mostrar() {
		entrada.mostrar();
	}
}
