package com.yao.crud.service.mapper.decorators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.demo.dto.BillDto;
import com.yao.crud.domain.Bill;
import com.yao.crud.service.mapper.BillMapper;

public class BillMapperDecorator implements BillMapper{
	
	@Autowired
	@Qualifier("delegate")
	private BillMapper billMapper;
	
	@Override
	public BillDto toDto(Bill bill) {
		BillDto billDto = billMapper.toDto(bill);
		billDto.getDepartmentId();
		billDto.setDepartmentCode("IT");
		billDto.setDepartmentName("IT部");
		return billDto;
	}

	@Override
	public Bill toEntity(BillDto billDto) {
		return billMapper.toEntity(billDto);
	}

}
