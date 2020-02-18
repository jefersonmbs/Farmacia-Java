package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO {

    public void cadastrarClienteBO(ClienteVO clienteVO) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        if (clienteDAO.existeRegistroPorCpf(clienteVO.getCpf())) {
            System.out.println("\nCliente já cadastrado!");
        } else {
            int resultado = clienteDAO.cadastrarClienteDAO(clienteVO);
            if (resultado == 1) {
                System.out.println("\nCliente cadastrado com int Sucesso!");
            } else {
                System.out.println("\nNão foi possível cadastrar o Cliente!!");


            }
        }


    }

    public void excluirClienteBO(ClienteVO clienteVO) throws SQLException {

        ClienteDAO clienteDAO = new ClienteDAO();
        if (clienteDAO.existeRegistroPorCliente(clienteVO.getIdCliente())) {
            int resultado = clienteDAO.excluirClienteDAO(clienteVO);
            if (resultado == 1) {
                System.out.println("\nCliente excluído com Sucesso!");
            } else {
                System.out.println("\nnão foi possivel cadastrar Cliente!");
            }
        } else {
            System.out.println("\nCliente não existe.");
        }


    }

    public void atulizarClienteBO(ClienteVO clienteVO) throws SQLException {

        ClienteDAO clienteDAO = new ClienteDAO();
        if (clienteDAO.existeRegistroPorCliente(clienteVO.getIdCliente())) {
            int resultado = clienteDAO.atualizarClienteDAO(clienteVO);
            if (resultado == 1) {
                System.out.println("\nCliente atualizado com Sucesso!");
            } else {
                System.out.println("\nNão foi possivel atualizar Cliente!");
            }
        } else {
            System.out.println("\nCliente não existe.");
        }


    }

    public ArrayList<ClienteVO> consultarTodosClientesBO() throws SQLException {

        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<ClienteVO> clientesVO = clienteDAO.consultarTodosClientesDAO();
        if (clientesVO.isEmpty()) {
            System.out.println("\nLista de Clientes não Localizada!");
        }
        return clientesVO;
    }

    public ArrayList<ClienteVO> consultarClienteBO(ClienteVO clienteVO) throws SQLException {

        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<ClienteVO> resultado = clienteDAO.consultarClienteDAO(clienteVO);

        if (resultado.isEmpty()) {
            System.out.println("\nCliente não Localizado!");
        }
        return resultado;
    }


}
