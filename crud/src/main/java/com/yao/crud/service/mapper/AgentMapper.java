package com.yao.crud.service.mapper;

import org.mapstruct.Mapper;

import com.demo.dto.AgentDto;
import com.yao.crud.domain.Agent;

@Mapper(componentModel = "spring")
public interface AgentMapper {
	
	AgentDto toDto (Agent agent);
	
	Agent toEntity(AgentDto agentDto);
}
