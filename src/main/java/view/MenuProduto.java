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
        System.out.println("4 - Atualizar Estoque");
        System.out.println("5 - Excluir Produto");
        System.out.println("6 - Sair");
        System.out.println("\nDigite a Opção: ");

        int opcao = entrada.nextInt();


        while (opcao != 6) {
            switch (opcao) {
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
                    this.atualizarEstoque();
                    break;
                }
                case 5: {
                    this.excluirProduto();
                    break;
                }
                default: {
                    System.out.println("\nOpção Inválida");
                }
            }

            System.out.println("\n\nSistema - Farmácia " + "\n-------- Menu Produto --------");
            System.out.println("\nOpções: ");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Consultar Produto");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Atualizar Estoque");
            System.out.println("5 - Excluir Produto");
            System.out.println("6 - Sair");
            System.out.println("\nDigite a Opção: ");

            opcao = entrada.nextInt();

        }

    }

    private void excluirProduto() throws SQLException {
        ProdutoDTO dto = new ProdutoDTO();
        System.out.print("\nInforme o código do Produto: ");
        dto.setIdProduto(entrada.nextInt());


        ControladoraProduto controladoraProduto = new ControladoraProduto();
        controladoraProduto.excluirProdutoController(dto);

    }

    private void atualizarProduto() throws SQLException {
        ProdutoDTO dto = new ProdutoDTO();
        System.out.println("\nInforme o código doproduto: ");
        dto.setIdProduto(entrada.nextInt());
        System.out.println("\nInforme o novo nome do produto: ");
        dto.setNome(entrada.next());
        System.out.println("\nInforme o novo preço: ");
        dto.setPreco(entrada.nextDouble());
        ControladoraProduto controladoraProduto = new ControladoraProduto();
        controladoraProduto.atualizarProdutoController(dto);
    }

    private void atualizarEstoque() throws SQLException {
        ProdutoDTO dto = new ProdutoDTO();
        ControladoraProduto controladoraProduto = new ControladoraProduto();
        System.out.println("\nInforme o código do produto: ");
        dto.setIdProduto(entrada.nextInt());
        System.out.println("\nInfome o quantida para adicionar ao estoque: ");
        dto.setEstoqueAtual(entrada.nextInt());

        controladoraProduto.atualizarEstoqueController(dto);
    }

    private void consultaProduto()  throws  SQLException{

        System.out.println("\nInforme o tipo de consulta a ser realizada");
        System.out.println("1 - Consultar todos os produtos");
        System.out.println("2 - Consultar um produto Específico");
        System.out.println("3 - Sair");
        System.out.println("\nDigite a opção: ");

        int opcao = entrada.nextInt();

        ControladoraProduto controladoraProduto = new ControladoraProduto();
        while (opcao != 3) {
            switch (opcao) {
                case 1: {
                    ArrayList<ProdutoDTO> produtoDTO = controladoraProduto.consultarTodosProdutosController();

                    System.out.println("\n-------- RESULTADO DA CONSULTA --------");
                    System.out.printf("ID      NOME           PREÇO    EstoqueAtual   EstoqueMinimo");

                    for (ProdutoDTO dto : produtoDTO) {
                        dto.imprimir();

                    }
                    break;
                }
                case 2: {
                    ProdutoDTO dto = new ProdutoDTO();
                    System.out.print("\nInforme o código do Produto: ");
                    dto.setIdProduto(entrada.nextInt());
                    ProdutoDTO produtoDTO = controladoraProduto.consultarTodosProdutosController(dto);
                    System.out.println("\n-------- RESULTADO DA CONSULTA --------");
                    System.out.printf("\n%3d  %-20s  %4d  %5d  %6d   \n", "ID", "NOME", "EstoqueAtual", "EstoqueMinimo", "Preco");
                    produtoDTO.imprimir();
                }
                default: {
                    System.out.println("\nOpção Inválida");
                }
            }

            System.out.println("\nInforme o tipo de consulta a ser realizada");
            System.out.println("1 - Consultar todos os produtos");
            System.out.println("2 - Consultar um produto Específico");
            System.out.println("3 - Sair");
            System.out.println("\nDigite a opção: ");
            opcao = entrada.nextInt();

        }


        System.out.println("\nProduto consultado com sucesso");


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
