

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jean Jacques N. Shimwa
 * @created 14-09-2022 - 2:23 PM
 */
public class Arvore<T extends Comparable<? super T>> {

    private No<T> raiz;

    Arvore() {
        raiz = null;
    }

    public No<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(No<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }
    public boolean estaNulo(No<T> no){
        return no==null;
    }

    public int tamanho() {
        return tamanho(raiz);
    }

    //    método recursivo que retorna o número de nós de uma árvore
    private int tamanho(No<T> raiz) {
        if (raiz == null)
            return 0;
        else
            return 1 + tamanho(raiz.getEsquerda()) + tamanho(raiz.getDireita());
    }

    public int profundidade() {
        return profundidade(raiz);
    }

    //    metodo recursivo que calcula a profundidade de uma árvore
    private int profundidade(No<T> raiz) {
        if (raiz == null)
            return -1;
        else
            return 1 + Math.max(profundidade(raiz.getEsquerda()), profundidade(raiz.getDireita()));
    }

    public boolean contem(T valor) {
        return contem(raiz, valor);
    }

    //    metodo que pesquisa ou procura de um elemento na árvore
    private boolean contem(No<T> raiz, T valor) {
        if (raiz == null)
            return false;
        if (valor.compareTo(raiz.getValor()) < 0) //menor? sub-árvore esquerda
            return contem(raiz.getEsquerda(), valor);
        if (valor.compareTo(raiz.getValor()) > 0) //maior? sub-árvore direita
            return contem(raiz.getDireita(), valor);
        return true; //se não é menor ou maior, é porque é igual
    }
    //   pesquisa em profundidade

    public void imprimirPreOrdem() {
        System.out.print("PreOrdem :");
        imprimirPreOrdem(raiz);
        System.out.println();
    }

    //  metodo que faz uma pesquisa em pre ordem, isto é, primeiro escreve a raiz antes das duas subárvores
    private void imprimirPreOrdem(No<T> raiz) {
        if (raiz == null) return;
        System.out.print(" " + raiz.getValor());
        imprimirPreOrdem(raiz.getEsquerda());
        imprimirPreOrdem(raiz.getDireita());
    }

    public void imprimirEmOrdem() {
        System.out.print("Em Ordem: ");
        imprimirEmOrdem(raiz);
        System.out.println();
    }

    //  metodo que faz uma pesquisa em ordem, isto é, a raiz é escrita entre as duas subárvores
    private void imprimirEmOrdem(No<T> raiz) {
        if (raiz == null)
            return;
        imprimirEmOrdem(raiz.getEsquerda());
        System.out.print(" " + raiz.getValor());
        imprimirEmOrdem(raiz.getDireita());
    }

    public void imprimirPosOrdem() {
        System.out.print("Pos Ordem: ");
        imprimirPosOrdem(raiz);
        System.out.println();
    }

    //  metodo que faz uma pesquisa em Pos ordem, isto é, a raiz é escrita depois duas subárvores
    private void imprimirPosOrdem(No<T> raiz) {
        if (raiz == null)
            return;
        imprimirPosOrdem(raiz.getEsquerda());
        imprimirPosOrdem(raiz.getDireita());
        System.out.print(" " + raiz.getValor());
    }

    //  Pesquisa em Largura utilizando filas
    public void imprimirEmLargura() {
        System.out.print("Em Largura");
        Queue fila = new LinkedList<No<T>>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            No<T> corente = (No<T>) fila.remove();
            if (corente != null) {
                System.out.print(" " + corente.getValor());
                fila.add(corente.getEsquerda());
                fila.add(corente.getDireita());
            }
        }
        System.out.println();

    }

    //  Pesquisa em profundidade utilizando pilhas
    public void imprimirEmProfundidade() {
        System.out.print("Imprensao em Profundidade");
        Stack<No<T>> pilha = new Stack<No<T>>();
        pilha.push(raiz);
        while (!pilha.isEmpty()) {
            No<T> corente = pilha.pop();
            if (corente != null) {
                System.out.print(" " + corente.getValor());
                pilha.push(corente.getEsquerda());
                pilha.push(corente.getDireita());
            }
        }
        System.out.println();
    }

    //   Adiciona elemento a uma árvore de pesquisa
//    Devolve true se conseguir inserir, false caso contrário
    public boolean inserir(T valor) {
        if (contem(valor)) return false;
        raiz = inserir(raiz, valor);
        return true;
    }

    private No<T> inserir(No<T> raiz, T valor) {
        if (raiz == null)
            return new No<T>(valor, null, null);
        else if (valor.compareTo(raiz.getValor()) < 0)
            raiz.setEsquerda(inserir(raiz.getEsquerda(), valor));
        else if (valor.compareTo(raiz.getValor()) > 0)
            raiz.setDireita(inserir(raiz.getDireita(), valor));
        return raiz;
    }

    //    Remover elemento de uma árvore de pesquisa
//    Devolve true se conseguiu remover, false caso contrário
    public boolean remover(T valor) {
        if (!contem(valor)) return false;
        raiz = remover(raiz, valor);
        return true;
    }

    private No<T> remover(No<T> raiz, T valor) {
        if (valor.compareTo(raiz.getValor()) < 0)
            raiz.setEsquerda(remover(raiz.getEsquerda(), valor));
        else if (valor.compareTo(raiz.getValor()) > 0)
            raiz.setDireita(remover(raiz.getDireita(), valor));
        else if (raiz.getEsquerda() == null) raiz = raiz.getDireita(); // Sem filho esquerda
        else if (raiz.getDireita() == null) raiz = raiz.getEsquerda(); //Sem filho a direita
        else {
            No<T> maximo = raiz.getEsquerda();
            while (maximo.getDireita() != null) maximo = maximo.getDireita();
            raiz.setValor(maximo.getValor()); //Subistitui valor removido
            raiz.setEsquerda(remover(raiz.getEsquerda(), maximo.getValor()));
        }
        return raiz;
    }
    

    public void imprimirFolhas(){
        System.out.print("Nós folha: ");
        imprimirFolhas(this.raiz);
        System.out.println();
    }

    private void imprimirFolhas(No<T> raiz){
        if(estaNulo(raiz)) return;

        if(folha(raiz))
            System.out.print(raiz.getValor()+" ");

        imprimirFolhas(raiz.getEsquerda());
        imprimirFolhas(raiz.getDireita());
    }

    private boolean folha(No<T> raiz){
        return raiz.getDireita()==null && raiz.getEsquerda()==null? true : false;
    }
    

}
