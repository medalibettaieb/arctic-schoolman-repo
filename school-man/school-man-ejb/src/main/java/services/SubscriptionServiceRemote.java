package services;

import java.util.List;

import javax.ejb.Remote;

import entities.Course;
import entities.User;

@Remote
public interface SubscriptionServiceRemote {
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
