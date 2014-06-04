package com.gridpoint.energy.domainmodel;


import java.io.Serializable;
import java.util.List;

public class Palette implements Serializable {
 
	private long id;
	private String name;
	List<String> colors;
	
	private static final long serialVersionUID = 3283532987240918213L;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getColors() {
		return this.colors;
	}
	
	public void setColors(List<String> colors) {
		this.colors = colors;
	}
}
