package br.com.clinicaspuc.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.clinicaspuc.model.Agenda;
import br.com.clinicaspuc.model.Consulta;
import br.com.clinicaspuc.model.Exame;
import br.com.clinicaspuc.repositorio.AgendaRepositorio;
import br.com.clinicaspuc.repositorio.ConsultaRepositorio;
import br.com.clinicaspuc.repositorio.ExameRepositorio;

@Stateless
public class ConsultaService {

	@EJB
	private ConsultaRepositorio consultaRepositorio;
	
	@EJB
	private AgendaRepositorio agendaRepositorio;
	
	@EJB
	private ExameRepositorio exameRepositorio;
	
	public List<Consulta> obterConsultas() {
		return consultaRepositorio.list();
	}

	public Consulta salvar(Consulta consulta) {
		Agenda agenda = agendaRepositorio.obterPorId(consulta.getAgenda().getCodigo());
		agenda.setDisponivel(false);
		agenda = agendaRepositorio.salvar(agenda);
		
		Consulta c = consultaRepositorio.salvar(consulta);
		return c;
	
	}
	
	public Consulta obterPorId(Integer codigo) {
		return consultaRepositorio.obterPorId(codigo);
	}

	public void delete(Consulta c) {
		Agenda agenda = agendaRepositorio.obterPorId(c.getAgenda().getCodigo());
		agenda.setDisponivel(true);
		agenda = agendaRepositorio.salvar(agenda);

		consultaRepositorio.delete(c);		
	}

	public List<Consulta> oberPorPaciente(int codPaciente) {
		return consultaRepositorio.oberPorPaciente(codPaciente);
	}
	
	public List<Consulta> obterConsultasNaoRealizadas(){
		return consultaRepositorio.obterNaoRealizadas();
	}

	public List<Exame> listaExames() {
		return exameRepositorio.getAll();
	}

}	
