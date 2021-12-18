package br.com.work.ToWork.Spring.boot.listaObj;

public class PilhaObj<T> {

    // Atributos
    private T[] pilha;
    private int topo;

    // Construtor
    public PilhaObj(int capacidade) {
        pilha = (T[]) new Object[capacidade];
        topo = -1;
    }

    // Métodos
    public Boolean isEmpty() {
        return topo == -1;
    }

    public Boolean isFull() {
        return topo == pilha.length - 1;
    }

    public void push(T info) {
        if (isFull()) {
            System.out.println("Pilha cheia!");
        } else {
            pilha[++topo] = info;
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null; // Antes aqui era -1, mas com a alteração do int para o T precisei por null
        }
        return pilha[topo--];
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo];
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.println(pilha[i]);
            }
        }
    }

    public PilhaObj<T> multiPop(int num) {
        if (pilha.length < num) {
            return null;
        }
        PilhaObj<T> pilhaMultiPop = new PilhaObj<>(num);
        for (int i = 0; i < num; i++) {
            pilhaMultiPop.push(pilha[topo--]);
        }
        return pilhaMultiPop;
    }

    public void multiPush(PilhaObj<T> aux) {
        while (!aux.isEmpty()) {
            pilha[++topo] = aux.pop();
        }
    }
}