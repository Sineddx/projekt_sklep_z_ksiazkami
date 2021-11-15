package bookstore.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wish_item database table.
 * 
 */
@Entity
@Table(name="wish_item")
@NamedQuery(name="WishItem.findAll", query="SELECT w FROM WishItem w")
public class WishItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="book_name")
	private String bookName;

	//bi-directional many-to-one association to Book
	@ManyToOne
	private Book book;

	//bi-directional many-to-one association to Wishlist
	@ManyToOne
	private Wishlist wishlist;

	public WishItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Wishlist getWishlist() {
		return this.wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

}