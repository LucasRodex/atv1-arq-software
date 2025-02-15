package com.atv1.ArqSoftware;


import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.atv1.ArqSoftware.entities.Produto;
import com.atv1.ArqSoftware.services.ProdutoService;

@SpringBootApplication
public class Atv1ArqSoftwareApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Atv1ArqSoftwareApplication.class, args);
        ProdutoService produtoService = context.getBean(ProdutoService.class);
        
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int opcao = 0;
        
        do {
            System.out.println("----- Gerenciamento de Produtos -----");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    
                    Produto produto = new Produto(nome, preco);
                    produtoService.cadastrarProduto(produto);
                    System.out.println("Produto cadastrado com sucesso.");
                    break;
                
                case 2:
                    List<Produto> produtos = produtoService.obterTodosProdutos();
                    System.out.println("----- Lista de Produtos -----");
                    for (Produto p : produtos) {
                        System.out.println(p);
                    }
                    break;
                
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        } while (opcao != 0);
        
        scanner.close();
    }
}
