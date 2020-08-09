package com.yao.crud.service.mapper.decorators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.demo.dto.BillItemDto;
import com.yao.crud.domain.BillItem;
import com.yao.crud.service.mapper.BillItemMapper;
import com.yao.crud.service.mapper.BillItemMapperImpl;

@Component
@Primary
public class BillItemMapperDecoratorDecorator implements BillItemMapper {

	@Autowired
	private ApplicationContext applicationContext;

	private BillItemMapper billItemMapper = null;

	private BillItemMapper getBillItemMapper() {
		if (null == billItemMapper) {
			billItemMapper = new BillItemMapperImpl();
			applicationContext.getAutowireCapableBeanFactory().autowireBean(billItemMapper);
		}
		return billItemMapper;
	}

	@Override
	public BillItemDto toDto(BillItem billItem) {
		BillItemDto billItemDto = getBillItemMapper().toDto(billItem);
		billItemDto.getMaterialId();
		billItemDto.setMaterialCode("enhanced " + billItemDto.getMaterialCode());
		billItemDto.setMaterialName("enhanced " + billItemDto.getMaterialName());
		return billItemDto;
	}

	@Override
	public BillItem toEntity(BillItemDto billItemDto) {
		return getBillItemMapper().toEntity(billItemDto);
	}
}
