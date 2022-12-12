package ArvoreBinariaBuscaT;

public class testeArvoreBinariaBuscaT {
    public static void main(String[] args) {
        ArvoreBinariaBuscaT arvore = new ArvoreBinariaBuscaT();
        arvore.adicionar(10);
        arvore.adicionar(5);
        arvore.adicionar(8);
        arvore.adicionar(9);
        arvore.adicionar(7);
        arvore.adicionar(18);
        arvore.adicionar(13);
        arvore.adicionar(20);

        System.out.println("\nEm Ordem");
        arvore.emOrdem(arvore.getRaiz());

        System.out.println("\nPre-Ordem");
        arvore.preOrdem(arvore.getRaiz());

        System.out.println("\nPos-Ordem");
        arvore.posOrdem(arvore.getRaiz());
    }
}
