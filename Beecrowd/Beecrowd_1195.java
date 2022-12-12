package Beecrowd;
import java.util.*;

public class Beecrowd_1195 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinariaBuscaT arvore = new ArvoreBinariaBuscaT();
        int C = sc.nextInt();

        for (int i = 0; i < C; i++) {
            int N = sc.nextInt();

            for (int j = 0; j < N; j++) {
                int n1 = sc.nextInt();
                arvore.adicionar(n1);
            }
            
        }
        System.out.println("Case 1: ");
        System.out.println("Pre.: ");
        arvore.emOrdem(arvore.getRaiz());
        
    }

    public static class No <T> {
        private T valor;
        private No <T> esquerdo;
        private No <T> direito;
        
        public No(T valor) {
            this.valor = valor;
            direito = null;
            esquerdo = null;
        }
    
    
        public T getValor() {
            return valor;
        }
        public void setValor(T valor) {
            this.valor = valor;
        }
        public No<T> getEsquerdo() {
            return esquerdo;
        }
        public void setEsquerdo(No<T> esquerdo) {
            this.esquerdo = esquerdo;
        }
        public No<T> getDireito() {
            return direito;
        }
        public void setDireito(No<T> direito) {
            this.direito = direito;
        }
    
        
    }
    

public static class ArvoreBinariaBuscaT<T extends Comparable> {
    private No<T> raiz;

    public ArvoreBinariaBuscaT() {
        this.raiz = null;
    }

    public void adicionar(T valor) {
        No<T> novoElemento = new No<T>(valor);
        if (raiz == null) {
            this.raiz = novoElemento;
        } else {
            No<T> atual = this.raiz;
            while (true) {
                if (novoElemento.getValor().compareTo(atual.getValor()) == -1) {
                    if (atual.getEsquerdo() != null) {
                        atual = atual.getEsquerdo();
                    } else {
                        atual.setEsquerdo(novoElemento);
                        break;
                    }
                } else {
                    if (atual.getDireito() != null) {
                        atual = atual.getDireito();
                    } else {
                        atual.setDireito(novoElemento);
                        break;
                    }
                }
            }
        }
    }

    public void emOrdem(No<T> atual) {
         if (atual != null) {
            emOrdem(atual.getEsquerdo());
            System.out.println(atual.getValor());
            emOrdem(atual.getDireito());  
         }
    }

    public void preOrdem(No<T> atual) {
        if (atual != null) {
            System.out.println(atual.getValor());
           preOrdem(atual.getEsquerdo());
           preOrdem(atual.getDireito());  
        }
   }


       public void posOrdem(No<T> atual) {
        if (atual != null) {
           posOrdem(atual.getEsquerdo());
           posOrdem(atual.getDireito());
           System.out.println(atual.getValor());  
        }
   }

    public No<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(No<T> raiz) {
        this.raiz = raiz;
    }

}

}
