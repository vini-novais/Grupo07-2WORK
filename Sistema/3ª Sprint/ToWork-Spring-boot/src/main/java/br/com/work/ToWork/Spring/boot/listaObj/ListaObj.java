package br.com.work.ToWork.Spring.boot.listaObj;

import br.com.work.ToWork.Spring.boot.dominio.Iterator;

public class ListaObj<T> implements Iterator<T> {

    // O <T> e o (T[]) é o chamado Casting
    // Casting é usado para que uma variável seja vista como sendo de outro tipo
    // int x = 1;
    // int Y = 2;
    // double resultado = 0;
    // resultado = (double) a/b; "Senão daria 0 por serem 2 numeros inteiros"

    // Atributos
    private T[] vetor;
    private Integer nroElem;
    private Integer posicao = 0;

    // Construtor
    public ListaObj(Integer tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        this.nroElem = 0;
    }

    // Métodos
    public Boolean adiciona(T elemento) {
        System.out.println();
        if (nroElem < vetor.length) {
            vetor[nroElem++] = (T) elemento;
            System.out.printf("Elemento %s adicionado! \n", elemento);
            return true;
        } else {
            System.out.println("Lista cheia!");
            return false;
        }
    }

    public void exibe() {
        System.out.println();
        for (int i = 0; i < (nroElem); i++) {
            System.out.println(vetor[i] + "\n");
        }
    }

    public Integer busca(T elemento) {
        Integer guardarIndice = -1;
        for (int i = 0; i < (nroElem); i++) {
            if (vetor[i].equals(elemento)) {
                System.out.println();
                System.out.print("Elemento foi encontrado:  " + vetor[i] + "\t");
                guardarIndice = i;
                return guardarIndice;
            }
        }
        System.out.println();
        System.out.println("Indice encontrado: " + guardarIndice);
        return guardarIndice;
    }

    public Boolean removerPeloIndice(int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("Indice inválido");
            return false;
        } else {
            Boolean removeu = false;
            for (int i = indice; i < (nroElem - 1); i++) {
                vetor[i] = vetor[i + 1];
                removeu = true;
            }
            nroElem -= 1;
            if (removeu) {
                System.out.println("Removeu pelo índice");
                return true;
            } else {
                System.out.println("Não removeu pelo índice");
                return false;
            }
        }
    }

    public Boolean removeElemento(T elemento) {
        if (removerPeloIndice(busca(elemento))) {
            System.out.println("Removeu pelo elemento");
            return true;
        } else {
            System.out.println("Não removeu pelo elemento");
            return false;
        }
    }

    public Integer getTamanho() {
        // System.out.println();
        // System.out.println("O tamanho da lista é de: " + nroElem + " elementos.");
        return nroElem;
    }

    public T getElemento(Integer indice) {
        if (indice < 0 || indice >= nroElem) {
            // System.out.println("Indice inválido!");
            return null;
        } else {
            // System.out.println("Indice válido!");
            // System.out.println(vetor[indice]);
            return vetor[indice];
        }
    }

    public void limpa() {
        System.out.println();
        nroElem = 0;
        System.out.println("Lista limpa com sucesso!");
    }

    public Object next() {
        T usuario = vetor[posicao];
        posicao++;
        return usuario;
    }

    public Boolean hasNext() {
        if (posicao >= vetor.length || vetor[posicao] == null) {
            return false;
        } else {
            return true;
        }
    }
}