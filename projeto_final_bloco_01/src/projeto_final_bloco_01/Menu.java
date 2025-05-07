package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Componente;
import projeto_final_bloco_01.model.Periferico;
import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		ProdutoController produto = new ProdutoController();
		
		int opcao, id;
		String nome, descricao;
		int categoria;
		double preco;
		
		Componente c1 = new Componente(1, "Placa de Vídeo RTX 3060", 1, 2499.90, "12GB GDDR6 - NVIDIA");
		produto.cadastrar(c1);
		Periferico p1 = new Periferico(2, "Teclado Mecânico RGB", 2, 399.90, "USB");
		produto.cadastrar(p1);

		while (true) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED_BOLD
					+ "█▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀█");
			System.out.println("█                                                   █");
			System.out.println("█          BYTESTORE PRODUTOS TECNOLÓGICOS          █");
			System.out.println("█                                                   █");
			System.out.println("█▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀█");
			System.out.println("█                                                   █");
			System.out.println("█           1 - Cadastrar Produto                   █");
			System.out.println("█           2 - Listar todos os Produtos            █");
			System.out.println("█           3 - Buscar Produto por ID               █");
			System.out.println("█           4 - Atualizar Produto                   █");
			System.out.println("█           5 - Remover Produto                     █");
			System.out.println("█           6 - Buscar Produto pelo Nome            █");
			System.out.println("█           7 - Sair                                █");
			System.out.println("█                                                   █");
			System.out.println("█▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀█");
			System.out.println("█Entre com a opção desejada:                        █" + Cores.TEXT_RESET);

			opcao = leia.nextInt();
			leia.nextLine();

			if (opcao == 7) {
				System.out.println("\nObrigado por utilizar nosso sistema!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("Cadastro de Produto\n");

				System.out.println("Nome: ");
				nome = leia.nextLine();

				System.out.println("Categoria (1-Componente | 2-Periférico): ");
				categoria = leia.nextInt();
				leia.nextLine();

				System.out.println("Preço: ");
				preco = leia.nextDouble();
				leia.nextLine();

				System.out.println("Descrição Técnica (especificação ou conexão): ");
				descricao = leia.nextLine();

				id = produto.gerarId();

				if (categoria == 1) {
					produto.cadastrar(new Componente(id, nome, categoria, preco, descricao));
				} else if (categoria == 2) {
					produto.cadastrar(new Periferico(id, nome, categoria, preco, descricao));
				} else {
					System.out.println("Categoria inválida.");
				}

				keyPress();
			}
			case 2 -> {
				System.out.println("Lista de Produtos\n");
				produto.listarTodos();
				keyPress();
			}
			case 3 -> {
				System.out.println("Digite o ID do produto: ");
				id = leia.nextInt();
				leia.nextLine();
				produto.procurarPorId(id);
				keyPress();
			}
			case 4 -> {
				System.out.println("Digite o ID do produto que deseja atualizar: ");
				id = leia.nextInt();
				leia.nextLine();

				System.out.println("Nome: ");
				nome = leia.nextLine();

				System.out.println("Categoria (1-Componente | 2-Periférico): ");
				categoria = leia.nextInt();
				leia.nextLine();

				System.out.println("Preço: ");
				preco = leia.nextDouble();
				leia.nextLine();

				System.out.println("Descrição Técnica: ");
				descricao = leia.nextLine();

				if (categoria == 1) {
					produto.atualizar(new Componente(id, nome, categoria, preco, descricao));
				} else if (categoria == 2) {
					produto.atualizar(new Periferico(id, nome, categoria, preco, descricao));
				} else {
					System.out.println("⚠️ Categoria inválida.");
				}

				keyPress();
			}
			case 5 -> {
				System.out.println("Digite o ID do produto que deseja remover: ");
				id = leia.nextInt();
				leia.nextLine();
				produto.deletar(id);
				keyPress();
			}
			case 6 -> {
			    System.out.println("Buscar Produto por Nome\n");
			    System.out.println("Digite o nome ou parte do nome do produto: ");
			    String nomeBusca = leia.nextLine();

			    produto.procurarPorNome(nomeBusca);

			    keyPress();
			}
			default -> System.out.println("\nOpção Inválida!\n");
			}
		}
	}

	private static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.err.println("Erro ao aguardar tecla: " + e.getMessage());
		}
	}

	public static void sobre() {
		System.out.println("\n***********************************************************");
		System.out.println("Projeto E-commerce desenvolvido por: Felipe da Silva Peronica Ferreira");
		System.out.println("Email: felipeperonica@gmail.com");
		System.out.println("GitHub: https://github.com/feperonica/");
		System.out.println("***********************************************************");
	}
}
