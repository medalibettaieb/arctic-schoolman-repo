package tests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import entities.Student;
import entities.User;
import services.SubscriptionServiceRemote;

public class TestSubscriptionServiceAssignAttendeesToCourse {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("school-man-ear/school-man-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		Student student = (Student) subscriptionServiceRemote.findUserById(2);
		Student student2 = (Student) subscriptionServiceRemote.findUserById(3);

		List<User> attendees = new ArrayList<>();
		attendees.add(student);
		attendees.add(student2);

		Course course = subscriptionServiceRemote.findCourseById(1);
		course.linkAttendeesToThisCourse(attendees);

		subscriptionServiceRemote.updateCourse(course);

	}

}
