package br.edu.infnet.apptimes.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.*;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private LocalDateTime data;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idDirigente")
    private Dirigente dirigente;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idTecnico")
    private Tecnico tecnico;
    @OneToMany(cascade = CascadeType.DETACH)
    private List<Jogador> jogadores;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Profissional> profissionais;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Time() {
        data = LocalDateTime.now();
    }

    public Time(String nome) {
        this();
        this.nome = nome;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return String.format("%s;%s;%s",
                this.nome,
                this.data.format(formato),
                this.dirigente
        );
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Profissional> profissionais) {
        this.profissionais = profissionais;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Dirigente getDirigente() {
        return dirigente;
    }

    public void setDirigente(Dirigente dirigente) {
        this.dirigente = dirigente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
