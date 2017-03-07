package services;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface SubscriptionServiceRemote {
	void adduser(User user);

	User findUserById(Integer id);

	void deleteUser(Integer id);
	
	void updateUser(User user);

}
