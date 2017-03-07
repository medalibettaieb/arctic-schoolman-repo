package utilities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.Course;
import entities.Student;
import entities.Teacher;
import services.SubscriptionServiceLocal;

/**
 * Session Bean implementation class UtilApp
 */
@Singleton
@LocalBean
@Startup
public class UtilApp {

	@EJB
	private SubscriptionServiceLocal subscriptionServiceLocal;

	/**
	 * Default constructor.
	 */
	public UtilApp() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		Student student = new Student();
		student.setName("ahmed");
		student.setLevel("artic1");

		Student student2 = new Student();
		student2.setName("mohamed");
		student2.setLevel("artic1");

		Teacher teacher = new Teacher();
		teacher.setName("salah");
		teacher.setSalary(1000F);
		
		Course course = new Course("javaEE7");
		Course course2 = new Course("python");

		List<Course> courses = new ArrayList<>();
		courses.add(course);
		courses.add(course2);
		
		teacher.linkCoursesToThisUser(courses);

		subscriptionServiceLocal.adduser(teacher);
		subscriptionServiceLocal.adduser(student);
		subscriptionServiceLocal.adduser(student2);

	}
}
