package com.demo.dto;

public class BillItemDto {
    private String id;
	
	private String code;
	
	private String name;
	
	private String materialId;
	
	private String materialCode;
	
	private String materialName;
	
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

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Override
	public String toString() {
		return "BillItemDto [id=" + id + ", code=" + code + ", name=" + name + ", materialId=" + materialId
				+ ", materialCode=" + materialCode + ", materialName=" + materialName + "]";
	}
	
}
