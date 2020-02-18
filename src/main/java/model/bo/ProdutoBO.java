package model.bo;


import model.dao.ProdutoDAO;
import model.vo.ProdutoVO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoBO {

    public void cadastrarProdutoBO(ProdutoVO produtoVO) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        if (produtoDAO.exiseRegistroPorNome(produtoVO.getNome())) {
            System.out.println("\nProduto já cadastrado");
        } else {
            int resultado = produtoDAO.cadastrarProdutoDAO(produtoVO);
            if (resultado == 1) {
                System.out.println("\nProduto cadastrado com Sucesso!");
            } else {
                System.out.println("\nNão foi possível cadastrar o Produto!!");

            }
        }
    }

    public void excluirProdutoBO(ProdutoVO produtoVO) throws SQLException {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        if (produtoDAO.exiseRegistroPorId(produtoVO.getIdProduto())) {
            int resulado = produtoDAO.excluirProdutoDAO(produtoVO);
            if (resulado == 1) {
                System.out.println("\nProduto excluído com Sucesso!");
            } else {
                System.out.println("\nNão foi possivel excluir Produto!");
            }
        } else {
            System.out.println("\nProduto não existe.");
        }


    }

    public void atulizarProdutoBO(ProdutoVO produtoVO) throws SQLException {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        if (produtoDAO.exiseRegistroPorId(produtoVO.getIdProduto())) {
            int resultado = produtoDAO.atualizarProdutoDAO(produtoVO);
            if (resultado == 1) {
                System.out.println("\nProduto atualizado com Sucesso");
            } else {
                System.out.println("\nNão foi possivel atualizar Produto");
            }
        }else{
            System.out.println("\nProduto não encontrado");
        }
    }

    public void atulizarEstoqueBO(ProdutoVO produtoVO) throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.atualizarEstoqueDAO(produtoVO);
    }

    public ArrayList<ProdutoVO> consultarEstoqueBO(ProdutoVO produtoVO) throws SQLException {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<ProdutoVO> resultado = produtoDAO.consultarEstoqueDAO(produtoVO);
        if (resultado.isEmpty()) {
            System.out.println("\nNada encontrador");
        }
        return resultado;
    }

    public ArrayList<ProdutoVO> consultaroTodosProdutos() throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ArrayList<ProdutoVO> produtoVOS = produtoDAO.consultarTodosProdutosDAO();
        if (produtoVOS.isEmpty()) {
            System.out.println("Não foi possivel fazer");
        }
        return produtoVOS;
    }
}