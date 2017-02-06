package controller;

import java.util.ArrayList;


import model.bo.ProdutoBO;
import model.vo.ProdutoVO;
import view.ProdutoDTO;

public class ControladoraProduto {

	public void cadastrarProdutoController(ProdutoDTO dto) {
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
		produtoVO.setNome(dto.getNome());
		produtoVO.setPreco(dto.getPreco());
		ProdutoBO produtoBO = new ProdutoBO();
		produtoBO.atulizarProdutoBO(produtoVO);
	}
			

}
