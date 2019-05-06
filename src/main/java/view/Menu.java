package view;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
	
	Scanner entrada = new Scanner(System.in);

	public void apresentaMenu() throws SQLException	 {
		
		System.out.println("Sistema - Farmácia Senac");
		System.out.println("\nOpções:");
		System.out.println("1 - Menu Cliente");
		System.out.println("2 - Menu Produto ");
		System.out.println("3 - Sair");
		System.out.println("\nDigite a Opção:");
			
		int opcao = entrada.nextInt();
		
		while(opcao != 3 ){
			switch(opcao){
				case 1:{
					MenuCliente menuCliente = new MenuCliente();
					menuCliente.apresentaMenuCliente();
					break;
					
				}
				case 2:{
					MenuProduto menuProduto = new MenuProduto();
					menuProduto.apresentaMenuProduto();
					break;
					
				}
				default:{
					System.out.println("\nOpção Inválida.");
			}	
				
		}
			System.out.println("Sistema - Farmácia Senac");
			System.out.println("\nOpções:");
			System.out.println("1 - Menu Cliente");
			System.out.println("2 - Menu Produto ");
			System.out.println("3 - Sair");
			System.out.println("\nDigite a Opção:");
			
			opcao = entrada.nextInt();
		}
		
	}

}
