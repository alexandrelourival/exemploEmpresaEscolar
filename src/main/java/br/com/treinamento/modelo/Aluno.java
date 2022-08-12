package br.com.treinamento.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.treinamento.util.Sexo;

@Entity
@Table(name = "Alunos")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(nullable = false)
	private String email;

	@Column(name = "data_nas", nullable = false)
	private LocalDate dataNascimento;

	@Column(nullable = false, unique = true)
	private String matricula;
	
	@ManyToMany(mappedBy = "alunos")
	private List<Curso> cursos = new ArrayList<Curso>();

	public Aluno() {
		
	}

	public Aluno(String nome, Sexo sexo, String email, LocalDate dataNascimento, String matricula) {
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		String result = "Matricula: " + this.matricula +
				"	| Nome: " + this.nome +
				"	| E-mail: " + this.email +
				"	| Sexo: " + this.sexo +
				"	| Data de nascimento: " + this.dataNascimento;
		
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
