package com.menu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long Id; 
	
    private String menuName; 
    
    @Column(nullable = false)
    private int parentId;

	public long getId() {
		return Id;
	} 

	public void setId(long id) {
		Id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Menu(long id, String menuName, int parentId) {
		super();
		Id = id;
		this.menuName = menuName;
		this.parentId = parentId;
	}

	public Menu() {

	}
    
    
    
    
   
}
