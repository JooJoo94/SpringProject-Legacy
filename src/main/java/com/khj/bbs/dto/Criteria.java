package com.khj.bbs.dto;

public class Criteria {
	
	private int page;
	private int perPageNum;
	private String type;
	private String keyword;
	
	public Criteria() {
		this.page=1;
		this.perPageNum=10;
	}
	
	public Criteria(int page, int perPageNum) {
		this.page=page;
		this.perPageNum=perPageNum;
	}
	
	public String [] getTypeArr() {
		// type이 null이면 String을 새로 생성하고, 여러개가 들어오면 split해서 배열에 넣는다
		System.out.println(type);
		return type==null?new String[] {}:type.split("");
	}	
	
	
	public void setType(String type) {
		this.type = type;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page=1;
			return;
		}
		this.page=page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum=10;
			return;
		}
		this.perPageNum=perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

}
