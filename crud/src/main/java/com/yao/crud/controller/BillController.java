package com.yao.crud.controller;

import java.util.Optional;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

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

import com.demo.dto.BillDto;
import com.yao.crud.domain.Bill;
import com.yao.crud.domain.BillItem;
import com.yao.crud.repositories.BillItemRepository;
import com.yao.crud.repositories.BillRepository;
import com.yao.crud.service.mapper.BillMapper;

@Controller
@RequestMapping(value = "/bill")
public class BillController {

	@Autowired
	private BillMapper billMapper;

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private BillItemRepository billItemRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public String Create(@RequestBody BillDto billDto) {
		Bill bill = billMapper.toEntity(billDto);
		billRepository.save(bill);
		Set<BillItem> items = bill.getItems();
		//items.forEach(item -> billItemRepository.save(item));
		for(BillItem item:items) {
			item.setBill(bill);
			billItemRepository.save(item);
		}
		return billMapper.toDto(bill).getId();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void Delete(@PathVariable("id") String id) {
		billRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void Modify(@RequestBody BillDto billDto) {
		Bill bill = billMapper.toEntity(billDto);
		billRepository.save(bill);
		bill.getItems().forEach(item -> item.setBill(bill));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public BillDto findeOne(@PathVariable("id") String id) {
		Optional<Bill> bill = billRepository.findById(id);
		 bill.orElseThrow(() -> new RuntimeException("reocrd not exists"));
		 return billMapper.toDto(bill.get());
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<BillDto> findAll() {
		List<Bill> bills = billRepository.findAll();
		return bills.stream().map(bill -> billMapper.toDto(bill)).collect(Collectors.toList());
	}
}
