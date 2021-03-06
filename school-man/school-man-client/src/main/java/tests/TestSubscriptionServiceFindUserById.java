package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Student;
import services.SubscriptionServiceRemote;

public class TestSubscriptionServiceFindUserById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("school-man-ear/school-man-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		Student studentFound = (Student) subscriptionServiceRemote.findUserById(2);

		System.out.println(studentFound.getName());

	}

}
