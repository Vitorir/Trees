package Beecrowd;
import java.util.*;

public class Beecrowd_1861 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        ArvoreBuscaT<String> arvore = new ArvoreBuscaT<String>();

        while(scanner.hasNext()) {
            String assassino = scanner.next();
            arvore.addNode(assassino);

            String assassinado = scanner.nextLine();
        }
        
    }


	public static class TNode<T> {
		private T valor;
		private T assassinatos;
		private TNode<T> pai;
		private TNode<T> filhoE;
		private TNode<T> filhoD;

		
		
		public TNode() {
		}

		public TNode(T valor) {
			this(valor,null,null,null);
		}

		public TNode(T valor, T assassinatos) {
			this.valor = valor;
			this.assassinatos = assassinatos;
		}

		public TNode(T valor, TNode<T> pai) {
			this(valor,pai,null,null);
		}
		
		public TNode(T valor, TNode<T> pai, TNode<T> filhoE, TNode<T> filhoD) {
			this.valor = valor;
			this.pai = pai;
			this.filhoE = filhoE;
			this.filhoD = filhoD;
		}

		public int incrementaContador () {
			int a = (Integer) assassinatos;
			return a++;
		}
		
		public T getValor() {
			return valor;
		}
		
		public TNode<T> getPai() {
			return pai;
		}
		
		public TNode<T> getFilhoE() {
			return filhoE;
		}
		
		public TNode<T> getFilhoD() {
			return filhoD;
		}
		
		public void setValor(T valor) {
			this.valor = valor;
		}
		
		public void setPai(TNode<T> pai) {
			this.pai = pai;
		}
		
		public void setFilhoE(TNode<T> filhoE) {
			this.filhoE = filhoE;
		}
		
		public void setFilhoD(TNode<T> filhoD) {
			this.filhoD = filhoD;
		}
		
		public boolean isFilhoE() {
			return (this.getPai().getFilhoE() == this);
		}
	}


public static class ArvoreBuscaT<T> {
    private static TNode root;
    
    public int getSize() {
        if (root == null)
            return 0;
        
        int size = 0;
        TNode<T> node;
        ArrayList<TNode<T>> v = new ArrayList<TNode<T>>();
        v.add(root);
        while (v.size() != 0) {
            node = v.remove(0);
            size++;
            if (node.getFilhoE() != null)
                v.add(node.getFilhoE());
            if (node.getFilhoD() != null)
                v.add(node.getFilhoD());
        }
        
        return size;
    }
    
    public boolean isEmpty() {
        return getSize() == 0;
    }
    
    public int altura() {
        return altura(root);
    }
    
    public int altura(TNode<T> node) {
        return altura(node, 0);
    }
    
    private int altura(TNode<T> n, int a) {
        int altura = 0;
        if (n != null) {
            altura = a;
            altura = Math.max(altura, altura(n.getFilhoE(), a + 1));
            altura = Math.max(altura, altura(n.getFilhoD(), a + 1));
        }
        return altura;
    }
    
    public static void addNode(T valor) {
        TNode node = new TNode(valor);        
        if (root == null)
            root = node;
        else
            addNode(node,root);
    }
    
    private static void addNode(TNode node, TNode pai) {
        if (compara(node.getValor(),pai.getValor()) > 0) {
            if (pai.getFilhoD() != null) {
                addNode(node,pai.getFilhoD());
            } else {
                node.setPai(pai);
                pai.setFilhoD(node);
            }
        } else if (compara(node.getValor(),pai.getValor()) < 0) {
            if (pai.getFilhoE() != null) {                
                addNode(node,pai.getFilhoE());
            } else {
                node.setPai(pai);
                pai.setFilhoE(node);
            }
        }
    }
    
    public boolean removeNode(T valor) {
        TNode<T> node = root;
        
        while (node != null) {
            if (compara(valor,node.getValor()) < 0)
                node = node.getFilhoE();
            else if (compara(valor,node.getValor()) > 0)
                node = node.getFilhoD();
            else
                break;
        }
        
        if (node != null) {
            removeNode(node);
            return true;
        }
        
        return false;
    }
    
    private void removeNode(TNode<T> nodeRemove) {
        if (nodeRemove.getFilhoE() == null || nodeRemove.getFilhoD() == null) {
            removeFolha(nodeRemove);
        } else {
            TNode<T> node = nodeRemove.getFilhoD();
            while (node.getFilhoE() != null) {
                node = node.getFilhoE();
            }
            removeFolha(node);
            node.setPai(nodeRemove.getPai());
            node.setFilhoE(nodeRemove.getFilhoE());
            node.setFilhoD(nodeRemove.getFilhoD());
            if (node.getFilhoE() != null)
                node.getFilhoE().setPai(node);
            if (node.getFilhoD() != null)
                node.getFilhoD().setPai(node);
            if (nodeRemove != root) {
                if (nodeRemove.isFilhoE()) {
                    node.getPai().setFilhoE(node);
                } else {
                    node.getPai().setFilhoD(node);
                }
            } else {
                root = node;
            }
        }
    }
    
    private void removeFolha(TNode<T> node) {
        if (node.getFilhoE() == null && node.getFilhoD() == null) {
            if (node != root) {
                if (node.isFilhoE()) {
                    node.getPai().setFilhoE(null);
                } else {
                    node.getPai().setFilhoD(null);
                }
            } else {
                root = null;
            }
        } else if (node.getFilhoE() == null || node.getFilhoD() == null) {
            if (node.getFilhoE() == null) {
                if (node != root) {
                    node.getFilhoD().setPai(node.getPai());
                    if (node.isFilhoE()) {
                        node.getPai().setFilhoE(node.getFilhoD());
                    } else {
                        node.getPai().setFilhoD(node.getFilhoD());
                    }
                } else {
                    node.getFilhoD().setPai(null);
                    root = node.getFilhoD();
                }
            } else {
                if (node != root) {
                    node.getFilhoE().setPai(node.getPai());
                    if (node.isFilhoE()) {
                        node.getPai().setFilhoE(node.getFilhoE());
                    } else {
                        node.getPai().setFilhoD(node.getFilhoE());
                    }
                } else {
                    node.getFilhoE().setPai(null);
                    root = node.getFilhoE();
                }
            }
        }
    }
    
    public int compara(Object x, Object y) {
        if (x instanceof Number) {
            double a = ((Number)x).doubleValue();
            double b = ((Number)y).doubleValue();
            if (a > b)
                return 1;
            else if (a < b)
                return -1;
            else
                return 0;
        } else {
            String a = x.toString();
            String b = y.toString();
            return a.compareTo(b);
        }
    }
}
}
