package controller;

import java.sql.SQLException;
import java.util.ArrayList;


import model.bo.ProdutoBO;
import model.vo.ProdutoVO;
import view.ProdutoDTO;

public class ControladoraProduto {

    public void cadastrarProdutoController(ProdutoDTO dto) throws SQLException {
        ProdutoVO produtoVO = new ProdutoVO();
        produtoVO.setNome(dto.getNome());
        produtoVO.setPreco(dto.getPreco());
        produtoVO.setEstoqueMinimo(dto.getEstoqueMinimo());
        produtoVO.setEstoqueAtual(dto.getEstoqueAtual());
        ProdutoBO produtoBO = new ProdutoBO();
        produtoBO.cadastrarProdutoBO(produtoVO);


    }

    public ArrayList<ProdutoDTO> consultarTodosProdutosController() throws SQLException {
        // TODO Auto-generated method stub

        ProdutoBO produtoBO = new ProdutoBO();
        ArrayList<ProdutoVO>  produtoVO = produtoBO.consultaroTodosProdutos();
        ArrayList<ProdutoDTO> listDTO = new ArrayList<ProdutoDTO>();


        for (ProdutoVO vo : produtoVO) {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setIdProduto(vo.getIdProduto());
            produtoDTO.setNome(vo.getNome());
            produtoDTO.setPreco(vo.getPreco());
            produtoDTO.setEstoqueAtual(vo.getEstoqueAtual());
            produtoDTO.setEstoqueMinimo(vo.getEstoqueMinimo());

            listDTO.add(produtoDTO);

        }


        return listDTO;
    }


    public ProdutoDTO consultarTodosProdutosController(ProdutoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }


    public ProdutoDTO consultarEstoqueMinimoEstoqueController(ProdutoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    public void excluirProdutoController(ProdutoDTO dto) throws SQLException {

        ProdutoVO produtoVO = new ProdutoVO();
        produtoVO.setIdProduto(dto.getIdProduto());

        ProdutoBO produtoBO = new ProdutoBO();
        produtoBO.excluirProdutoBO(produtoVO);


    }

    public void atualizarProdutoController(ProdutoDTO dto) throws SQLException {
        ProdutoVO produtoVO = new ProdutoVO();
        produtoVO.setIdProduto(dto.getIdProduto());
        produtoVO.setNome(dto.getNome());
        produtoVO.setPreco(dto.getPreco());
        ProdutoBO produtoBO = new ProdutoBO();
        produtoBO.atulizarProdutoBO(produtoVO);
    }


    public void atualizarEstoqueController(ProdutoDTO dto) throws SQLException {
        ProdutoVO produtoVO = new ProdutoVO();
        produtoVO.setIdProduto(dto.getIdProduto());
        produtoVO.setEstoqueAtual(dto.getEstoqueAtual());
        ProdutoBO produtoBO = new ProdutoBO();
        produtoBO.atulizarEstoqueBO(produtoVO);
    }

    public ArrayList<ProdutoDTO> consultarEstoqueController(ProdutoDTO dto) throws SQLException {
        ProdutoVO produtoVO = new ProdutoVO();
        produtoVO.setIdProduto(dto.getIdProduto());
        ProdutoBO produtoBO = new ProdutoBO();
        ArrayList<ProdutoVO> produtosVO = produtoBO.consultarEstoqueBO(produtoVO);
        ArrayList<ProdutoDTO> listadto = new ArrayList<ProdutoDTO>();

        for (ProdutoVO vo : produtosVO) {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setEstoqueAtual(vo.getEstoqueAtual());
            listadto.add(produtoDTO);
        }
        return listadto;
    }
}
