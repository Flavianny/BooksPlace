package com.BooksPlace.BooksPlace.Model;

public enum Estado {
	
	ACRE("Acre"),
	ALAGOAS("Alagoas"),
	AMAPA("Amapá"),
	AMAZONAS("Amazonas"),
	BAHIA("Bahia"),
	CEARA("Ceará"),
	ESPIRITOSANTO("Espírito Santo"),
	GOIAS("Goiás"),
	MARANHAO("Maranhão"),
	MATOGROSSO("Mato Grosso"),
	MATOGROSSODOSUL("Mato Grosso do Sul"),
	MINASGERAIS("Minas Gerais"),
	PARA("Pará"),
	PARAIBA("Paraíba"),
	PARANA("Paraná"),
	PERNAMBUCO("Pernambuco"),
	PIAUI("Piauí"),
	RIODEJANEIRO("Rio de Janeiro"),
	RIOGRANDEDONORTE("Rio Grande do Norte"),
	RIOGRANDEDOSUL("Rio Grande do Sul"),
	RONDONIA("Rondônia"),
	RORAIMA("Roraima"),
	SANTACATARINA("Santa Catarina"),
	SAOPAULO("São Paulo"),
	SERGIPE("Sergipe"),
	TOCANTINS("Tocantins");
	
	private String descricao;
	
	Estado(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	

}
