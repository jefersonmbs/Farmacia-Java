package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.vo.ClienteVO;
import view.ClienteDTO;

public class ClienteDAO {

    public boolean existeRegistroPorCpf(String cpf) throws SQLException {
        Connection conn = Banco.getConnection();
        ResultSet resultados = null;

        String query = "SELECT * FROM cliente WHERE cpf =?";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, cpf);
        try {
            resultados = stmt.executeQuery();
            if (resultados.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a verificação por CPF.");
            return true;
        }
        stmt.close();
        return false;
    }

    public int cadastrarClienteDAO(ClienteVO clienteVO) throws SQLException {
        Connection conn = Banco.getConnection();
        String query = "INSERT INTO cliente (nome, cpf) VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,clienteVO.getNome());
        stmt.setString(2,clienteVO.getCpf());
        int resultado = 0;
        try{
            resultado = stmt.executeUpdate();
            stmt.close();

        }catch (Exception e){
            System.out.println("Não foi Possivél cadastra o Usuário");
        }
        return resultado;
    }

    public boolean existeRegistroPorCliente(int idCliente) throws SQLException {
        Connection conn = Banco.getConnection();
        ResultSet resultados = null;

        String query = "SELECT * FROM cliente WHERE id =?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, idCliente);
        try {
            resultados = stmt.executeQuery();
            if (resultados.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a verificação por ID.");
        }
        stmt.close();
        return false;
    }

    public int excluirClienteDAO(ClienteVO clienteVO) throws SQLException {
        Connection conn = Banco.getConnection();
        int resultado = 0;
        String query = "DELETE FROM cliente WHERE id =?";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1,clienteVO.getIdCliente());
        try {
            resultado = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException  e) {

            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            System.out.println("Erro ao expluir o cliente.");
        }

        return resultado;
    }

    public int atualizarClienteDAO(ClienteVO clienteVO) throws SQLException {
        Connection conn = Banco.getConnection();

        int resultado = 0;

        String query = "UPDATE cliente  SET nome = ? , cpf = ? WHERE id = ?";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, clienteVO.getNome());
        stmt.setString(2,clienteVO.getCpf());
        stmt.setInt(3,clienteVO.getIdCliente());
        try {
            resultado = stmt.executeUpdate();
            stmt.close();
        }catch (Exception e){
            System.out.println("Não foi Possivél Atualizar o Cliente");
        }

        return resultado;
    }

    public ArrayList<ClienteVO> consultarTodosClientesDAO() throws SQLException {
        Connection conn = Banco.getConnection();

        ResultSet resultado = null;
        ArrayList<ClienteVO> clientesVO = new ArrayList<ClienteVO>();

        String query = "SELECT * FROM cliente order by  id";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(query);
        try {
            resultado = stmt.executeQuery();
            while (resultado.next()) { //percorer ate o fim da tabela sem saber o tamanho
                ClienteVO clienteVO = new ClienteVO();
                clienteVO.setIdCliente(Integer.parseInt(resultado.getString(1)));
                clienteVO.setNome(resultado.getString(2));
                clienteVO.setCpf(resultado.getString(3));
                clientesVO.add(clienteVO);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a Consulta do clientes.");
        }
        stmt.close();
        return clientesVO;
    }

    @SuppressWarnings("Duplicates")
    public ArrayList<ClienteVO> consultarClienteDAO(ClienteVO clienteVO) throws SQLException {
        Connection conn = Banco.getConnection();
        ResultSet resultado = null;
        ArrayList<ClienteVO> retorno = new ArrayList<ClienteVO>();


        String query = "SELECT * FROM cliente WHERE id =?";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1,clienteVO.getIdCliente());
        try {
            resultado = stmt.executeQuery();
            while (resultado.next()) {
                ClienteVO cliente = new ClienteVO();
                cliente.setIdCliente(Integer.parseInt(resultado.getString(1)));
                cliente.setNome(resultado.getString(2));
                cliente.setCpf(resultado.getString(3));
                retorno.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a Consulta do clientes.");
        }
        stmt.close();
        return retorno;

    }

}
