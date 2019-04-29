package br.com.ctis.hackathon.service;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.dto.EmpresaDTO;
import br.com.ctis.hackathon.persistence.model.Empresa;

@Local
public interface EmpresaService extends GenericService<Long,Empresa> {
	
	List<Empresa> listarTodos();
	
	void cadastrar(EmpresaDTO empresaDTO);
	
	Empresa buscarEmpresaPorId(Long id);
	
	void atualizar(Long id, EmpresaDTO empresaDTO);
	
	
}
