package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {
		Tio tia1 = new Tio("Maria");
		Tio tio2 = new Tio("João");
		
		Sobrinho sobrinho1 = new Sobrinho("Davi");
		Sobrinho sobrinho2 = new Sobrinho("Ana");
		
		tia1.getSobrinho().add(sobrinho1);
		sobrinho1.getTio().add(tia1);
		
		tia1.getSobrinho().add(sobrinho2);
		sobrinho2.getTio().add(tia1);
		
		tio2.getSobrinho().add(sobrinho1);
		sobrinho1.getTio().add(tio2);
		
		tio2.getSobrinho().add(sobrinho2);
		sobrinho2.getTio().add(tio2);
		
		DAO<Object> dao = new DAO<>();
		dao.abrirTransacao()
			.incluir(tia1)
			.incluir(tio2)
			.incluir(sobrinho1)
			.incluir(sobrinho2)
			.fecharTransacao()
			.fecharConexao();
	}

}
