package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	// do not try this at home (fetch = FetchType.EAGER)
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Course> coursesAttended;

	@OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
	private List<Course> coursesCoached;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCoursesAttended() {
		return coursesAttended;
	}

	public void setCoursesAttended(List<Course> coursesAttended) {
		this.coursesAttended = coursesAttended;
	}

	public List<Course> getCoursesCoached() {
		return coursesCoached;
	}

	public void setCoursesCoached(List<Course> coursesCoached) {
		this.coursesCoached = coursesCoached;
	}

	public void linkCoursesToThisUser(List<Course> courses) {
		this.coursesCoached = courses;
		for (Course c : courses) {
			c.setCoach(this);
		}
	}
}
