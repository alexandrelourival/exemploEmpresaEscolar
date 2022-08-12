package br.com.treinamento.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Diciplinas_Oferecidas")
public class DisciplinaOferecida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 100, nullable = false, unique = true)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "periodo_curso_id")
	private PeriodoCurso periodoCurso;
	
	public DisciplinaOferecida() {
	
	}

	public DisciplinaOferecida(String nome) {
		this.nome = nome;;
	}
	
	@Override
	public String toString() {
		String result = "Disciplina: " + this.nome +
				"	| " + this.periodoCurso;

		return result;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PeriodoCurso getPeriodoCurso() {
		return periodoCurso;
	}

	public void setPeriodoCurso(PeriodoCurso periodoCurso) {
		this.periodoCurso = periodoCurso;
	}
	
}
