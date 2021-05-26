package com.menu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menu.model.Menu;
import com.menu.repos.MenuRepos;

@RestController
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private MenuRepos menuRepos;
	
	
//To get all Menu details
	@GetMapping("/allmenu")
	public List<Menu> getAllMenu()
	{         
		return menuRepos.findAll();
			
	}
	
	//To Add New menu or Categories
	@PostMapping("/addmenu")
	public Menu addMenu(@RequestBody Menu menu)
	{
		Menu addmenu= menuRepos.save(menu);
		
		return addmenu;
	}
	
	
	@DeleteMapping("/delete/{menuname}")
	public void deleteMenu(@PathVariable String menuname) {
		menuRepos.deleteByMenu(menuname);
	}
	
	
	// To Delete the Menu Or Categories
	@DeleteMapping("/delete/{id}")
	public void deleteMenu(@PathVariable long id) {
		menuRepos.deleteById(id);
	}
	
	// To Delete the  Sub-Categories
	@DeleteMapping("/delete/{parentid}")
	public void deleteSubCat(@PathVariable int parentid) {
		menuRepos.deleteByParentId(parentid);
	}
	
	//To do any update on menu
	@PutMapping("/update/{id}")  
	public Menu updateMenu(@RequestBody Menu menu,long id)   
	{  
		
		Optional<Menu> menu1=menuRepos.findById(id);
		return menuRepos.save(menu);
		
	}  
	
	
	//To do any update on menu's Subcat
		@PutMapping("/update/{id}/{parentid}")  
		public Menu updateSub(@RequestBody Menu menu,long id,int Parentid)   
		{  
			Menu sub= menuRepos.findByIdAndParentId(id,Parentid);
			return menuRepos.save(menu);
			
		}  
	
	
}
