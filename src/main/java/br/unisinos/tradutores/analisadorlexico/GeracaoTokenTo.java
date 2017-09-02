package br.unisinos.tradutores.analisadorlexico;

public class GeracaoTokenTo {

	private Token token;
	
	private Boolean skipNext;
	
	public GeracaoTokenTo(Token token) {
		super();
		this.token = token;
		this.skipNext = Boolean.FALSE;
	}
	
	public GeracaoTokenTo(Token token, Boolean skipNext) {
		super();
		this.token = token;
		this.skipNext = skipNext;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Boolean getSkipNext() {
		return skipNext;
	}

	public void setSkipNext(Boolean skipNext) {
		this.skipNext = skipNext;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skipNext == null) ? 0 : skipNext.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		GeracaoTokenTo other = (GeracaoTokenTo) obj;
		if (skipNext == null) {
			if (other.skipNext != null)
				return false;
		} else if (!skipNext.equals(other.skipNext))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GeracaoTokenTo [token=" + token + ", skipNext=" + skipNext + "]";
	}
	
}
