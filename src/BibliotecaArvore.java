import java.util.Scanner;

/**
 * @author Jean Jacques N. Shimwa
 * @author Dava, Rafael
 * @author Cumbane, Malingas
 * @author Dima, Valdemiro
 * @author Zengeni, Kevin
 * @created 14-09-2022 - 4:06 PM
 */
public class BibliotecaArvore {
    public static Arvore<Integer> lerArvoreInteiro(Scanner in){
        Arvore<Integer> arvore= new Arvore<Integer>();
        arvore.setRaiz(lerNoInteiro(in));
        return arvore;
    }
    private static No<Integer> lerNoInteiro(Scanner in){

        String texto=in.next();
        if (texto.equals("N"))
            return null;
        Integer valor= Integer.parseInt(texto);
        No<Integer> esquerda = lerNoInteiro(in);
        No<Integer> direita= lerNoInteiro(in);

        return new No<Integer>(valor,esquerda,direita);
    }
}
