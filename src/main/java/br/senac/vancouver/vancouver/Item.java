package br.senac.vancouver.vancouver;

public class Item {
	
	private int id_item;
	private String nome_item;
	private float preco_item;
	private String descricao;
	private boolean disponivel;
	
	public int getId_item() {
		return id_item;
	}
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}
	public String getNome_item() {
		return nome_item;
	}
	public void setNome_item(String nome_item) {
		this.nome_item = nome_item;
	}
	public float getPreco_item() {
		return preco_item;
	}
	public void setPreco_item(float preco_item) {
		this.preco_item = preco_item;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	

}