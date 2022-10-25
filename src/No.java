/**
 * @author Jean Jacques N. Shimwa
 * @author Dava, Rafael
 * @author Cumbane, Malingas
 * @author Dima, Valdemiro
 * @author Zengeni, Kevin
 * @created 14-09-2022 - 2:16 PM
 */
public class No<T extends Comparable<? super T>> {

    private T valor;
    private No<T> esquerda;
    private No<T> direita;

    No(T valor, No<T> esquerda, No<T> direita) {
        this.valor = valor;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public T getValor() {
        return valor;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }


}
