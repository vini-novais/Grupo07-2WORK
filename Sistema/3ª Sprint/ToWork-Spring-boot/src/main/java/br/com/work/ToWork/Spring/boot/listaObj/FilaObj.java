package br.com.work.ToWork.Spring.boot.listaObj;

public class FilaObj<T> {

    // Atributos
    private T[] fila;
    private int tamanho;

    // Construtor
    public FilaObj(Integer capacidade) {
        fila = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    // Métodos

    public Boolean isEmpty() {
        return tamanho == 0;
    }

    public Boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(T info) {
        if (isFull()) {
            System.out.println("Fila cheia!");
        } else {
            fila[tamanho++] = info;
        }
    }

    public T poll() {
        T guardaValor = fila[0];
        if (!isEmpty()) {
            for (int i = 0; i < tamanho - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[tamanho - 1] = null;
            tamanho--;
        }
        return guardaValor;
    }

    public T peek() {
        return fila[0];
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("A fila está vazia");
        } else {
            for (int i = 0; i < tamanho; i++) {
                System.out.print(i + 1 + "º da fila: ");
                System.out.println(fila[i]);
                if (i == tamanho) {
                    fila[i] = null;
                }
            }
        }
    }
}