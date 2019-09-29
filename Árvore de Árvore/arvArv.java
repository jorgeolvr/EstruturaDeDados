class No1 {
	public char letra;
	public No1 esq, dir;
	public No2 outra;

	public No1() {
		this(' ');
	}

	public No1(char letra) {
		this.letra = letra;
		this.esq = this.dir = null;
		this.outra = null;
	}
}

class No2 {
	public String palavra;
	public No2 esq, dir;

	public No2() {
		this (" ");
	}

	public No2(String palavra) {
		this.palavra = palavra;
		this.esq = this.dir = null;
	}

	public void mostrar(No2 i) {
		if(i != null) {
			mostrar(i.esq);
			System.out.print(i.elemento+" ");
			mostrar(i.dir);
		}
	}
}

class arvArv {
	private No1 raiz;

	public arvArv() {
		raiz = new No1('P');
		raiz.esq = new No1('H');
		raiz.dir = new No1('T');
		raiz.esq.esq = new No1('D');
		raiz.esq.dir = new No1('L');
		raiz.dir.esq = new No1('R');
		raiz.dir.dir = new No1('X');
		raiz.esq.esq.esq = new No1('B');
		raiz.esq.esq.dir = new No1('F');
		raiz.esq.dir.esq = new No1('J');
		raiz.esq.dir.dir = new No1('N');
		raiz.dir.esq.esq = new No1('Q');
		raiz.dir.esq.dir = new No1('S');
		raiz.dir.dir.esq = new No1('V');
		raiz.dir.dir.dir = new No1('Y');
		raiz.esq.esq.esq.esq = new No1('A');
		raiz.esq.esq.esq.dir = new No1('C');
		raiz.esq.esq.dir.esq = new No1('E');
		raiz.esq.esq.dir.dir = new No1('G');
		raiz.esq.dir.esq.esq = new No1('I');
		raiz.esq.dir.esq.dir = new No1('K');
		raiz.esq.dir.dir.esq = new No1('M');
		raiz.esq.dir.dir.dir = new No1('O');
		raiz.dir.dir.esq.esq = new No1('U');
		raiz.dir.dir.esq.dir = new No1('W');
		raiz.dir.dir.dir.dir = new No1('Z');
	}

	public void inserir(String s) throws Exception {
		inserir(s, raiz);
	}

	public void inserir(String s, No1 i) throws Exception {
		if(i == null) {
			throw new Exception("Erro ao inserir");
		} else if(s.charAt(0) < i.letra) {
			inserir(s, i.esq);
		} else if(s.charAt(0) > i.letra) {
			inserir(s, i.dir);
		} else {
			i.outra = inserir(s, i.outra);
		}
	}

	public No2 inserir(String s, No2 i) throws Exception {
		if(i == null) {
			i = new No2(s);
		} else if(s.compareTo(i.palavra) < 0) {
			i.esq = inserir(s, i.esq);
		} else if(s.compareTo(i.palavra) > 0) {
			i.dir = inserir(s, i.dir);
		} else {
			throw new Exception("Erro");
		}
		return i;
	}

	public boolean pesquisar(String elemento) {
        return pesquisar(raiz, elemento);
    }
 
    private boolean pesquisar(No1 i, String s) {
      	boolean resp;
        if (i == null) { 
         	resp = false;
      	} else if (s.charAt(0) == i.elemento) { 
         	resp = pesquisarSegundaArvore(i.outra, s); 
      	} else if (s.charAt(0) < i.elemento) { 
         	resp = pesquisar(i.esq, s); 
      	} else { 
         	resp = pesquisar(i.dir, s); 
      	}
      	return resp;
    }
 
    private boolean pesquisarSegundaArvore(No2 no, String x) {
      boolean resp;
        if (no == null) { 
         resp = false;
 
      } else if (x.equals(no.elemento)) { 
         resp = true; 
 
      } else if (x.compareTo(no.elemento) < 0) { 
         resp = pesquisarSegundaArvore(no.esq, x); 
 
      } else { 
         resp = pesquisarSegundaArvore(no.dir, x); 
      }
      return resp;
    }
}

