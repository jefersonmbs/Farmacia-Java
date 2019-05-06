package model.dao;

import java.sql.*;

import model.vo.ProdutoVO;;

public class ProdutoDAO {

	public  boolean exiseRegistroPorNome (String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultados = null;
		
		String query = "SELECT * FROM produto WHERE nome = '" + nome +"'" ;
		try {
			resultados = stmt.executeQuery(query);
			if(resultados.next()){	
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a verificação por nome.");
			return true;
		} finally {
			Banco.closeResultSet(resultados);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}
	public  boolean exiseRegistroPorId (int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultados = null;

		String query = "SELECT * FROM produto WHERE idProduto = '" + id +"'" ;
		try {
			resultados = stmt.executeQuery(query);
			if(resultados.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a verificação por nome.");
			return true;
		} finally {
			Banco.closeResultSet(resultados);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}
		


	public int cadastrarProdutoDAO(ProdutoVO produtoVO) throws SQLException {
		Connection conn = Banco.getConnection();

		int resultado = 0;

		String sql = "insert into produto " +
				"(nome,preco,estoqueAtual,estoqueMinimo) " +
				"values (?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,produtoVO.getNome());
		stmt.setDouble(2,produtoVO.getPreco());
		stmt.setInt(3,produtoVO.getEstoqueAtual());
		stmt.setInt(4,produtoVO.getEstoqueMinimo());
		
		/*String query = "INSERT INTO produto (nome, preco,estoqueAtual,estoqueMinimo) VALUES ('" + produtoVO.getNome() + "', '"
		+ produtoVO.getPreco() + "','"
		+ produtoVO.getEstoqueAtual()+ "','"
		+ produtoVO.getEstoqueMinimo() + "')";*/
		
		try {

			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Incerção do Produto.");
		}
		
		return resultado;
	}

	public int excluirProdutoDAO(ProdutoVO produtoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;	
		
		String query = "DELETE FROM produto WHERE idProduto = " + produtoVO.getIdProduto();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir o produto.");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return resultado;
	}
		
	public int atualizarProdutoDAO(ProdutoVO produtoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
				
		String querry = "UPDATE PRODUTO SET nome = '" + produtoVO.getNome() + "',"
				+ "valorunitario ='" + produtoVO.getPreco() + "' "
				+ " WHERE idproduto = " + produtoVO.getIdProduto();
		try {
			resultado = stmt.executeUpdate(querry);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Atualização do produto.");
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		return resultado;
	}
	
	}



