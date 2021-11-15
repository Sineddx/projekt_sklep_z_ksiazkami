package bookstore.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import bookstore.entities.Book;

@Stateless
public class BookDAO {
private final static String UNIT_NAME = "bookstore_simplePU";
	
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(Book book) {
		em.persist(book);
	}

	public Book merge(Book book) {
		return em.merge(book);
	}

	public void remove(Book book) {
		em.remove(em.merge(book));
	}

	public Book find(Object bookid) {
		return em.find(Book.class, bookid);
	}
	
	public List<Book> getFullList() {
		List<Book> list = null;

		Query query = em.createQuery("select p from Book p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Book> getList(Map<String, Object> searchParams) {
		List<Book> list = null;

		// 1. Build query string with parameters
		String select = "select p ";
		String from = "from Book p ";
		String where = "";


		// 2. Create query object
		Query query = em.createQuery(select + from + where );

		// 4. Execute query and retrieve list of Person objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
		
}
