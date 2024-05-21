package prova2.model;

public class Produto {

	private int id;
	private String nome;
	private double valor;
	private int estoque;

	public Produto(String linha) throws Exception{
		String dados[] = linha.split(",");
		if (dados.length != 4) {
			throw new Exception("Linha arquivo inválida");
		}
		setId(Integer.parseInt(dados[0].trim()));
		setNome(dados[1].trim());
		setValor(Double.parseDouble(dados[2].trim()));
		setEstoque(Integer.parseInt(dados[3].trim()));
	}
	
	public boolean isValid() {
		return getId() > 0 && 
				!getNome().equals("") && 
				getEstoque() > 0 && 
				getValor() > 0;
	}

	public Produto() {

	}

	public Produto(int id, String nome, double valor, int estoque) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.estoque = estoque;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return getId()+","+getNome() + "," + getValor() + "," + getEstoque();
	}

}
