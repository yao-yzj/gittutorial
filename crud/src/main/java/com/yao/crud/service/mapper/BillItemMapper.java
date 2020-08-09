package com.yao.crud.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.demo.dto.BillItemDto;
import com.yao.crud.domain.BillItem;
import com.yao.crud.service.mapper.decorators.BillItemMapperDecorator;

@DecoratedWith(BillItemMapperDecorator.class)
@Mapper(componentModel = "spring")
public interface BillItemMapper {

	@Mapping(source = "material", target = "materialId")
	BillItemDto toDto(BillItem billItem);
	
	@Mapping(source = "materialId", target = "material")
	BillItem toEntity(BillItemDto billItemDto);

}
