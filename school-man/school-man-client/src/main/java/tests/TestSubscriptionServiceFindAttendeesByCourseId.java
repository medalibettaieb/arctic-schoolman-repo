package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import services.SubscriptionServiceRemote;

public class TestSubscriptionServiceFindAttendeesByCourseId {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("school-man-ear/school-man-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		List<Course> courses = subscriptionServiceRemote.findCoursesByUserId(2);

		System.out.println(courses.size());

	}

}
