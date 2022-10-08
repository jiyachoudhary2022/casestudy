package com.casestudy.casestudy.services;

import java.util.List;

import com.casestudy.casestudy.entities.Exchange;

public interface IExchangeService {
	public List<Exchange> getAllExchange();
	public Exchange getExchangeById(Long Id);
	public Exchange createExchange(Exchange exhange);
	public boolean deleteExchnage(Long Id);
	public Exchange updateExchange(Exchange exhange);
}
