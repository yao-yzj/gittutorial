package com.yao.crud.service.mapper.decorators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.demo.dto.BillItemDto;
import com.yao.crud.domain.BillItem;
import com.yao.crud.service.mapper.BillItemMapper;


public class BillItemMapperDecorator implements BillItemMapper {

	@Autowired
	@Qualifier("delegate")
	private BillItemMapper billItemMapper;

	@Override
	public BillItemDto toDto(BillItem billItem) {
		BillItemDto billItemDto = billItemMapper.toDto(billItem);
		billItemDto.getMaterialId();
		billItemDto.setMaterialCode("JS");
		billItemDto.setMaterialName("金属");
		return billItemDto;
	}

	@Override
	public BillItem toEntity(BillItemDto billItemDto) {
		return billItemMapper.toEntity(billItemDto);
	}

}
