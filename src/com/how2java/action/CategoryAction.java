package com.how2java.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.dao.CategoryDao;
import com.how2java.pojo.Category;

public class CategoryAction {
	CategoryDao cd=new CategoryDao();
	Category category;
	List<Category>categorys;
	public CategoryDao getCd() {
		return cd;
	}
	public void setCd(CategoryDao cd) {
		this.cd = cd;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public String add() {
		cd.add(category);
		return "list";
	}
	public String edit() {
		category =cd.get(category.getId());
		return "edit";
	}
	public String delete() {
		cd.delete(category.getId());
		return "list";
	}
	public String update() {
		cd.update(category);
		return "list";
	}
	public String list() {
		categorys = cd.list();
		return "listJsp";
	}
}
