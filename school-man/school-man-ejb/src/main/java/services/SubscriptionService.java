package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
