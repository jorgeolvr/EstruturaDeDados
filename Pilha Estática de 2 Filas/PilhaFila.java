
class PilhaFila {
	private Fila entrada;
	private Fila saida;

	PilhaFila() {
		this(5);
	}

	PilhaFila(int tamanho) {
		entrada = new Fila(tamanho);
		saida = new Fila(tamanho);
	}

	public void inserir(int x) throws Exception {
		entrada.inserir(x);
	}

	public int remover() throws Exception {
		int deletado;
		int i = 0;
		while(!entrada.isVazia()) {
			deletado = entrada.remover();
			saida.inserir(deletado);
			i++;
		}
		while(i > 1){
			deletado = saida.remover();
			entrada.inserir(deletado);
			i--;
		}
		return saida.remover();
	}

	public void mostrar() {
		entrada.mostrar();
	}
}
