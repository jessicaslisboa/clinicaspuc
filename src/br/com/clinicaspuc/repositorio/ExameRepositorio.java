package br.com.clinicaspuc.repositorio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.clinicaspuc.dao.ExameDAO;
import br.com.clinicaspuc.model.Exame;

@Stateless
public class ExameRepositorio {

	@EJB
	private ExameDAO exameDAO;

	public List<Exame> getAll() {
		return exameDAO.findAll();
	}

	public Exame salvar(Exame exame) {
		return exameDAO.save(exame);
	}

	public Exame obterPorId(Integer codigo) {
		return exameDAO.findById(codigo);
	}

	public void delete(Exame m) {
		exameDAO.remove(m);		
	}

}	
