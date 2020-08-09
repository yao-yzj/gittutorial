package com.yao.crud.service.mapper.decorators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.demo.dto.BillDto;

import com.yao.crud.domain.Bill;
import com.yao.crud.service.mapper.BillMapper;
import com.yao.crud.service.mapper.BillMapperImpl;

@Component
@Primary
public class BiilMapperDecoratorDecorator implements BillMapper {

	@Autowired
	private ApplicationContext applicationContext;

	private BillMapper billMapper = null;

	private BillMapper getBillMapper() {
		if (null == billMapper) {
			billMapper = new BillMapperImpl();
			applicationContext.getAutowireCapableBeanFactory().autowireBean(billMapper);
		}
		return billMapper;
	}

	@Override
	public BillDto toDto(Bill bill) {
		BillDto billDto = getBillMapper().toDto(bill);
		billDto.getDepartmentId();
		billDto.setDepartmentCode("enhanced " + billDto.getDepartmentCode());
		billDto.setDepartmentName("enhanced " + billDto.getDepartmentName());
		return billDto;
	}

	@Override
	public Bill toEntity(BillDto billDto) {
		return getBillMapper().toEntity(billDto);
	}

}
