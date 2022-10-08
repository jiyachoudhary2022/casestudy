package com.casestudy.casestudy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.casestudy.entities.Exchange;

public interface IExchangeRepo extends JpaRepository<Exchange, Long> {

}
