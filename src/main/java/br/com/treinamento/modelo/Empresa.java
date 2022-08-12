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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false, unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<UnidadeEscola> unidadesEscolares = new ArrayList<UnidadeEscola>();
	
	public Empresa() {
	
	}

	public Empresa(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		String result = "Empresa: " + this.nome;
		
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

	public List<UnidadeEscola> getUnidadesEscolares() {
		return unidadesEscolares;
	}

	public void setUnidadesEscolares(List<UnidadeEscola> unidadesEscolares) {
		this.unidadesEscolares = unidadesEscolares;
	}

}
