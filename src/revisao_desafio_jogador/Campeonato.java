package revisao_desafio_jogador;

import java.util.ArrayList;

public class Campeonato {
	
	public static Time timeComMaisGols(ArrayList<Time> times) {
		Time timeMaisGols = times.get(0);
		for (Time time : times) {
			if(time.qtGolsTime() > timeMaisGols.qtGolsTime()) {
				timeMaisGols = time;
			}
		}
		return timeMaisGols;
	}
	public static Jogador artilheiroCampeonato(ArrayList<Time> times) {
		Jogador artilheiro = new Jogador();
		for (Time time : times) {
			if(time.artilheiroTime().getGols() > artilheiro.getGols()) {
				artilheiro = time.artilheiroTime();
			}
		}
		return artilheiro;
	}

}
