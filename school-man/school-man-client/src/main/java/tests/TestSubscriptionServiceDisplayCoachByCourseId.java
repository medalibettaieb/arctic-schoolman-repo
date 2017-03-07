package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import services.SubscriptionServiceRemote;

public class TestSubscriptionServiceDisplayCoachByCourseId {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("school-man-ear/school-man-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		Course course = subscriptionServiceRemote.findCourseById(1);

		System.out.println(course.getCoach().getName());

	}

}
