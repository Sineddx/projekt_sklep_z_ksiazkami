package bookstore.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jsf.entities.Person;

import bookstore.entities.User;

@Stateless
public class UserDAO {
	private final static String UNIT_NAME = "bookstore_simplePU";
	
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;
	
	public void create(User user) {
		em.persist(user);
	}

	public User merge(User user) {
		return em.merge(user);
	}

	public void remove(User user) {
		em.remove(em.merge(user));
	}

	public User find(Object uid) {
		return em.find(User.class, uid);
	}
	
	public Boolean getUser(String email) {
		Object answer = null;
		Query query = em.createQuery("select p from User p where p.email = :email");
		
		query.setParameter("email", email);
		
		try {
			answer = (Object)query.getSingleResult();
		}catch(Exception e) {
			
		}
		if(answer==null) {
			System.out.println(answer);
			return true;
		}else {
			return false;
		}
	}

	
}
