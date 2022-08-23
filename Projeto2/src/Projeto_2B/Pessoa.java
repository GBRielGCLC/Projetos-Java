package Projeto_2B;

public class Pessoa {
	
	private String cpfPaciente;
	private String nomePaciente;
	private String fone;
	private String endereço;
	
	private String cpfMedico;
	private String area;
	private String nomeMedico;
	
	public String getCpfPaciente() {
		return this.cpfPaciente;
	}
	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}
	
	public String getNomePaciente() {
		return this.nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public String getFone() {
		return this.fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getEndereço() {
		return this.endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	
	public String getCpfMedico() {
		return this.cpfMedico;
	}
	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}
	
	public String getArea() {
		return this.area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
}
