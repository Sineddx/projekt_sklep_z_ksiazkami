package com.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;


import bookstore.dao.BookDAO;
import bookstore.entities.Book;

@Named
@RequestScoped
public class BookListBB {

	private String book_name;
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	BookDAO bookdao;

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	
	

	public List<Book> getFullList(){
		return bookdao.getFullList();
	}
	
	public List<Book> getList(){
		List<Book> list = null;
		
		//1. Prepare search params
		Map<String,Object> searchParams = new HashMap<String, Object>();
		

		list = bookdao.getList(searchParams);
		
		return list;
	}
	
}

