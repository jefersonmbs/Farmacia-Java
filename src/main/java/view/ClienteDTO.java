package view;

public class ClienteDTO {
	
	private int idCliente;
	private String nome;
	private String cpf;
	
	
public ClienteDTO(int idCliente, String nome, String cpf) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
	}


	public ClienteDTO() {
		super();
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void imprimir() {
		
		System.out.printf("\n%3d  %-20s  %-30s  \n",
				this.getIdCliente(),this.getNome(),this.getCpf());
		
	}
	
	
	
}
