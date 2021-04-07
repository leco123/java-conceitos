package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {

	public static void main(String[] args) {
		DAO<Aluno> alunoDAO = new DAO<>();
		Aluno aluno1 = new Aluno(123L, "João da Silva");
		AlunoBolsista aluno2 = new AlunoBolsista(345L, "Maria da maria", 1000);
		
		alunoDAO.incluirAtomico(aluno1);
		alunoDAO.incluirAtomico(aluno2);
		alunoDAO.fecharConexao();

	}

}
