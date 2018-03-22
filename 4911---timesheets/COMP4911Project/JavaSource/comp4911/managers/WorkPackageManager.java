package comp4911.managers;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import comp4911.models.WorkPackage;

@Dependent
@Stateless

/**
 * <p>Basic CRUD Manager</p>
 * @author jackee
 *<p>The class handles create, read, update, delete.
 */
public class WorkPackageManager implements Serializable {
	@PersistenceContext(unitName="COMP4911ClockrProjectDatabase") EntityManager em;

	/**
	 *<p>Some Random SerialVersionUID.</p>
	 */
	private static final long serialVersionUID = -7520188301250130738L;

	/**
	 * This function finds a workpackage by its primary key.
	 *
	 * @param id
	 * @return a workpackage object
	 */
	public WorkPackage find(String id) {
		return em.find(WorkPackage.class, id);
	}

	/**
	 * Make an instance of workpackage managed and persistent.
	 *
 	 * @param wp
	 */
	public void persist(WorkPackage wp) {
		em.persist(wp);
	}

	/**
	 * Merge the state of the given entity into the current persistence context.
	 *
	 * @param wp
	 */
	public void merge(WorkPackage wp) {
		em.merge(wp);
	}

	/**
	 * This function removes a workpackage from the database with the
	 * corresponding workpackage identification number.
	 *
	 * @param wp
	 */
	public void remove(WorkPackage wp) {
		wp = find(wp.getWpId());
		em.remove(wp);
	}

	/**
	 * This fucntion finds the corresponding workpackage according to its
	 * identification number.
	 *
	 * @param id
	 * @return wp
	 */
	public WorkPackage findByUserId(String id) {
		TypedQuery<WorkPackage> query = em.createQuery("SELECT w FROM WorkPackage w WHERE w.wpId = :wpId ", WorkPackage.class);
		query.setParameter("wpId", id);
		java.util.List<WorkPackage> results = query.getResultList();
		WorkPackage wp = results.get(0);
		return wp;
	}

	/**
	 * This function gets all the workpackages in the database and returns a list.
	 *
	 * @return workPacks a list of all the workpackages
	 */
	public java.util.List<WorkPackage> getAll() {
	        TypedQuery<WorkPackage> query = em.createQuery("SELECT p FROM WorkPackage p",
	                WorkPackage.class);
	        java.util.List<WorkPackage> workPacks = query.getResultList();
	        return workPacks;
	    }

}
