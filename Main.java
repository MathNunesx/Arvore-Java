import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Tree arvore = new Tree();
        int opcao;
        long x;
        System.out.println("\n Programa de Ávore binária de Long");
        do{
            System.out.println("\n************************************************");
            System.out.println("\n Entre com a Opção: ");
            System.out.println("\n ----> 1: Inserir");
            System.out.println("\n ----> 2: Excluir");
            System.out.println("\n ----> 3: Pesquisar");
            System.out.println("\n ----> 4: Exibir");
            System.out.println("\n ----> 5: Sair do Programa");
            System.out.println("\n************************************************");
            System.out.println("\n-> ");
            opcao = ler.nextInt();
            switch (opcao){
                case 1 -> {
                    System.out.println("\n Informe o valor (long) ->");
                    x = ler.nextLong();
                    arvore.inserir(x);
                }
                case 2 -> {
                    System.out.println("\n Informe o valor (long) ->");
                    x = ler.nextLong();
                    if(!arvore.remove(x))
                        System.out.println("\n valor não encontrado!! ");
                }
                case 3 -> {
                    System.out.println("\n Informe o valor (long) -> ");
                    x = ler.nextLong();
                    if(arvore.busca(x) != null)
                        System.out.println("\n Valor Encontrado");
                    else
                        System.out.println("\n Valor não Encontrado!!");
                }
                case 4 -> {
                    arvore.percorrer();
                }
            }
        } while (opcao != 5);
    }
}
