package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import services.SubscriptionServiceRemote;

public class TestSubscriptionServiceFindAllUsers {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("school-man-ear/school-man-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		List<User> users = subscriptionServiceRemote.findAllUsers();

		for (User u : users) {
			System.out.println(u.getName());
		}

	}

}
