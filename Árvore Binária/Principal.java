/**
 * Principal para Arvore Binaria de Pesquisa
 * @author Max do Val Machado
 */
public class Principal {
   public static void main(String[] args) throws Exception {
      ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

      arvoreBinaria.inserir(1);
      arvoreBinaria.inserir(5);
      arvoreBinaria.inserir(6);

      //arvoreBinaria.mostrarCentral();
      //arvoreBinaria.mostrarPre();
      //arvoreBinaria.mostrarPos();

      //arvoreBinaria.remover(6);
     // arvoreBinaria.remover(2);
     // arvoreBinaria.remover(4);

      System.out.println(arvoreBinaria.isPar());
      System.out.print(arvoreBinaria.soma());
   }
}
