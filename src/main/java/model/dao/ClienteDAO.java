package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.vo.ClienteVO;

public class ClienteDAO {

	public boolean existeRegistroPorCpf(String cpf)  {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultados = null;
		
		String query = "SELECT * FROM cliente WHERE cpf = '" + cpf +"'" ;
		try {
			resultados = stmt.executeQuery(query);
			if(resultados.next()){	
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a verificação por CPF.");
			return true;
		} finally {
			Banco.closeResultSet(resultados);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "INSERT INTO cliente (nome, cpf) VALUES ('" + clienteVO.getNome() + "', '" 
		+ clienteVO.getCpf() + "')";		
		
		try {
			
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Incerção do Cliente.");
		}finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}	
		
		return resultado;
	}

	public boolean existeRegistroPorCliente(int idCliente) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultados = null;
		
		String query = "SELECT * FROM cliente WHERE idcliente = " + idCliente;
		try {
			resultados = stmt.executeQuery(query);
			if(resultados.next()){	
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a verificação por ID.");
			return false;
		} finally {
			Banco.closeResultSet(resultados);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;	
		
		String query = "DELETE FROM cliente WHERE idcliente = " + clienteVO.getIdCliente();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao expluir o cliente.");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return resultado;
	}

	public int atualizarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query ="UPDATE cliente  SET nome = '" + clienteVO.getNome() + "', "
				+ "cpf = '" + clienteVO.getCpf() + "' "
				+ " WHERE idcliente = " + clienteVO.getIdCliente();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Atualização do client.");
			
		}finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
							
		return resultado;
	}

	public ArrayList<ClienteVO> consultarTodosClientesDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ClienteVO> clientesVO =  new ArrayList<ClienteVO>();
		
		String query = "SELECT * FROM cliente";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()){ //percorer ate o fim da tabela sem saber o tamaho
				ClienteVO clienteVO = new ClienteVO();
				clienteVO.setIdCliente(Integer.parseInt(resultado.getString(1)));
				clienteVO.setNome(resultado.getString(2));
				clienteVO.setCpf(resultado.getString(3));
				clientesVO.add(clienteVO);						
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Consulta do clientes.");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}				
		return clientesVO;
	}

	public ClienteVO consultarClienteDAO(ClienteVO clienteVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ClienteVO cliente =  new ClienteVO();
		
		String query = "SELECT * FROM cliente WHERE idcliente = " +clienteVO.getIdCliente();
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()){ //percorer ate o fim da tabela sem saber o tamaho
				
				cliente.setIdCliente(Integer.parseInt(resultado.getString(1)));
				cliente.setNome(resultado.getString(2));
				cliente.setCpf(resultado.getString(3));
									
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Consulta do clientes.");
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}				
		return cliente;	
		
	}

}
