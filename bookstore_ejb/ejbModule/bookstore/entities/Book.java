package bookstore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookid;

	@Column(name="author_name")
	private String authorName;

	@Column(name="book_name")
	private String bookName;

	private String cover;

	@Lob
	private String description;

	private String genre;

	private String image;

	private String publisher;

	private int quantity;

	@Column(name="release_date")
	private String releaseDate;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="book")
	private List<Comment> comments;

	//bi-directional many-to-one association to OrderBook
	@OneToMany(mappedBy="book")
	private List<OrderBook> orderBooks;

	//bi-directional many-to-one association to WishItem
	@OneToMany(mappedBy="book")
	private List<WishItem> wishItems;

	public Book() {
	}

	public int getBookid() {
		return this.bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setBook(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setBook(null);

		return comment;
	}

	public List<OrderBook> getOrderBooks() {
		return this.orderBooks;
	}

	public void setOrderBooks(List<OrderBook> orderBooks) {
		this.orderBooks = orderBooks;
	}

	public OrderBook addOrderBook(OrderBook orderBook) {
		getOrderBooks().add(orderBook);
		orderBook.setBook(this);

		return orderBook;
	}

	public OrderBook removeOrderBook(OrderBook orderBook) {
		getOrderBooks().remove(orderBook);
		orderBook.setBook(null);

		return orderBook;
	}

	public List<WishItem> getWishItems() {
		return this.wishItems;
	}

	public void setWishItems(List<WishItem> wishItems) {
		this.wishItems = wishItems;
	}

	public WishItem addWishItem(WishItem wishItem) {
		getWishItems().add(wishItem);
		wishItem.setBook(this);

		return wishItem;
	}

	public WishItem removeWishItem(WishItem wishItem) {
		getWishItems().remove(wishItem);
		wishItem.setBook(null);

		return wishItem;
	}

}