package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.vo.ClienteVO;
import model.vo.ProdutoVO;;

public class ProdutoDAO {

    public boolean exiseRegistroPorNome(String nome) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultados = null;

        String query = "SELECT * FROM produto WHERE nome = '" + nome + "'";
        try {
            resultados = stmt.executeQuery(query);
            if (resultados.next()) {
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

    public boolean exiseRegistroPorId(int id) {
        Connection conn = Banco.getConnection();
        Statement stmt = Banco.getStatement(conn);
        ResultSet resultados = null;

        String query = "SELECT * FROM produto WHERE idProduto = '" + id + "'";
        try {
            resultados = stmt.executeQuery(query);
            if (resultados.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a verificação por id.");
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
        String sql = "INSERT INTO produto (nome,preco,estoqueAtual,estoqueMinimo) VALUES (?,?,?,?)";
        PreparedStatement stmt1 = conn.prepareStatement(sql);
        stmt1.setString(1, produtoVO.getNome());
        stmt1.setDouble(2, produtoVO.getPreco());
        stmt1.setInt(3, produtoVO.getEstoqueAtual());
        stmt1.setInt(4, produtoVO.getEstoqueMinimo());
        try {
            resultado = stmt1.executeUpdate();
        }catch (Exception e){
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
        } finally {
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
                + "preco ='" + produtoVO.getPreco() + "' "
                + " WHERE idproduto = " + produtoVO.getIdProduto();
        try {
            resultado = stmt.executeUpdate(querry);
        } catch (SQLException e) {
            System.out.println("Erro ao executar a Atualização do produto.");
        } finally {
            Banco.closeStatement(stmt);
            Banco.closeConnection(conn);
        }
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



