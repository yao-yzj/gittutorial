package com.yao.crud.service.mapper.decorators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.demo.dto.BillDto;
import com.yao.crud.domain.Bill;
import com.yao.crud.service.mapper.BillMapper;

@Component
@Qualifier("enhanced")
public class BiilMapperDecoratorDecorator implements BillMapper {

	@Autowired
	private BillMapper billMapper;

	@Override
	public BillDto toDto(Bill bill) {
		BillDto billDto = billMapper.toDto(bill);
		billDto.getDepartmentId();
		billDto.setDepartmentCode("enhanced " + billDto.getDepartmentCode());
		billDto.setDepartmentName("enhanced " + billDto.getDepartmentName());
		return billDto;
	}

	@Override
	public Bill toEntity(BillDto billDto) {
		return billMapper.toEntity(billDto);
	}

}
