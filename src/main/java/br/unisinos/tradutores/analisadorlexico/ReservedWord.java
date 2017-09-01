package br.unisinos.tradutores.analisadorlexico;

public enum ReservedWord {

	DO("do"), WHILE("while");
	
	private String value;
	
	private ReservedWord(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
