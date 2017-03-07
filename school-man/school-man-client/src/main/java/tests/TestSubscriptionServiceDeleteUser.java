package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.SubscriptionServiceRemote;

public class TestSubscriptionServiceDeleteUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("school-man-ear/school-man-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		subscriptionServiceRemote.deleteUser(1);

	}

}
