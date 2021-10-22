package br.edu.infnet.apptimes.model.domain;

import javax.persistence.*;

import br.edu.infnet.apptimes.model.exceptions.EspecialidadeNuloException;
import br.edu.infnet.apptimes.model.exceptions.IdadeNuloException;
import br.edu.infnet.apptimes.model.exceptions.InvestimentoNuloException;
import br.edu.infnet.apptimes.model.exceptions.NomeNuloException;
import br.edu.infnet.apptimes.model.exceptions.PosicaoNuloException;
import br.edu.infnet.apptimes.model.exceptions.ScoreNuloException;

import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Profissional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	protected String nome;
	protected float score;
	protected int idade;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "profissionais")
	private List<Time> times;
	
	public Profissional() {
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Profissional(String nome) {
		this.nome = nome;
	}
	
	public String retornaProfissional() throws NomeNuloException, ScoreNuloException, IdadeNuloException, EspecialidadeNuloException, PosicaoNuloException, InvestimentoNuloException {
		if (this.nome == null) {
			throw new NomeNuloException("O jogador esta sem nome informado");
		}
		if (this.score == 0) {
			throw new ScoreNuloException("O jogador esta sem score informado");
		}
		if (this.idade == 0) {
			throw new IdadeNuloException("O jogador esta sem idade informada");
		}
		String frase = "Nome: " + this.nome + "\nScore: " + this.score + "\nIdade: " + this.idade;
		return frase;
		
	}
	
	public abstract float calcularScore();
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome);
		sb.append(";");
		sb.append(this.score);
		sb.append(";");
		sb.append(this.idade);
		sb.append(";");
		
		return sb.toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}

	
	
	