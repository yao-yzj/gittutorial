package com.demo.dto;

import java.util.Set;
import com.demo.dto.AgentDto;

public class BillDto {
    private String id;
	
	private String code;
	
	private String name;
	
	private String departmentId;
	
	private String departmentCode;
	
	private String departmentName;
	
	private AgentDto agentDto;
	
	private Set<BillItemDto> itemsDto;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	public AgentDto getAgent() {
		return agentDto;
	}

	public void setAgent(AgentDto agentDto) {
		this.agentDto = agentDto;
	}

	public Set<BillItemDto> getItems() {
		return itemsDto;
	}

	public void setItems(Set<BillItemDto> itemsDto) {
		this.itemsDto = itemsDto;
	}

	@Override
	public String toString() {
		return "BillDto [id=" + id + ", code=" + code + ", name=" + name + ", departmentId=" + departmentId
				+ ", departmentCode=" + departmentCode + ", departmentName=" + departmentName + "]";
	}
		
}
