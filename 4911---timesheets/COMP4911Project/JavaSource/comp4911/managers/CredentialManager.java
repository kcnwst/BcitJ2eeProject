package comp4911.managers;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import comp4911.models.Credential;


@Dependent
@Stateless

/**
 * <p>Basic CRUD Manager</p>
 * @author jackee
 *<p>The class will attempt to handle create, read, update, delete.</p>
 */
public class CredentialManager implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="COMP4911ClockrProjectDatabase") EntityManager em;

	/**
	 * This function uses the identification number to look for the corresponding
	 * credential from the database.
	 *
	 * @return Credential
	 */
	public Credential find(String id) {
		return em.find(Credential.class, id);
	}

	/**
	 * Make an instance of credential managed and persistent.
	 *
	 * @param credential
	 */
	public void persist(Credential credential) {
		em.persist(credential);
	}

	/**
	 * Merge the state of the given entity into the current persistence context.
	 *
	 * @param credential
	 */
	public void merge(Credential credential) {
		em.merge(credential);
	}

	/**
	 * This function removes a credentials from the database by the userId.
	 *
	 * @param credential
	 */
	public void remove(Credential credential) {
		credential = this.find(credential.getUserId());
		em.remove(credential);
	}

	/**
	 * This function gets all the credentials in the database.
	 *
	 * @return an array of credentials
	 */
	public Credential[] getAll() {
	        TypedQuery<Credential> query = em.createQuery("select c from Credential c",
	                Credential.class);
	        java.util.List<Credential> credentials = query.getResultList();
	        Credential[] credArray = new Credential[credentials.size()];
	        for (int i=0; i < credArray.length; i++) {
	            credArray[i] = credentials.get(i);
	        }
	        return credArray;
	    }
}
