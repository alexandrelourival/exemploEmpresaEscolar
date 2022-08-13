package br.com.treinamento.teste;

import javax.persistence.EntityManager;

import br.com.treinamento.dao.AlunoDAO;
import br.com.treinamento.dao.CursoDAO;
import br.com.treinamento.dao.DisciplinaOferecidaDAO;
import br.com.treinamento.dao.EmpresaDAO;
import br.com.treinamento.dao.JPAUtil;
import br.com.treinamento.dao.PeriodoCursoDAO;
import br.com.treinamento.dao.ProfessorDAO;
import br.com.treinamento.dao.UnidadeEscolaDAO;
import br.com.treinamento.modelo.Curso;
import br.com.treinamento.modelo.UnidadeEscola;

public class TesteEmpresa {

	public static void main(String[] args) {

		/*
		 * Empresa empresa = new Empresa("UFRN"); UnidadeEscola unidade1 = new
		 * UnidadeEscola("Campus Natal"); UnidadeEscola unidade2 = new
		 * UnidadeEscola("Campus Caico"); Professor professor1 = new
		 * Professor("Vitor Silva", Sexo.MASCULINO, "testevitor@gmail.com",
		 * LocalDate.now(), "12345678912"); Professor professor2 = new
		 * Professor("Lucas Oliveira", Sexo.MASCULINO, "testelucas@gmail.com",
		 * LocalDate.now(), "98765432112"); Curso curso1 = new
		 * Curso("Backend Developer"); Curso curso2 = new Curso("Java"); PeriodoCurso
		 * periodoCurso1 = new PeriodoCurso(1); PeriodoCurso periodoCurso2 = new
		 * PeriodoCurso(2); PeriodoCurso periodoCurso3 = new PeriodoCurso(3);
		 * PeriodoCurso periodoCurso4 = new PeriodoCurso(4); DisciplinaOferecida
		 * disciplina1 = new DisciplinaOferecida("Introdução a Java");
		 * DisciplinaOferecida disciplina2 = new DisciplinaOferecida("Java - Avançado");
		 * DisciplinaOferecida disciplina3 = new DisciplinaOferecida("SpringBoot");
		 * DisciplinaOferecida disciplina4 = new DisciplinaOferecida("Python"); Aluno
		 * aluno1 = new Aluno("Lourival Neto", Sexo.MASCULINO,
		 * "testelourival@gmail.com", LocalDate.now(), "123456789"); Aluno aluno2 = new
		 * Aluno("Juan Silva", Sexo.MASCULINO, "testejuan@gmail.com", LocalDate.now(),
		 * "987654321");
		 */

		EntityManager em = JPAUtil.getEntityManager();

		EmpresaDAO empresaDAO = new EmpresaDAO(em);
		UnidadeEscolaDAO unidadeEscolaDAO = new UnidadeEscolaDAO(em);
		ProfessorDAO professorDAO = new ProfessorDAO(em);
		CursoDAO cursoDAO = new CursoDAO(em);
		AlunoDAO alunoDAO = new AlunoDAO(em);
		PeriodoCursoDAO periodoCursoDAO = new PeriodoCursoDAO(em);
		DisciplinaOferecidaDAO disciplinaOferecidaDAO = new DisciplinaOferecidaDAO(em);

		// Cadastro de curso em unidade existente
		/*
		 * Curso curso = new Curso("Fullstack Developer"); UnidadeEscola unidadeEscola =
		 * unidadeEscolaDAO.consultarUnidadeEscolaPorId(2L);
		 * unidadeEscola.getCursosUnidade().add(curso);
		 * curso.getUnidadesEscolares().add(unidadeEscola);
		 * 
		 * unidadeEscolaDAO.atualizar(unidadeEscola);
		 */

		// Cadastro
		/*
		 * // Empresa empresa.getUnidadesEscolares().add(unidade1);
		 * empresa.getUnidadesEscolares().add(unidade2); unidade1.setEmpresa(empresa);
		 * unidade2.setEmpresa(empresa);
		 * 
		 * // Unidade 1 // Professor unidade1.getProfessores().add(professor1);
		 * unidade1.getProfessores().add(professor2);
		 * professor1.getUnidadesEscolas().add(unidade1);
		 * professor2.getUnidadesEscolas().add(unidade1); // Curso
		 * unidade1.getCursosUnidade().add(curso1);
		 * unidade1.getCursosUnidade().add(curso2);
		 * curso1.getUnidadesEscolares().add(unidade1);
		 * curso2.getUnidadesEscolares().add(unidade1);
		 * 
		 * // Unidade 2 // Professor unidade2.getProfessores().add(professor1);
		 * professor1.getUnidadesEscolas().add(unidade2); // Curso
		 * unidade2.getCursosUnidade().add(curso1);
		 * curso1.getUnidadesEscolares().add(unidade2);
		 * 
		 * // Curso 1 curso1.getPeriodosCursos().add(periodoCurso1);
		 * curso1.getPeriodosCursos().add(periodoCurso2);
		 * curso1.getPeriodosCursos().add(periodoCurso3);
		 * curso1.getPeriodosCursos().add(periodoCurso4);
		 * periodoCurso1.setCurso(curso1); periodoCurso2.setCurso(curso1);
		 * periodoCurso3.setCurso(curso1); periodoCurso4.setCurso(curso1);
		 * 
		 * // Curso 2 curso2.getPeriodosCursos().add(periodoCurso1);
		 * curso2.getPeriodosCursos().add(periodoCurso2);
		 * periodoCurso1.setCurso(curso2); periodoCurso2.setCurso(curso2);
		 * 
		 * // Periodos periodoCurso1.getDisciplinasOferecidas().add(disciplina1);
		 * disciplina1.setPeriodoCurso(periodoCurso1);
		 * periodoCurso2.getDisciplinasOferecidas().add(disciplina2);
		 * disciplina2.setPeriodoCurso(periodoCurso2);
		 * periodoCurso3.getDisciplinasOferecidas().add(disciplina3);
		 * disciplina3.setPeriodoCurso(periodoCurso3);
		 * periodoCurso4.getDisciplinasOferecidas().add(disciplina4);
		 * disciplina4.setPeriodoCurso(periodoCurso4);
		 * 
		 * // Aluno 1 curso1.getAlunos().add(aluno1); curso1.getAlunos().add(aluno2);
		 * aluno1.getCursos().add(curso1); aluno2.getCursos().add(curso1);
		 * 
		 * // Aluno 2 curso2.getAlunos().add(aluno2); aluno2.getCursos().add(curso2);
		 */

		// empresaDAO.cadastrar(empresa);

		// Consultas
		/*
		 * List<Empresa> empresas = empresaDAO.consultarTodas(); empresas.forEach(e ->
		 * System.out.println(e));
		 * 
		 * List<UnidadeEscola> unidadesEscolares = unidadeEscolaDAO.consultarTodas();
		 * unidadesEscolares.forEach(uE -> System.out.println(uE));
		 * 
		 * List<Professor> professores = professorDAO.consultarTodas();
		 * professores.forEach(p -> System.out.println(p));
		 * 
		 * List<Curso> cursos = cursoDAO.consultarTodas(); cursos.forEach(c ->
		 * System.out.println(c));
		 * 
		 * List<Aluno> alunos = alunoDAO.consultarTodas(); alunos.forEach(a ->
		 * System.out.println(a));
		 * 
		 * List<PeriodoCurso> periodosCursos = periodoCursoDAO.consultarTodas();
		 * periodosCursos.forEach(pC -> System.out.println(pC));
		 * 
		 * List<DisciplinaOferecida> disciplinasOferecidas =
		 * disciplinaOferecidaDAO.consultarTodas(); disciplinasOferecidas.forEach(dO ->
		 * System.out.println(dO));
		 * 
		 * List<UnidadeEscola> unidadesEscolaresEmpresa =
		 * empresaDAO.consultarUnidadesEscolaresPorId(1L);
		 * System.out.println(unidadesEscolaresEmpresa);
		 * 
		 * 
		 * List<UnidadeEscola> professor1Unidades =
		 * professorDAO.consultarUnidadesProfessorPorId(1L);
		 * professor1Unidades.forEach(pU -> System.out.println(pU));
		 * 
		 * List<UnidadeEscola> professor2Unidades =
		 * professorDAO.consultarUnidadesProfessorPorId(2L);
		 * professor2Unidades.forEach(pU -> System.out.println(pU));
		 */

	}
}
