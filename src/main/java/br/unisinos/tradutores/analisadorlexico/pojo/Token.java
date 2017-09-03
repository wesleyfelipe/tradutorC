package br.unisinos.tradutores.analisadorlexico.pojo;

import br.unisinos.tradutores.analisadorlexico.enums.TipoToken;

public class Token {
	
	private TipoToken tipo;
	
	private Object valor;
	
	public Token(TipoToken tipo, Object valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}

	public TipoToken getTipo() {
		return tipo;
	}

	public void setTipo(TipoToken tipo) {
		this.tipo = tipo;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (tipo != other.tipo)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Token [tipo=" + tipo + ", valor=" + valor + "]";
	}
	
}
