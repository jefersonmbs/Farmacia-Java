package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraCliente;

public class MenuCliente {

    Scanner entrada = new Scanner(System.in);


    public void apresentaMenuCliente() throws SQLException {

        System.out.println("\n\nSistema - Farmácia Senac" + "\n-------- Menu Cliente --------");
        System.out.println("\nOpções: ");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Consultar Cliente");
        System.out.println("3 - Atualizar Cliente");
        System.out.println("4 - Excluir Cliente");
        System.out.println("5 - Sair");
        System.out.println("\nDigite a Opção: ");

        int opcao = entrada.nextInt();


        while (opcao != 5) {
            switch (opcao) {
                case 1: {
                    this.cadastrarCliente();
                    break;
                }
                case 2: {
                    this.consultaCliente();
                    break;
                }
                case 3: {
                    this.atualizarCliente();
                    break;
                }
                case 4: {
                    this.excluirCliente();
                    break;
                }
                default: {
                    System.out.println("\nOpção Inválida");
                }
            }

            System.out.println("\n\nSistema - Farmácia Senac" + "\n-------- Menu Cliente --------");
            System.out.println("\nOpções: ");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Consultar Cliente");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Excluir Cliente");
            System.out.println("5 - Sair");
            System.out.println("\nDigite a Opção: ");

            opcao = entrada.nextInt();

        }
    }

    private void cadastrarCliente() throws SQLException {
        entrada.nextLine();
        ClienteDTO dto = new ClienteDTO();
        System.out.print("\nDigite o seu nome: ");
        dto.setNome(entrada.nextLine());
        System.out.println("\nDigite seu CPF:");
        dto.setCpf(entrada.nextLine());

        ControladoraCliente controladoraCliente = new ControladoraCliente();
        controladoraCliente.cadastrarClienteController(dto);


    }

    private void consultaCliente() throws SQLException {

        System.out.println("\nInforme o tipo de consulta a ser realizada");
        System.out.println("1 - Consultar todos os Clientes");
        System.out.println("2 - Consultar um Cliente Específico");
        System.out.println("3 - Sair");
        System.out.println("\nDigite a opção: ");
        int opcao = entrada.nextInt();

        ControladoraCliente controladoraCliente = new ControladoraCliente();
        while (opcao != 3) {
            switch (opcao) {
                case 1: {
                    ArrayList<ClienteDTO> clienteDTO = controladoraCliente.consultarTodosClientesController();

                    System.out.println("\n-------- RESULTADO DA CONSULTA --------");
                    System.out.printf("\n%3s  %-20s  %-30s  \n", "ID", "NOME", "CPF");

                    for (ClienteDTO dto : clienteDTO) {
                        dto.imprimir();

                    }
                    break;
                }
                case 2: {
                    ClienteDTO dto = new ClienteDTO();
                    System.out.print("\nInforme o código do Cliente: ");
                    dto.setIdCliente(entrada.nextInt());
                    ArrayList<ClienteDTO> clienteDTO = controladoraCliente.consultarClientesController(dto);
                    System.out.println("\n-------- RESULTADO DA CONSULTA --------");
                    System.out.printf("\n%3s  %-20s  %-30s  \n", "ID", "NOME", "CPF");
                    for (ClienteDTO value : clienteDTO) {
                        value.imprimir();
                    }
                }
                default: {
                    System.out.println("\nOpção Inválida");
                }
            }
            System.out.println("\nInforme o tipo de consulta a ser realizada");
            System.out.println("1 - Consultar todos os Clientes");
            System.out.println("2 - Consultar um Cliente Específico");
            System.out.println("3 - Sair");
            System.out.println("\nDigite a opção: ");
            opcao = entrada.nextInt();

        }


        System.out.println("\nCliente consultado com sucesso");


    }

    private void atualizarCliente() throws SQLException {


        ClienteDTO dto = new ClienteDTO();
        System.out.print("\nInforme o código do Cliente: ");
        dto.setIdCliente(entrada.nextInt());
        entrada.nextLine();
        System.out.print("\nDigite o seu nome: ");
        dto.setNome(entrada.nextLine());
        System.out.println("\nDigite seu CPF:");
        dto.setCpf(entrada.nextLine());

        ControladoraCliente controladoraCliente = new ControladoraCliente();
        controladoraCliente.atualizarClienteController(dto);


    }

    private void excluirCliente() throws SQLException {

        ClienteDTO dto = new ClienteDTO();
        System.out.print("\nInforme o código do Cliente: ");
        dto.setIdCliente(entrada.nextInt());

        ControladoraCliente controladoraCliente = new ControladoraCliente();
        controladoraCliente.excluirClienteController(dto);


    }


}
