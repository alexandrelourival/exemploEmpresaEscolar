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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Unidades_Escolares")
public class UnidadeEscola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false, unique = true)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "unidade_escolar_professor")
	private List<Professor> professores = new ArrayList<Professor>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "unidade_escolar_curso")
	private List<Curso> cursosUnidade = new ArrayList<Curso>();
	
	public UnidadeEscola() {

	}

	public UnidadeEscola(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		String result = "Unidade Escolar: " + this.nome +
				"	| " + this.empresa;
		
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Curso> getCursosUnidade() {
		return cursosUnidade;
	}

	public void setCursosUnidade(List<Curso> cursosUnidade) {
		this.cursosUnidade = cursosUnidade;
	}
	
}
