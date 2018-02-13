package com.pontointeligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pontointeligente.api.entities.Lancamento;
import com.pontointeligente.api.repositories.LancamentoRepository;
import com.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	private static final Logger log = LoggerFactory.getLogger(Lancamento.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
			
	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long idFuncionario, PageRequest pageRequest) {
		log.info("Buscando lançamentos para o funcionário ID:{}", idFuncionario);
		return this.lancamentoRepository.findByFuncionarioId(idFuncionario, pageRequest);
	}

	@Override
	public Optional<Lancamento> buscaPorId(Long id) {
		log.info("Buscando um lançamento pelo ID:{}", id);
		return Optional.ofNullable(this.lancamentoRepository.findOne(id));
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persistindo o lançamento {}", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Excluindo o lançamento ID:{}", id);
		this.lancamentoRepository.delete(id);
	}

}
