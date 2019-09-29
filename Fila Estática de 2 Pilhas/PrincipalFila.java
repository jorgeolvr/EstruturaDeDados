/**
 * Fila estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalFila {
   public static void main(String[] args) throws Exception {
      System.out.println("==== FILA DE PILHA ESTATICA ====");
      FilaPilha fp = new FilaPilha();
      int x1, x2, x3;

      fp.inserir(5);
      fp.inserir(7);
      fp.inserir(8);
      fp.inserir(9);

      System.out.println("Apos insercoes(5, 7, 8, 9): ");
      fp.mostrar();

      x1 = fp.remover();
      x2 = fp.remover();

      System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
      fp.mostrar();
      }
}