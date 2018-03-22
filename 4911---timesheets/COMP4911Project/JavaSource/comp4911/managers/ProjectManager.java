package comp4911.managers;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import comp4911.models.Project;

@Dependent
@Stateless

/**
 * <p>Basic CRUD Manager</p>
 * @author jackee
 *<p>The class handles create, read, update, delete.
 */
public class ProjectManager implements Serializable {
	@PersistenceContext(unitName="COMP4911ClockrProjectDatabase") EntityManager em;

	/**
	 *<p>Some Random SerialVersionUID.</p>
	 */
	private static final long serialVersionUID = -7520188301250130738L;

	/**
	 * This function find a project by its primary key.
	 *
	 * @param id
	 * @return a project object.
	 */
	public Project find(int id) {
		return em.find(Project.class, id);
	}

	/**
	 * Make an instance of project managed and persistent.
	 *
	 * @param project
	 */
	public void persist(Project project) {
		em.persist(project);
	}

	/**
	 * Merge the state of the given entity into the current persistence context.
	 *
	 * @param project
	 */
	public void merge(Project project) {
		em.merge(project);
	}

	/**
	 * This function removes a project from the database with the project's id.
	 *
	 * @param project
	 */
	public void remove(Project project) {
		project = find(project.getProjectId());
		em.remove(project);
	}

	/**
	 * This function uses query to find a project by its Id.
	 *
	 * @param id
	 * @return proj
	 */
	public Project findByUserId(String id) {
		TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p WHERE p.projectId = :projectId ", Project.class);
		query.setParameter("projectId", id);
		java.util.List<Project> results = query.getResultList();
		Project proj = results.get(0);
		return proj;
	}

	/**
	 * This function gets all the projects and returns it in a list.
	 *
	 * @return projects a list of all the projects
	 */
	public java.util.List<Project> getAll() {
		System.out.println("Is Get All Being called.??????");
		TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p",
				Project.class);
		java.util.List<Project> projects = query.getResultList();
		return projects;
	}

}
