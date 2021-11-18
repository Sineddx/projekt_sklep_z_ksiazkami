package com.user;




import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import bookstore.dao.UserDAO;
import bookstore.entities.User;

@Named
@RequestScoped
public class UserRegisterBB {
	
	private static final String PAGE_STAY_AT_THE_SAME = null;
	private User user = new User();
	private String repwd;
	private String role = "user";
	/* private String email; */
	
	
	public String getRepwd() {
		return repwd;
	}

	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}

	
	public User getUser() {
		return user;
	}



	/*
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 */



	@EJB
	UserDAO userDAO;
	
	@Inject
	FacesContext context;
	
	public String saveUser() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		
		user.setRole(role);
		user.setRegisterDate(date);
		String email = user.getEmail();
		
		if(userDAO.getUser(email)) 
		{
			if(checkPwd()) 
			{
				try 
				{
					userDAO.create(user);				
				}catch(Exception e) 
					{
						e.printStackTrace();
						context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³¹d podczas rejestracji", null));
							return PAGE_STAY_AT_THE_SAME;
					}
			}
		}
		else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email jest ju¿ w bazie!", null));
		}
			
			return PAGE_STAY_AT_THE_SAME;

	}
	
	public Boolean checkPwd() {
		String password = user.getPassword();
		if(password.equals(repwd)) {
			return true;
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Has³a siê nie zgadzaj¹!", null));
			return false;
		}
	}

}
