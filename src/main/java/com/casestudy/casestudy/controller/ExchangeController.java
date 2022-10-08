package com.casestudy.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.casestudy.entities.Exchange;
import com.casestudy.casestudy.services.IExchangeService;

@RestController
public class ExchangeController {

	@Autowired
	private IExchangeService exchangeService;

	@GetMapping("/getAllExchange")
	public List<Exchange> GetAll() {
		return this.exchangeService.getAllExchange();
	}

	@GetMapping("/getExchangeById/{Id}")
	public Exchange Get(@PathVariable Long Id) {
		return this.exchangeService.getExchangeById(Id);
	}

	@PostMapping("/createExchange")
	public ResponseEntity<Exchange> Create(@RequestBody Exchange exchange) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.exchangeService.createExchange(exchange));
	}

	@PutMapping("/updateExchange")
	public ResponseEntity<String> Update(@RequestBody Exchange exchange) {
		if (exchange.getId() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("No Data Id Found !");
		}
		Exchange dt = exchangeService.getExchangeById(exchange.getId());
		if (dt != null) {
			dt.setName(exchange.getName());
			dt.setSymbol(exchange.getSymbol());
			dt.setCountry(exchange.getCountry());
			exchangeService.updateExchange(dt);
			return ResponseEntity.status(HttpStatus.OK).body("Updated !");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Found With This Id In Database !");
		}
	}

	@DeleteMapping("/deleteExchange/{Id}")
	public ResponseEntity<Boolean> Delete(@PathVariable Long Id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.exchangeService.deleteExchnage(Id));
	}
}
