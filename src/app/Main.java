package app;

import model.Produto;
import repository.ProdutoRepository;
import repository.ProdutoRepositoryMemory;

import java.util.Scanner;

public class Main {
    public static String atribuirCategoria(boolean verificadorCategoria) {
        Scanner input = new Scanner(System.in);
        String categoria = "";
        while (verificadorCategoria == false) {
            System.out.println("\nEscolha a categoria que mais se encaixa:");
            System.out.println("====================");
            System.out.println("---Alimenticio--- 1");
            System.out.println("---Eletronico--- 2");
            System.out.println("---Limpeza--- 3");
            int opcaoCategoria = input.nextInt();
            input.nextLine();

            switch (opcaoCategoria) {
                case 1: {
                    categoria = "Alimenticio";
                    verificadorCategoria = true;
                    break;
                }
                case 2: {
                    categoria = "Eletronico";
                    verificadorCategoria = true;
                    break;
                }
                case 3: {
                    categoria = "Limpeza";
                    verificadorCategoria = true;
                    break;
                }
                default: {
                    System.out.println("Item não aceito");
                    break;
                }
            }
        }
        return categoria;
    }

    public static void main(String[] args) {

        ProdutoRepository repo = new ProdutoRepositoryMemory();
        Scanner input = new Scanner(System.in);
        boolean ativo = true;
        while (ativo) {
            System.out.println("===Cadastrar produto=== 1 ");
            System.out.println("===Listar Produtos cadastrados=== 2 ");
            System.out.println("===Busque Produtos cadastrados=== 3 ");
            System.out.println("===Sair=== 0 ");
            System.out.println("Digite o numero da opcao desejada");
            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o nome do produto!");
                    String nome = input.nextLine();

                    boolean verificadorCategoria = false;
                    String categoria = atribuirCategoria(verificadorCategoria);

                    System.out.println("Digite o presso!");
                    double preco = input.nextDouble();

                    System.out.println("Digite a quantidade");
                    int quantidade = input.nextInt();
                    input.nextLine();
                    Produto newprod = new Produto(nome, categoria, preco, quantidade);
                    try {
                        repo.salvarProduto(newprod);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    try {
                        for (Produto produto : repo.listarTodos()) {
                            System.out.println(produto);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3:{
                    System.out.println("Digite o Id do produto a ser pesquisado");
                    try {
                        int idbusca=input.nextInt();
                        System.out.println(repo.buscarPorId(idbusca));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 0: {
                    ativo = false;
                    break;
                }
                default: {
                    System.out.println("Opcao invalida");
                }
            }

        }
    }
}