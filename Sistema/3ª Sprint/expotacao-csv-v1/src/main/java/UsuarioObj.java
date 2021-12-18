//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class UsuarioObj<T> {
    private T[] vetor;
    private int nroElem;

    public UsuarioObj(int tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        this.nroElem = 0;
    }

    public boolean adiciona(T elemento) {
        if (this.nroElem >= this.vetor.length) {
            System.out.println("Lista está cheia");
            return false;
        } else {
            this.vetor[this.nroElem++] = elemento;
            return true;
        }
    }

    public void exibe() {
        if (this.nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        } else {
            System.out.println("\nElementos da lista:");

            for (int i = 0; i < this.nroElem; ++i) {
                System.out.println(this.vetor[i]);
            }
            System.out.println();
        }
    }

    public int busca(T elementoBuscado) {
        for (int i = 0; i < this.nroElem; ++i) {
            if (this.vetor[i].equals(elementoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice >= 0 && indice < this.nroElem) {
            for (int i = indice; i < this.nroElem - 1; ++i) {
                this.vetor[i] = this.vetor[i + 1];
            }
            --this.nroElem;
            return true;
        } else {
            System.out.println("\nÍndice inválido!");
            return false;
        }
    }

    public boolean removeElemento(T elementoARemover) {
        return this.removePeloIndice(this.busca(elementoARemover));
    }

    public int getTamanho() {
        return this.nroElem;
    }

    public T getElemento(int indice) {
        return indice >= 0 && indice < this.nroElem ? this.vetor[indice] : null;
    }

    public void limpa() {
        this.nroElem = 0;
    }
}