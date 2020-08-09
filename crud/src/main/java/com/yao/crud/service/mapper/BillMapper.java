package com.yao.crud.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.demo.dto.BillDto;
import com.yao.crud.domain.Bill;

@Mapper(componentModel = "spring", uses = { BillItemMapper.class, AgentMapper.class })
public interface BillMapper {

	@Mapping(source = "department", target = "departmentId")
	BillDto toDto(Bill bill);

	@Mapping(source = "departmentId", target = "department")
	Bill toEntity(BillDto billDto);
}
