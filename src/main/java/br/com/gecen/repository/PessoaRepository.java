package br.com.gecen.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.gecen.model.Pessoa;

public interface PessoaRepository extends Repository<Pessoa, Integer> {

	void save(Pessoa pessoa);
	
	void delete(Pessoa pessoa);
	
	List<Pessoa> findAll();
	
	Pessoa getOne(Integer id);
}
