package tests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import entities.Teacher;
import services.SubscriptionServiceRemote;

public class TestSubscriptionServiceAssignCoursesToCoach {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("school-man-ear/school-man-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		Course course = new Course("javaEE7");
		Course course2 = new Course("python");

		List<Course> courses = new ArrayList<>();
		courses.add(course);
		courses.add(course2);

		Teacher teacherFound = (Teacher) subscriptionServiceRemote.findUserById(1);

		teacherFound.linkCoursesToThisUser(courses);

		subscriptionServiceRemote.updateUser(teacherFound);

	}

}
