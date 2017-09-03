package br.unisinos.tradutores.analisadorlexico.pojo;

public class DeclaracaoVariavel {
	
	private String name;
	
	private int id;

	private int contexto;

	public DeclaracaoVariavel(String name, int id, int contexto) {
		super();
		this.name = name;
		this.id = id;
		this.contexto = contexto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContexto() {
		return contexto;
	}

	public void setContexto(int contexto) {
		this.contexto = contexto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contexto;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		DeclaracaoVariavel other = (DeclaracaoVariavel) obj;
		if (contexto != other.contexto)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
}
