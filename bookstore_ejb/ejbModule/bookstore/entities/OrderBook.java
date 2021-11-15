package bookstore.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_book database table.
 * 
 */
@Entity
@Table(name="order_book")
@NamedQuery(name="OrderBook.findAll", query="SELECT o FROM OrderBook o")
public class OrderBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="book_name")
	private String bookName;

	private double price;

	private int quantity;

	//bi-directional many-to-one association to Book
	@ManyToOne
	private Book book;

	//bi-directional many-to-one association to Order
	@ManyToOne
	private Order order;

	public OrderBook() {
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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}