package br.com.treinamento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Periodos_Cursos")
public class PeriodoCurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int periodo;
	
	@OneToMany(mappedBy = "periodoCurso", cascade = CascadeType.ALL)
	private List<DisciplinaOferecida> disciplinasOferecidas = new ArrayList<DisciplinaOferecida>();
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	public PeriodoCurso() {
		
	}

	public PeriodoCurso(int periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public String toString() {
		String result = "Periodo: " + this.periodo +
				"	| " + this.curso;
		
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public List<DisciplinaOferecida> getDisciplinasOferecidas() {
		return disciplinasOferecidas;
	}

	public void setDisciplinasOferecidas(List<DisciplinaOferecida> disciplinasOferecidas) {
		this.disciplinasOferecidas = disciplinasOferecidas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
