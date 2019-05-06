package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraCliente;
import controller.ControladoraProduto;



public class MenuProduto {
	
	
	Scanner entrada = new Scanner(System.in);

	public void apresentaMenuProduto() throws SQLException {
		
		System.out.println("\n\nSistema - Farmácia" + "\n-------- Menu Produto --------");
		System.out.println("\nOpções: ");
		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Consultar Produto");
		System.out.println("3 - Atualizar Produto");
		System.out.println("4 - Excluir Produto");
		System.out.println("5 - Sair");
		System.out.println("\nDigite a Opção: ");
		
		int opcao  = entrada.nextInt();
		
		
	

	
	while(opcao != 5) {
		switch(opcao){
		case 1: {
			this.cadastrarProduto();
			break;
		}
		case 2: {
			this.consultaProduto();
			break;
		}
		case 3: {
			this.atualizarProduto();
			break;
		}
		case 4: {
			this.excluirProduto();
			break;
		}
		default:{
			System.out.println("\nOpção Inválida");
		}
		}
		
		System.out.println("\n\nSistema - Farmácia " + "\n-------- Menu Produto --------");
		System.out.println("\nOpções: ");
		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Consultar Produto");
		System.out.println("3 - Atualizar Produto");
		System.out.println("4 - Excluir Produto");
		System.out.println("5 - Sair");
		System.out.println("\nDigite a Opção: ");
		
		opcao  = entrada.nextInt();
		
	}
		
	}

	private void excluirProduto() {
		ProdutoDTO dto = new ProdutoDTO();
		System.out.print("\nInforme o código do Produto: ");
		dto.setIdProduto(entrada.nextInt());
		

		ControladoraProduto controladoraProduto = new ControladoraProduto();
		controladoraProduto.excluirProdutoController(dto);
		
	}

	private void atualizarProduto() {
		ProdutoDTO dto = new ProdutoDTO();
		System.out.println("\nInforme o código doproduto: ");
		
		ControladoraProduto controladoraProduto = new ControladoraProduto();
		controladoraProduto.atualizarProdutoController(dto);
		
				
		
	}

	private void consultaProduto() {
		System.out.println("\n\n\n\n\n==========Sistema - Farmácia ===============" + "\n-------- Menu Cliente --------");
		System.out.println("\nOpções: ");
		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Consultar Produto");
		System.out.println("3 - Atualizar Produto");
		System.out.println("4 - Excluir Produto");
		System.out.println("5 - Sair");
		System.out.println("\nDigite a Opção: ");
		
		int opcao  = entrada.nextInt();
		
		ControladoraProduto controladoraProduto = new ControladoraProduto();
		while(opcao!= 5){
			switch(opcao){
			case 1:{
				ArrayList<ProdutoDTO> produtoDTO = controladoraProduto.consultarTodosProdutosController();
				
				System.out.println("\n-------- RESULTADO DA CONSULTA --------");
				System.out.printf("\n%3d  %-20s  %4d  %5d  %6d  ", "ID" , "NOME" , "EstoqueAtual", "EstoqueMinimo" ,"Preco" );
				
				
				for(int i = 0;i < produtoDTO.size();i++){
					produtoDTO.get(i).imprimir();
					
				}
				break;
			}
			case 2:{
				ProdutoDTO dto = new ProdutoDTO();
				System.out.print("\nInforme o código do Produto: ");
				dto.setIdProduto(entrada.nextInt());
				ProdutoDTO produtoDTO = controladoraProduto.consultarTodosProdutosController(dto);	
				System.out.println("\n-------- RESULTADO DA CONSULTA --------");
				System.out.printf("\n%3d  %-20s  %4d  %5d  %6d   \n", "ID" , "NOME" , "EstoqueAtual", "EstoqueMinimo" ,"Preco" );
				produtoDTO.imprimir();
			}
			case 3:{
				ProdutoDTO dto = new ProdutoDTO();
				System.out.print("\nInforme o código do Produto: ");
				dto.setIdProduto(entrada.nextInt());
				entrada.nextLine();
				System.out.println("\nDigite o nome do produto: ");
				dto.setNome(entrada.nextLine());
				System.out.println("\nDigite o valor do protudo: ");
				dto.setPreco(entrada.nextDouble());
				
				
				
				ControladoraProduto controladoraProduto2 = new ControladoraProduto();
				controladoraProduto2.atualizarProdutoController(dto);
				
				
				
			}
			default:{
				System.out.println("\nOpção Inválida");
			}
			}
			System.out.println("\nInforme o tipo de consulta a ser realizada");
			System.out.println("1 - Consultar todos os Clientes");
			System.out.println("2 - Consultar um Cliente Específico");
			System.out.println("3 - Sair");
			System.out.println("\nDigite a opção: ");
			
		}
		
		
		System.out.println("\nCliente consultado com sucesso");

		
		
	}

	private void cadastrarProduto() throws SQLException {
		entrada.nextLine();
		ProdutoDTO dto = new ProdutoDTO();
		System.out.print("\nDigite o seu nome do produto: ");
		dto.setNome(entrada.nextLine());
		System.out.println("\nDigite o valor do Produto:");
		dto.setPreco(entrada.nextDouble());
		System.out.println("\nDigite o estoque atual:");
		dto.setEstoqueAtual(entrada.nextInt());
		System.out.println("\nDigite o estoque minimo:");
		dto.setEstoqueMinimo(entrada.nextInt());

		
		
		
		ControladoraProduto controladoraProduto = new ControladoraProduto();
		controladoraProduto.cadastrarProdutoController(dto);
	
		
	}
	


}
