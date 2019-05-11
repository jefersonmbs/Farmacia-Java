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

	public ArrayList<ProdutoDTO> consultarTodosProdutosController() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProdutoDTO consultarTodosProdutosController(ProdutoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public ProdutoDTO consultarEstoqueMinimoEstoqueController(ProdutoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluirProdutoController(ProdutoDTO dto) {
		
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setIdProduto(dto.getIdProduto());
		
		ProdutoBO produtoBO = new ProdutoBO();
		produtoBO.excluirProdutoBO(produtoVO);
		
	
		
	}
	public void atualizarProdutoController(ProdutoDTO dto){
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

	public ArrayList<ProdutoDTO> consultarEstoqueController(ProdutoDTO dto)throws SQLException {
		ProdutoVO produtoVO = new ProdutoVO();
		produtoVO.setIdProduto(dto.getIdProduto());
		ProdutoBO produtoBO = new ProdutoBO();
		ArrayList<ProdutoVO> produtosVO = produtoBO.consultarEstoqueBO(produtoVO);
		ArrayList<ProdutoDTO> listadto = new ArrayList<ProdutoDTO>();

		for (int i = 0; i< produtosVO.size();i++){
			ProdutoDTO produtoDTO = new ProdutoDTO();
			produtoDTO.setEstoqueAtual(produtosVO.get(i).getEstoqueAtual());
			listadto.add(produtoDTO);
		}
		return  listadto;
	}
}
