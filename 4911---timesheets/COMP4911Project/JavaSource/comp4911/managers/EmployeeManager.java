package comp4911.managers;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import comp4911.models.Employee;

@Dependent
@Stateless

/**
 * <p>Basic CRUD Manager</p>
 * @author jackee
 *<p>The class will attempt to handle create, read, update, delete.
 */
public class EmployeeManager implements Serializable {
	@PersistenceContext(unitName="COMP4911ClockrProjectDatabase") EntityManager em;

	/**
	 *<p>Some Random SerialVersionUID.</p>
	 */
	private static final long serialVersionUID = -7520188301250130738L;

	/**
	 * This function finds an employee by its id.
	 *
	 * @param id
	 * @return employee object
	 */
	public Employee find(int id) {
		return em.find(Employee.class, id);
	}

	/**
	 * Make an instance of employee managed and persistent.
	 *
	 * @param employee
	 */
	public void persist(Employee employee) {
		em.persist(employee);
	}

	/**
	 * Merge the state of the given entity into the current persistence context.
	 *
	 * @param employee
	 */
	public void merge(Employee employee) {
		em.merge(employee);
	}

	/**
	 * Removes an employee from the database by its employee number.
	 *
	 * @param employee
	 */
	public void remove(Employee employee) {
		employee = find(employee.getEmpNumber());
		em.remove(employee);
	}

	/**
	 * This function finds an employee by userId from the database.
	 *
	 * @param id
	 * @return emp
	 */
	public Employee findByUserId(String id) {
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.credential.userId = :userID ", Employee.class);
		query.setParameter("userID", id);
		java.util.List<Employee> results = query.getResultList();
		Employee emp = results.get(0);
		return emp;
	}

	/**
	 * This function gets a list of all the employees.
	 *
	 * @return employees
	 */
	public java.util.List<Employee> getAll() {
	        TypedQuery<Employee> query = em.createQuery("select e from Employee e",
	                Employee.class);
	        java.util.List<Employee> employees = query.getResultList();

	        return employees;
	    }

}
