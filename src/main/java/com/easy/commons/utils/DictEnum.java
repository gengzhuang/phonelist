package com.easy.commons.utils;

public enum DictEnum {
	Dict1("类型1",""),Dict2("类型2",""),Dict3("类型3","");
	
	private String dictName;
	private String dictValue;
	
	private DictEnum(String dictName, String dictValue) {
		this.dictName = dictName;
		this.dictValue = dictValue;
	}
	
}
