package com.demo.dto;

public class AgentDto {
    private String id;
	
	private String code;
	
	private String name;
	
	private String person;

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

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "AgentDto [id=" + id + ", code=" + code + ", name=" + name + ", person=" + person + "]";
	}

}
