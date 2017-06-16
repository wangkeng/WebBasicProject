package com.dubbo.common.base.model;

public abstract class BaseQueryParam {

	public int offset ;
	
	public int limit ;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
