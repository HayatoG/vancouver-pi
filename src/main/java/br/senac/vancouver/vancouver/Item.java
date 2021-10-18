package br.senac.vancouver.vancouver;

public class Item {
	
	private int id_item;
	private String nome_item, descricao;
	private float preco;
	private boolean status;
	

public int getId_item() {
	return id_item;
}

public void setId(int id_item) {
	this.id_item = id_item;
}

public String getNome_item() {
	return nome_item;
}

public void setNome_item( String nome_item) {
	this.nome_item = nome_item;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public float getPreco() {
	return preco;
}

public void setPreco(float preco) {
	this.preco = preco;
}

public boolean getStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}

}