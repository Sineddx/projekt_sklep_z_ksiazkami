package bookstore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private double price;

	private String status;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to OrderBook
	@OneToMany(mappedBy="order")
	private List<OrderBook> orderBooks;

	public Order() {
	}

	public int getOid() {
		return this.oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderBook> getOrderBooks() {
		return this.orderBooks;
	}

	public void setOrderBooks(List<OrderBook> orderBooks) {
		this.orderBooks = orderBooks;
	}

	public OrderBook addOrderBook(OrderBook orderBook) {
		getOrderBooks().add(orderBook);
		orderBook.setOrder(this);

		return orderBook;
	}

	public OrderBook removeOrderBook(OrderBook orderBook) {
		getOrderBooks().remove(orderBook);
		orderBook.setOrder(null);

		return orderBook;
	}

}