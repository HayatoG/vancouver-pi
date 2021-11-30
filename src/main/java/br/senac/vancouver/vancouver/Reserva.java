package br.senac.vancouver.vancouver;

import java.time.LocalDate;

public class Reserva {
	
	private int id_reserva;
	private Float preco_reserva;
	private LocalDate data_reserva, data_devolucao;
	private int id_usuario;
	private int id_item;
	
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
	public LocalDate getData_reserva() {
		return data_reserva;
	}	
	public void setData_reserva(LocalDate data_reserva) {
		this.data_reserva = data_reserva;
	}	
	public LocalDate getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(LocalDate data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public int getId_item() {
		return id_item;
	}
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
}