package jogo_perguntas_respostas;

public class Pergunta {
	
	private String titulo;
	private boolean respostaCorreta;
	
	public Pergunta (String linha) {
		String[] dados = linha.split(",");
		setTitulo(dados[0]);
		setRespostaCorreta(dados[1].equals("Verdadeiro"));
	}
	
	public Pergunta(String titulo, boolean respostaCorreta) {
		this.titulo = titulo;
		this.respostaCorreta = respostaCorreta;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public boolean isRespostaCorreta() {
		return respostaCorreta;
	}
	public void setRespostaCorreta(boolean respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}
	
	

}
