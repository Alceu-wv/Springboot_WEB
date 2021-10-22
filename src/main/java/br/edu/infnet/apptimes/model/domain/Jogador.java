package br.edu.infnet.apptimes.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.apptimes.model.exceptions.EspecialidadeNuloException;
import br.edu.infnet.apptimes.model.exceptions.IdadeNuloException;
import br.edu.infnet.apptimes.model.exceptions.InvestimentoNuloException;
import br.edu.infnet.apptimes.model.exceptions.NomeNuloException;
import br.edu.infnet.apptimes.model.exceptions.PosicaoNuloException;
import br.edu.infnet.apptimes.model.exceptions.ScoreNuloException;

@Entity
public class Jogador extends Profissional {
	
	private int camisa;
	private float pontosPorJogo;
	private String posicao;
	

	public Jogador() {
		super();
	}

	public Jogador(String nome) {
		super(nome);
	}

	@Override
	public float calcularScore() {
		float scoreJogador = super.score * this.pontosPorJogo; 
		return scoreJogador;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()); //chamar o stringbuilder j� construido da m�e para compor
		sb.append(this.posicao);
		sb.append(";");
		sb.append(this.camisa);
		sb.append(";");
		sb.append(this.calcularScore());
		sb.append(";");

		
		return sb.toString();
	}

	@Override
	public String retornaProfissional() throws NomeNuloException, ScoreNuloException, IdadeNuloException, PosicaoNuloException, EspecialidadeNuloException, InvestimentoNuloException{
		if (this.posicao == null) {
			throw new PosicaoNuloException("Jogador esta sem posicao informada");
		}
		String retornoJogador = "\nCamisa :" + this.camisa + "\nPontos por Jogo: " + this.pontosPorJogo + "\nPosicao: " + this.posicao;
		return super.retornaProfissional() + retornoJogador;
	}
		
	
	public int getCamisa() {
		return camisa;
	}

	public void setCamisa(int camisa) {
		this.camisa = camisa;
	}

	public float getPontosPorJogo() {
		return pontosPorJogo;
	}

	public void setPontosPorJogo(float pontosPorJogo) {
		this.pontosPorJogo = pontosPorJogo;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	
}
