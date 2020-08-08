package com.yao.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yao.crud.domain.Bill;
import com.yao.crud.repositories.BillRepository;

@Controller
@RequestMapping(value="/bill")
public class BillController {
	
	@Autowired
	private BillRepository billRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public String Create(@RequestBody Bill bill) {
		billRepository.save(bill);
		bill.getItems().forEach(item -> item.setBill(bill));
		return bill.getId();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void Delete(@PathVariable("id") String id) {
		billRepository.deleteById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void Modify(@RequestBody Bill bill) {
		billRepository.save(bill);
		bill.getItems().forEach(item -> item.setBill(bill));
	}
	
	//查询单个数据
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Bill findeOne(@PathVariable("id") String id) {
		Optional<Bill> bill=billRepository.findById(id);
		//bill.get().getItems().forEach(item -> item.setBill(bill));
		
		return bill.orElseThrow(() -> new RuntimeException("reocrd not exists"));	
	}
	
	//查询所有数据
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Bill> findAll(){
		List<Bill> bills=billRepository.findAll();
		return bills;
	}
}
