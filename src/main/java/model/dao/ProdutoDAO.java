package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		


	public int cadastrarProdutoDAO(ProdutoVO produtoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "INSERT INTO produto (nome, valorunitario,estoqueminimo,estoqueatual) VALUES ('" + produtoVO.getNome() + "', '" 
		+ produtoVO.getPreco() + "','"
		+ produtoVO.getEstoqueMinimo()+ "','"
		+ produtoVO.getEstoqueAtual() + "')";		
		
		try {
			
			resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Incerção do Produto.");
		}finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}	
		
		return resultado;
	}

	public int excluirProdutoDAO(ProdutoVO produtoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;	
		
		String query = "DELETE FROM produto WHERE IDPRODUTO = " + produtoVO.getIdProduto();
		
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



