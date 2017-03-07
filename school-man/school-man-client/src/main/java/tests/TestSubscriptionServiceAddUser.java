package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Student;
import entities.Teacher;
import services.SubscriptionServiceRemote;

public class TestSubscriptionServiceAddUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		SubscriptionServiceRemote subscriptionServiceRemote = (SubscriptionServiceRemote) context
				.lookup("school-man-ear/school-man-ejb/SubscriptionService!services.SubscriptionServiceRemote");

		Student student = new Student();
		student.setName("ahmed");
		student.setLevel("artic1");

		Student student2 = new Student();
		student2.setName("mohamed");
		student2.setLevel("artic1");

		Teacher teacher = new Teacher();
		teacher.setName("salah");
		teacher.setSalary(1000F);

		subscriptionServiceRemote.adduser(teacher);
		subscriptionServiceRemote.adduser(student);
		subscriptionServiceRemote.adduser(student2);

	}

}
