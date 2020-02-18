package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.vo.ClienteVO;
import model.vo.ProdutoVO;;

public class ProdutoDAO {

    public boolean exiseRegistroPorNome(String nome) throws SQLException {
        Connection conn = Banco.getConnection();

        ResultSet resultados = null;

        String query = "SELECT * FROM produto WHERE nome =?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,nome);
        try {
            resultados = stmt.executeQuery();
            if (resultados.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a verificação por nome.");
            return true;
        }
        stmt.close();
        return false;
    }

    public boolean exiseRegistroPorId(int id) throws SQLException {
        Connection conn = Banco.getConnection();

        ResultSet resultados = null;

        String query = "SELECT * FROM produto WHERE idProduto =?";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        try {
            resultados = stmt.executeQuery();
            if (resultados.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a verificação por id.");
            return true;
        }
        stmt.close();
        return false;
    }


    public int cadastrarProdutoDAO(ProdutoVO produtoVO) throws SQLException {
        Connection conn = Banco.getConnection();
        int resultado = 0;
        String sql = "INSERT INTO produto (nome,preco,estoqueAtual,estoqueMinimo) VALUES (?,?,?,?)";
        PreparedStatement stmt1 = conn.prepareStatement(sql);
        stmt1.setString(1, produtoVO.getNome());
        stmt1.setDouble(2, produtoVO.getPreco());
        stmt1.setInt(3, produtoVO.getEstoqueAtual());
        stmt1.setInt(4, produtoVO.getEstoqueMinimo());
        try {
            resultado = stmt1.executeUpdate();
            stmt1.close();
        }catch (Exception e){
            System.out.println("Erro ao executar a Incerção do Produto.");
        }
        return resultado;
    }

    public int excluirProdutoDAO(ProdutoVO produtoVO) throws SQLException {
        Connection conn = Banco.getConnection();

        int resultado = 0;

        String query = "DELETE FROM produto WHERE idProduto =?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, produtoVO.getIdProduto());

        try {
            resultado = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir o produto.");
        }
        stmt.close();

        return resultado;
    }

    public int atualizarProdutoDAO(ProdutoVO produtoVO) throws SQLException {
        Connection conn = Banco.getConnection();

        int resultado = 0;

        String querry = "UPDATE PRODUTO SET nome =? , preco =? WHERE idproduto = ?";
        assert conn != null;
        PreparedStatement stmt = conn.prepareStatement(querry);
        stmt.setString(1,produtoVO.getNome());
        stmt.setDouble(2,produtoVO.getPreco());
        stmt.setInt(3,produtoVO.getIdProduto());
        try {
            resultado = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao executar a Atualização do produto.");
        }
        stmt.close();
        return resultado;
    }

    public void atualizarEstoqueDAO(ProdutoVO produtoVO) throws SQLException {
        Connection conn = Banco.getConnection();

        String sql = "UPDATE produto SET estoqueAtual = estoqueAtual + ? WHERE idProduto=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            // Passagem de valor para adicionar ao estoque atual
            stmt.setInt(1, produtoVO.getEstoqueAtual());
            stmt.setInt(2, produtoVO.getIdProduto());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<ProdutoVO> consultarEstoqueDAO(ProdutoVO produtoVO) throws SQLException {
        Connection conn = Banco.getConnection();
        String sql = "SELECT * FROM produto WHERE idProduto=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, produtoVO.getIdProduto());
            ArrayList<ProdutoVO> produtoVOS = new ArrayList<ProdutoVO>();
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoVO produto = new ProdutoVO();
                produto.setEstoqueAtual(Integer.parseInt(rs.getString(4)));
                produtoVOS.add(produto);

            }
            rs.close();
            stmt.close();
            return produtoVOS;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<ProdutoVO> consultarTodosProdutosDAO() {
        Connection conn = Banco.getConnection();

        ResultSet resultado = null;
        ArrayList<ProdutoVO> produtoVOS = new ArrayList<ProdutoVO>();

        String sql = "SELECT * FROM produto ORDER BY idProduto";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            resultado = stmt.executeQuery(sql);
            while (resultado.next()) {

                ProdutoVO produtoVO = new ProdutoVO();
                produtoVO.setIdProduto(Integer.parseInt(resultado.getString(1)));
                produtoVO.setNome(resultado.getString(2));
                produtoVO.setPreco(Double.parseDouble(resultado.getString(3)));
                produtoVO.setEstoqueAtual(Integer.parseInt(resultado.getString(4)));
                produtoVO.setEstoqueMinimo(Integer.parseInt(resultado.getString(5)));
                produtoVOS.add(produtoVO);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar produtos");
        } finally {
            Banco.closeResultSet(resultado);
            Banco.closeConnection(conn);
        }

        return produtoVOS;
    }
}



