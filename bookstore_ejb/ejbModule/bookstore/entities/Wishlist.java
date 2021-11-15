package bookstore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the wishlist database table.
 * 
 */
@Entity
@NamedQuery(name="Wishlist.findAll", query="SELECT w FROM Wishlist w")
public class Wishlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wishid;

	private String name;

	//bi-directional many-to-one association to WishItem
	@OneToMany(mappedBy="wishlist")
	private List<WishItem> wishItems;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Wishlist() {
	}

	public int getWishid() {
		return this.wishid;
	}

	public void setWishid(int wishid) {
		this.wishid = wishid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WishItem> getWishItems() {
		return this.wishItems;
	}

	public void setWishItems(List<WishItem> wishItems) {
		this.wishItems = wishItems;
	}

	public WishItem addWishItem(WishItem wishItem) {
		getWishItems().add(wishItem);
		wishItem.setWishlist(this);

		return wishItem;
	}

	public WishItem removeWishItem(WishItem wishItem) {
		getWishItems().remove(wishItem);
		wishItem.setWishlist(null);

		return wishItem;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}