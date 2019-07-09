package com.spring.test.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class JuiceMaker {

	private Source source;
	
	public JuiceMaker() {
		
	}
	@Autowired
	public JuiceMaker(Source source) {
		System.out.println("==============dasdas=========");
		this.source = source;
	}
	public Source getSource() {
		return source;
	}
	public void setSource(Source source) {
		this.source = source;
	}
	public String makeJuice() {
		String juice = "xxxxx"+source.getFruit()+source.getSize()+source.getSugar();
		return juice;
	}
}
