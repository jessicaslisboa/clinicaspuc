package br.com.clinicaspuc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "consulta", schema = "clinicaspuc")
public class Consulta {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta_codigo_seq" )
	@SequenceGenerator(name = "consulta_codigo_seq", allocationSize = 1, sequenceName = ("clinicaspuc.consulta_codigo_seq"))
	@Column(name = "codigo", unique = true, nullable = false)	
	private Integer codigo;
	
	//private Paciente paciente;
	
	//private Agenda agenda;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


		
}
