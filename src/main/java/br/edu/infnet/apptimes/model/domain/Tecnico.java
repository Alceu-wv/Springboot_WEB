package br.edu.infnet.apptimes.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.apptimes.model.exceptions.EspecialidadeNuloException;
import br.edu.infnet.apptimes.model.exceptions.IdadeNuloException;
import br.edu.infnet.apptimes.model.exceptions.InvestimentoNuloException;
import br.edu.infnet.apptimes.model.exceptions.NomeNuloException;
import br.edu.infnet.apptimes.model.exceptions.PosicaoNuloException;
import br.edu.infnet.apptimes.model.exceptions.ScoreNuloException;

@Entity
public class Tecnico extends Profissional {
	private String especialidade;
	private int anosDeExperiencia;
	private String historicoProfissional;

	public Tecnico() {
		super();
	}
	
	public Tecnico(String nome) {
		super(nome);
	}


	@Override
	public float calcularScore() {
		float scoreTecnico = super.score * this.anosDeExperiencia; 
		return scoreTecnico;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()); //chamar o stringbuilder j� construido da m�e para compor
		sb.append(this.especialidade);
		sb.append(";");
		sb.append(this.historicoProfissional);
		sb.append(";");
		sb.append(this.calcularScore());
		sb.append(";");
		
		return sb.toString();
	}
	
	
	@Override
	public String retornaProfissional() throws NomeNuloException, ScoreNuloException, IdadeNuloException, EspecialidadeNuloException, PosicaoNuloException, InvestimentoNuloException {
		if (especialidade == null) {
			throw new EspecialidadeNuloException("A especialidade do tecnico nao esta definida");
		}
		String retornaTecnico = "\nEspecialidade :" + this.especialidade + "\nAnos De Experiencia: " + this.anosDeExperiencia + "\nHistorico Profissional: " + this.historicoProfissional;
		return super.retornaProfissional() + retornaTecnico;
		
	}


	public String getEspecialidade() {
		return especialidade;
	}


	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}


	public int getAnosDeExperiencia() {
		return anosDeExperiencia;
	}


	public void setAnosDeExperiencia(int anosDeExperiencia) {
		this.anosDeExperiencia = anosDeExperiencia;
	}


	public String getHistoricoProfissional() {
		return historicoProfissional;
	}


	public void setHistoricoProfissional(String historicoProfissional) {
		this.historicoProfissional = historicoProfissional;
	}

}
