package bookstore.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	
	
}
