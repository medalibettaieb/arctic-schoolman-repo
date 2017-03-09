package services;

import java.util.List;

import javax.ejb.Local;

import entities.Course;
import entities.User;

@Local
public interface SubscriptionServiceLocal {
	void adduser(User user);

	User findUserById(Integer id);

	void deleteUser(Integer id);

	void updateUser(User user);

	List<User> findAllUsers();

	List<Course> findAllCourses();

	Course findCourseById(Integer id);

	void updateCourse(Course course);

	List<Course> findCoursesByUserId(Integer id);

	void subscribeAttendeesToCourse(List<User> attendees, Integer idCourse);
}
