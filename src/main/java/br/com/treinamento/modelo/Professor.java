package br.com.treinamento.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.treinamento.util.Sexo;

@Entity
@Table(name = "Professores")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	private String email;

	@Column(name = "data_nas")
	private LocalDate dataNascimento;
	
	@Column(length = 11, unique = true, nullable = false)
	private String pispasep;
	
	@ManyToMany(mappedBy = "professores")
	private List<UnidadeEscola> unidadesEscolas = new ArrayList<UnidadeEscola>();
	
	public Professor() {
	
	}

	public Professor(String nome, Sexo sexo, String email, LocalDate dataNascimento, String pispasep) {
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.pispasep = pispasep;
	}

	@Override
	public String toString() {
		String result = "PIS/PASEP: " + this.pispasep +
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

	public String getPispasep() {
		return pispasep;
	}

	public void setPispasep(String pispasep) {
		this.pispasep = pispasep;
	}

	public List<UnidadeEscola> getUnidadesEscolas() {
		return unidadesEscolas;
	}

	public void setUnidadesEscolas(List<UnidadeEscola> unidadesEscolas) {
		this.unidadesEscolas = unidadesEscolas;
	}
	
}
