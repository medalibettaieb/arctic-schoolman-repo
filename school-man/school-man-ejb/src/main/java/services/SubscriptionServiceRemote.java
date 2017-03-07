package services;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface SubscriptionServiceRemote {
	void adduser(User user);

}
