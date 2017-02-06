package model.bo;



import model.dao.ProdutoDAO;
import model.vo.ProdutoVO;;

public class ProdutoBO {

	public void cadastrarProdutoBO(ProdutoVO produtoVO) {
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

	public void excluirProdutoBO(ProdutoVO produtoVO) {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		if(produtoDAO.exiseRegistroPorNome(produtoVO.getNome())){
			int resulado = produtoDAO.excluirProdutoDAO(produtoVO);
			if(resulado == 1){
		    System.out.println("\nCliProduto excluído com Sucesso!");
		} else {
			System.out.println("\nNão foi possivel excluir Produto!");
		}
	} else {
		System.out.println("\nProduto não existe.");
	}
		
		
	}
	
	public void atulizarProdutoBO(ProdutoVO produtoVO) {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		if(produtoDAO.exiseRegistroPorNome(produtoVO.getNome())){
			int resultado = produtoDAO.atualizarProdutoDAO(produtoVO);
			if(resultado==1){
				System.out.println("\nProduto atualizado com Sucesso");
			}else{
				System.out.println("\nNão foi possivel atualizar Produto");
			}
		}
		
				
		
		
		
	}



}