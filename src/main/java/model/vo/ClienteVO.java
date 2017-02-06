package model.vo;

public class ClienteVO {
	private int idCliente;
	private String nome;
	private String cpf;
	
	
public ClienteVO(int idCliente, String nome, String cpf) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
	}


	public ClienteVO() {
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



}
