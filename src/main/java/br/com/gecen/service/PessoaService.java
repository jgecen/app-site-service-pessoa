package br.com.gecen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gecen.model.Pessoa;
import br.com.gecen.model.ResponseModel;
import br.com.gecen.repository.PessoaRepository;
@CrossOrigin(origins  = {"http://localhost:4200", "http://192.168.200.22:4200"})
@RestController
@RequestMapping("/service")
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping(value = "/pessoa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
		return new ResponseModel(1, "Registro salvo com sucesso");
	}
	@RequestMapping(value = "/pessoa", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
		return new ResponseModel(1, "Registro salvo com sucesso");
	}
	@RequestMapping(value = "/pessoa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Pessoa> consultar() {
		return this.pessoaRepository.findAll();
	}
	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Pessoa buscar(@PathVariable("id") Integer id) {
		return this.pessoaRepository.getOne(id);
	}
	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Integer id) {
		Pessoa p = this.pessoaRepository.getOne(id);
		this.pessoaRepository.delete(p);
		return new ResponseModel(1, "Registro excluido com sucesso!");
	}
}
