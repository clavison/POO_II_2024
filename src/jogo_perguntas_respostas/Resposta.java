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
	
	public Resposta(Pergunta pergunta, boolean resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
	}
	public Pergunta getPergunta() {
		return pergunta;
	}
}
