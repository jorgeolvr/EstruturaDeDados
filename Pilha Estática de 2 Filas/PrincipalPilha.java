/**
 * Fila estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
class PrincipalPilha {
   public static void main(String[] args) throws Exception {
      System.out.println("==== PILHA DE FILA ESTATICA ====");
      PilhaFila pf = new PilhaFila();
      int x1, x2, x3;

      pf.inserir(5);
      pf.inserir(7);
      pf.inserir(8);
      pf.inserir(9);

      System.out.println("Apos insercoes(5, 7, 8, 9): ");
      pf.mostrar();

      x1 = pf.remover();
      x2 = pf.remover();

      System.out.println("Apos remocoes (" + x1 + ", " + x2 + "):");
      pf.mostrar();
      }
}