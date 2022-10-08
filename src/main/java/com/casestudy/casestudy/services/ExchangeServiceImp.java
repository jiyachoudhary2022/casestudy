package com.casestudy.casestudy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.entities.Exchange;
import com.casestudy.casestudy.repo.IExchangeRepo;

@Service
public class ExchangeServiceImp implements IExchangeService {

	@Autowired
	private IExchangeRepo exchangeRepo;
	
	@Override
	public List<Exchange> getAllExchange() {
		// TODO Auto-generated method stub
		return exchangeRepo.findAll();
	}

	@Override
	public Exchange getExchangeById(Long Id) {
		// TODO Auto-generated method stub
		return exchangeRepo.findById(Id).get();
	}

	@Override
	public Exchange createExchange(Exchange exchange) {
		// TODO Auto-generated method stub
		return exchangeRepo.save(exchange);
	}

	@Override
	public boolean deleteExchnage(Long Id) {
		exchangeRepo.delete(exchangeRepo.findById(Id).get());
		return true;
	}

	@Override
	public Exchange updateExchange(Exchange exhange) {
		return exchangeRepo.save(exhange);
	}

}
