package edu.ifmt.vendaifmt.model;

public enum StatusVenda {

	VENDIDO("Vendido"), 
	SEMESTOQUE("Sem Estoque");

	private String descricao;

	StatusVenda(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}
}
