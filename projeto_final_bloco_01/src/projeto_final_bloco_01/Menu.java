package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

import projeto_final_bloco_01.model.Componente;
import projeto_final_bloco_01.model.Periferico;
import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		int opcao;
		
		Componente c1 = new Componente(1, "Placa de Vídeo RTX 3060", 1, 2499.90, "12GB GDDR6 - NVIDIA");
		c1.visualizar();
		System.out.println("---------------------------------------");
		Periferico p1 = new Periferico(2, "Teclado Mecânico RGB", 2, 399.90, "USB");
		p1.visualizar();

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
			System.out.println("█           6 - Comprar Produto                     █");
			System.out.println("█           7 - Sair                                █");
			System.out.println("█                                                   █");
			System.out.println("█▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀█");
			System.out.println("█Entre com a opção desejada:                        █");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();
			
			leia.nextLine();

			if (opcao == 7) {
				System.out.println("\nObrigado por utilizar nosso sistema!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Produto\n\n");
				
				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");
				
				keyPress();
				break;
			case 3:
				System.out.println("Buscar Produto por ID\n\n");
				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Produto\n\n");
				
				keyPress();
				break;
			case 5:
				System.out.println("Remover Produto\n\n");
				
				keyPress();
				break;
			case 6:
				System.out.println("Comprar Produto\n\n");
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

	private static void keyPress() {
		
		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.err.println("Ocorreu um erro ao tentar ler o teclado");

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
