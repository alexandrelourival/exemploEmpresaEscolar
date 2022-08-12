package br.com.treinamento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false, unique = true)
	private String nome;

	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private List<PeriodoCurso> periodosCursos = new ArrayList<PeriodoCurso>();
	
	@ManyToMany(mappedBy = "cursosUnidade")
	private List<UnidadeEscola> unidadesEscolares = new ArrayList<UnidadeEscola>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "curso_aluno")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public Curso() {
	
	}

	public Curso(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		String result = "Curso: " + this.nome;
		
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PeriodoCurso> getPeriodosCursos() {
		return periodosCursos;
	}

	public void setPeriodosCursos(List<PeriodoCurso> periodosCursos) {
		this.periodosCursos = periodosCursos;
	}

	public List<UnidadeEscola> getUnidadesEscolares() {
		return unidadesEscolares;
	}

	public void setUnidadesEscolares(List<UnidadeEscola> unidadesEscolares) {
		this.unidadesEscolares = unidadesEscolares;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
