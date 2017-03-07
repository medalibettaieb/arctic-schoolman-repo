package services;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface SubscriptionServiceLocal {
	void adduser(User user);

	User findUserById(Integer id);

	void deleteUser(Integer id);
	
	void updateUser(User user);
	
	List<User>findAllUsers();
}
