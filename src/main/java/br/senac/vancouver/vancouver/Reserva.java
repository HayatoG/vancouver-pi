package br.senac.vancouver.vancouver;

public class Reserva {
	
	private int id_reserva;
	private Float preco_reserva;
	private String data_reserva, data_devolucao;
	
	public int getId_reserva() {
		return id_reserva;
	}	
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Float getPreco_reserva() {
		return preco_reserva;
	}	
	public void setPreco_reserva(Float preco_reserva) {
		this.preco_reserva = preco_reserva;
	}	
	public String getData_reserva() {
		return data_reserva;
	}	
	public void setData_reserva(String data_reserva) {
		this.data_reserva = data_reserva;
	}	
	public String getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
}
