package banco_de_dados.model;

public class Cidade {
	
	private int id;
	private String nome;
	private String uf;
	
	public Cidade() {
		
	}
	public Cidade(int id, String nome, String uf) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		return getId()+"-"+getNome()+"-"+getUf();
	}

}
