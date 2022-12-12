public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        arvore.inserir(7);
        arvore.inserir(5);
        arvore.inserir(12);
        arvore.inserir(9);
        arvore.inserir(6);
        arvore.inserir(21);
        arvore.inserir(2);
        arvore.inserir(25);
        arvore.inserir(19);
        System.out.println(arvore.pesquisar(7));
        arvore.exibir();


    }

    public static class No {
        public int dado;
        public No esquerdo;
        public No direito;
    
        public No(int elemento) {
            dado = elemento;
            esquerdo = null;
            direito = null;
        }
    }
    

    public static class ArvoreBinariaBusca {
        private No raiz;
    
        public ArvoreBinariaBusca() {
            raiz = null;
        }
    
        public void inserir(int elemento) {
            if (raiz == null) {
                new No(elemento);
            } else {
                inserir(elemento, raiz); // recursao
            }
        }
    
        public void inserir(int elemento, No raiz) {
            if (elemento < raiz.dado) {
                if (raiz.esquerdo == null) {
                    raiz.esquerdo = new No(elemento);
                } else {
                    inserir(elemento, raiz.esquerdo); 
                }
            } else if (elemento > raiz.dado) {
                if (raiz.direito == null) {
                    raiz.direito = new No(elemento);
                } else {
                    inserir(elemento, raiz.direito);
                }
            }
        }
    
        public void remover(int elemento) {
    
        }
    
        public boolean pesquisar(int elemento) {
            if (raiz == null) {
                return false;
            } else {
                return pesquisar(elemento, raiz); // recursao
            }
        }
    
        public boolean pesquisar(int elemento, No raiz) {
                if (elemento < raiz.dado) {
                    if (raiz.esquerdo == null) {
                        return false;
                    } else {
                        return pesquisar(elemento, raiz.esquerdo); 
                    }
                } else if (elemento > raiz.dado) {
                    if (raiz.direito == null) {
                        return false;
                    } else {
                        return pesquisar(elemento, raiz.direito);
                    }
                } else {
                    return true;
                }
            }
    
        public void exibir() {
    
        }
    }
    
}
