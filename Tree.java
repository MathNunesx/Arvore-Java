import javax.swing.plaf.InsetsUIResource;

public class Tree {
    private No root;

    public Tree() {
        root = null;
    }

    public void inserir(long v) {
        No novo = new No();
        novo.item = v;
        novo.direita = null;
        novo.esquerda = null;

        if (root == null) root = novo;
        else {
            No atual = root;
            No anterior;
            while (true) {
                anterior = atual;
                if (v <= atual.item) {
                    atual = atual.esquerda;
                    if (atual == null) {
                        anterior.esquerda = novo;
                        return;
                    }
                } else {
                    atual = atual.direita;
                    if (atual == null) {
                        anterior.direita = novo;
                        return;
                    }
                }
            }
        }
    }

    public No busca(long posicao) {
        if (root == null) return null;
        No atual = root;
        while (atual.item != posicao) {
            if (posicao < atual.item) atual = atual.esquerda;
            else atual = atual.direita;
            if (atual == null) return null;
        }
        return atual;
    }

    public boolean remove(long valor) {
        if (root == null) return false;
        No atual = root;
        No pai = root;
        boolean filho_esquerda = true;
        while (atual.item != valor) {
            pai = atual;
            if (valor < atual.item) {
                atual = atual.esquerda;
                filho_esquerda = true;
            } else {
                atual = atual.direita;
                filho_esquerda = false;
            }
            if (atual == null) return false;
        }
        if (atual.esquerda == null && atual.direita == null) {
            if (atual == root) root = null;
            else if (filho_esquerda) pai.esquerda = null;
            else pai.direita = null;
        } else if (atual.direita == null) {
            if (atual == root) root = atual.esquerda;
            else if (filho_esquerda) pai.esquerda = atual.esquerda;
            else pai.direita = atual.esquerda;
        } else if (atual.esquerda == null) {
            if (atual == root) root = atual.direita;
            else if (filho_esquerda) pai.esquerda = atual.direita;
            else pai.direita = atual.direita;
        } else {
            No sucessor = no_sucessor(atual);
            if (atual == root) root = sucessor;
            else if (filho_esquerda) pai.direita = sucessor;
            else pai.direita = sucessor;
            sucessor.esquerda = atual.esquerda;
        }
        return true;
    }

    public No no_sucessor(No apaga) {
        No pai_do_sucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.direita;
        while (atual != null) {
            pai_do_sucessor = sucessor;
            sucessor = null;
            atual = atual.esquerda;
        }
        if (sucessor != apaga.direita) {
            pai_do_sucessor.esquerda = sucessor.direita;
            sucessor.direita = apaga.direita;
        }
        return sucessor;
    }

    public void percorrer() {
        System.out.print("\n Exibindo em ordem: " );
        inOrder(root);
        System.out.print("\n Exibindo em pos-ordem: " );
        posOrder(root);
        System.out.print("\n Exibindo em pre-ordem: " );
        preOrder(root);
        System.out.print("\n Altura da arvore: " + altura(root));
        System.out.print("\n Quantidade de folhas: " + folhas(root));
        System.out.print("\n Quantidade de Nós: " + contatNos(root));
        if (root != null) { //se a arvore não está vazia
            System.out.print("\n Valor minimo: " + min().item);
            System.out.print("\n Valor maximo: " + max().item);
        }
    }

    public void inOrder(No atual) {
        if (atual != null) {
            inOrder(atual.esquerda);
            System.out.print(atual.item + " " );
            inOrder(atual.direita);
        }
    }

    public void preOrder(No atual) {
        if (atual != null) {
            System.out.print(atual.item + " " );
            preOrder(atual.esquerda);
            preOrder(atual.direita);
        }
    }

    public void posOrder(No atual) {
        if (atual != null) {
            posOrder(atual.esquerda);
            posOrder(atual.direita);
            System.out.print(atual.item + " " );
        }
    }

    public int altura(No atual) {
        if (atual == null || (atual.esquerda == null && atual.direita == null))
            return 0;
        else {
            if (altura(atual.esquerda) > altura(atual.direita))
                return (1 + altura(atual.esquerda));
            else
                return (1 + altura(atual.direita));
        }
    }



    public int folhas(No atual) {
        if (atual == null) return 0;
        if (atual.esquerda == null && atual.direita == null) return 1;
        return folhas(atual.esquerda) + folhas(atual.direita);
    }

    public int contatNos(No atual) {
        if (atual == null) return 0;
        else return (1 + contatNos(atual.esquerda) + contatNos(atual.direita));
    }

    public No min() {
        No atual = root;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.esquerda;
        }
        return anterior;
    }

    public No max() {
        No atual = root;
        No anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.direita;
        }
        return anterior;
    }
}

