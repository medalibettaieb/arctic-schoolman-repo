package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Course;
import entities.User;

/**
 * Session Bean implementation class SubscriptionService
 */
@Stateless
public class SubscriptionService implements SubscriptionServiceRemote, SubscriptionServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SubscriptionService() {
	}

	@Override
	public void adduser(User user) {
		entityManager.persist(user);
	}

	@Override
	public User findUserById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void deleteUser(Integer id) {
		entityManager.remove(findUserById(id));
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public List<User> findAllUsers() {
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public List<Course> findAllCourses() {
		return entityManager.createQuery("select c from Course c", Course.class).getResultList();
	}

	@Override
	public Course findCourseById(Integer id) {
		return entityManager.find(Course.class, id);
	}

	@Override
	public void updateCourse(Course course) {
		entityManager.merge(course);
	}

	@Override
	public List<Course> findCoursesByUserId(Integer id) {
		// User userFound = findUserById(id);
		// return entityManager.createQuery("select c from Course c where :param
		// member of c.attendees", Course.class)
		// .setParameter("param", userFound).getResultList();
		return entityManager
				.createQuery("select c from Course c inner join c.attendees cas where cas.id=:param", Course.class)
				.setParameter("param", id).getResultList();
	}

	@Override
	public void subscribeAttendeesToCourse(List<User> attendees, Integer idCourse) {
		Course course = findCourseById(idCourse);
		for (User u : attendees) {
			List<Course> courses = findCoursesByUserId(u.getId());
			courses.add(course);
			u.setCoursesAttended(courses);
			updateUser(u);
		}

	}

}
