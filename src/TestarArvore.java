import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Jean Jacques N. Shimwa
 * @author Dava, Rafael
 * @author Cumbane, Malingas
 * @author Dima, Valdemiro
 * @author Zengeni, Kevin
 * @created 14-09-2022 - 4:12 PM
 */
public class TestarArvore {

    public static void main(String[] args) {
        //Criação da Árvore
        Arvore<Integer> inteiros = new Arvore<>();
        int[] dados = {14, 4, 18, 3, 9, 16, 20, 7, 15, 17, 5};
        for (int i = 0; i < dados.length; i++) inteiros.inserir(dados[i]);

        System.out.println();
        System.out.println("                              ÁRVORE BINÁRIA NO ESTADO INICIAL            ");
        System.out.println();
        ImprimirArvore.print(inteiros.getRaiz());
        System.out.println();
//        Escrever resultado de chamada a alguns métodos
        System.out.println("Tamanho = " + inteiros.tamanho());
        System.out.println("Profundidade = " + inteiros.profundidade());
        System.out.println("tem(2) = " + inteiros.contem(2));
        System.out.println("tem(3) = " + inteiros.contem(3));
        System.out.println();

//  Escrever nós da árvore seguindo várias ordens possíveis
        inteiros.imprimirPreOrdem();
        inteiros.imprimirEmOrdem();
        inteiros.imprimirPosOrdem();
        inteiros.imprimirEmLargura();
        inteiros.imprimirFolhas();
        System.out.println();



//        Experimentando remoção
        System.out.println("Depois da remoção do 14 na arvore");
        inteiros.remover(4);

        //  Rescrever nós da árvore seguindo várias ordens possíveis
        inteiros.imprimirPreOrdem();
        inteiros.imprimirEmOrdem();
        inteiros.imprimirPosOrdem();
        inteiros.imprimirEmLargura();
        inteiros.imprimirFolhas();
        System.out.println();

        System.out.println("                              ÁRVORE BINÁRIA NO ESTADO FINAL            ");
        System.out.println();
       ImprimirArvore.print(inteiros.getRaiz());
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
