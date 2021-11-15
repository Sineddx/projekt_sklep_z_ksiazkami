package bookstore.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int likes;

	@Lob
	private String value;

	//bi-directional many-to-one association to Book
	@ManyToOne
	private Book book;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Comment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLikes() {
		return this.likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}