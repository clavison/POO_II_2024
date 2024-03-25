package jogo_perguntas_respostas;

public class Resposta {
	
	private Pergunta pergunta;
	private boolean resposta;
	
	public String correcao() {
		if(pergunta.isRespostaCorreta() == resposta) {
			return "acerto";
		}
		return "erro";
	}
	
	public Resposta() {
		this(new Pergunta(), false);
	}
	
	public Resposta(Pergunta pergunta, boolean resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
	}
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	public boolean isResposta() {
		return resposta;
	}
	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

}
