package controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.vo.ClienteVO;
import view.ClienteDTO;

public class ControladoraCliente {

	public void cadastrarClienteController(ClienteDTO dto) {
		
		
		ClienteVO clienteVO = new ClienteVO();
		clienteVO.setNome(dto.getNome());
		clienteVO.setCpf(dto.getCpf());
		
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.cadastrarClienteBO(clienteVO);
		
		
	}

	public void atualizarClienteController(ClienteDTO dto) {
		
		ClienteVO clienteVO = new ClienteVO(); 
		clienteVO.setIdCliente(dto.getIdCliente());
		clienteVO.setNome(dto.getNome());
		clienteVO.setCpf(dto.getCpf());
		
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.atulizarClienteBO(clienteVO);
		
		
		
		
	}

	public void excluirClienteController(ClienteDTO dto) {
		
		ClienteVO clienteVO = new ClienteVO();
		clienteVO.setIdCliente(dto.getIdCliente());
		
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.excluirClienteBO(clienteVO);
		
		
		
	}

	public ArrayList<ClienteDTO> consultarTodosClientesController() {
		
		ClienteBO clienteBO = new ClienteBO();
		ArrayList<ClienteVO> clientesVO = clienteBO.consultarTodosClientesBO();
		ArrayList<ClienteDTO> listaDTO = new ArrayList<ClienteDTO>();
		
		for(int  i = 0;i < clientesVO.size();i++){
			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setIdCliente(clientesVO.get(i).getIdCliente());
			clienteDTO.setNome(clientesVO.get(i).getNome());
			clienteDTO.setCpf(clientesVO.get(i).getCpf());
			
			listaDTO.add(clienteDTO);
			
		}
		
		
		return listaDTO;
	}

	public ArrayList<ClienteDTO> consultarClientesController(ClienteDTO dto) {


		ClienteVO clienteVO = new ClienteVO();
		clienteVO.setIdCliente(dto.getIdCliente());

		ClienteBO clienteBO = new ClienteBO();
		ArrayList<ClienteVO> clientesVO = clienteBO.consultarTodosClientesBO();
		ArrayList<ClienteDTO> listaDTO = new ArrayList<ClienteDTO>();

		for(int  i = 0;i < clientesVO.size();i++){
			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setIdCliente(clientesVO.get(i).getIdCliente());
			clienteDTO.setNome(clientesVO.get(i).getNome());
			clienteDTO.setCpf(clientesVO.get(i).getCpf());

			listaDTO.add(clienteDTO);

		}


		return listaDTO;


		/*ClienteBO clienteBO = new ClienteBO();
		ArrayList<ClienteVO> resultadoClienteVO = clienteBO.consultarClienteBO(clienteVO);

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setIdCliente(resultadoClienteVO.getIdCliente());
		clienteDTO.setNome(resultadoClienteVO.getNome());
		clienteDTO.setCpf(resultadoClienteVO.getCpf());


		
		return clienteDTO;*/
	}

}

