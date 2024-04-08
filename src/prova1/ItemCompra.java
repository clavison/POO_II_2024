package prova1;

public class ItemCompra {
	
	private Produto produto;
	private int qt;
	
	public ItemCompra(Produto produto, int qt) {
		this.produto = produto;
		this.qt = qt;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}
	
	public boolean podeVender() {
		return produto.getEstoque() >= qt;
	}
	
	public double subTotal() {
		return produto.getValor() * qt;
	}
	
	@Override
	public String toString() {
		return produto.getNome()+","+
				qt+","+
				produto.getValor()+","+
				subTotal()+"\n";
	}
}
