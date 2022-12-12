package ArvoreBinariaBuscaT;

public class ArvoreBinariaBuscaT<T extends Comparable> {
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

    public boolean remover(T valor) {
        // buscar elemento na arvore
        No<T> atual = this.raiz;
        No<T> paiAtual = null;
        while (atual != null) {
            if (atual.getValor().equals(valor)) {
                break;
            } else if (valor.compareTo(atual.getValor()) == -1){ // valor eh menor que atual
                paiAtual = atual; // anda a arvore com pai assumindo lugar do filho
                atual = atual.getEsquerdo(); // se o valor for menos, vai pra esquerda
            } else {
                paiAtual = atual;
                atual = atual.getDireito();
            }
        }
        return (atual != null);
    }

    public No<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(No<T> raiz) {
        this.raiz = raiz;
    }

}
