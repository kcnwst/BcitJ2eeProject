package comp4911.managers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import comp4911.models.TimeSheet;

@Dependent
@Stateless

/**
 * <p>Basic CRUD Manager</p>
 * @author Tony
 *<p>The class will attempt to handle create, read, update, delete.
 */

public class TimeSheetManager implements Serializable {
	@PersistenceContext(unitName="COMP4911ClockrProjectDatabase") EntityManager em;
	/**
	 *<p> Some Random SerialVersionUID.</p>
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This function find a timesheet by its primary key.
	 *
	 * @param id
	 * @return a timesheet object.
	 */
	public TimeSheet find(int id) {
		return em.find(TimeSheet.class, id);
	}

	/**
	 * Make an instance of timesheet managed and persistent.
 	 *
 	 * @param timesheet
	 */
	public void persist(TimeSheet timesheet) {
		em.persist(timesheet);
	}

	/**
	 * Merge the state of the given entity into the current persistence context.
	 *
	 * @param timesheet
	 */
	public void merge(TimeSheet timesheet) {
		em.merge(timesheet);
	}

	/**
	 * This fucntion does not really removes a timesheet from the database
	 * it only sets the timesheet's activity to false.
	 *
	 * @param timesheet
	 */
	public void remove(TimeSheet timesheet) {
		timesheet.setIsActive(false);
		em.merge(timesheet);
	}

	/**
	 * This function gets a timesheets by its identification number.
	 *
	 * @param timesheetID
	 * @return timeArray
	 */
	public TimeSheet[] getByTimeSheetId(String timesheetID){
		TypedQuery<TimeSheet> query = em.createQuery("select t from " +
				"TimeSheet t where t.timeSID = " + timesheetID, TimeSheet.class);
		List<TimeSheet> timesheets = query.getResultList();
		TimeSheet[] timeArray = new TimeSheet[timesheets.size()];
		for (int i=0; i < timeArray.length; i++){
			timeArray[i] = timesheets.get(i);
		}
		return timeArray;
	}

	/**
	 * This function gets all the timesheets in the database and returns it as a
	 * list.(Those that are active)
	 *
	 * @return timesheets a list of all the timesheets
	 */
	public List<TimeSheet> getAll() {
		TypedQuery<TimeSheet> query = em.createQuery("select t from TimeSheet t where isActive IS TRUE", TimeSheet.class);
		List<TimeSheet> timesheets = query.getResultList();

		return timesheets;
	}

	/**
	 * This function gets all the timesheets in the database and returns it as a
	 * list.(Those that are active and according to the identification number)
	 *
	 * @param id
	 * @return timesheets a list of all the timesheets
	 */
	public List<TimeSheet> getAll(int id) {
		TypedQuery<TimeSheet> query = em.createQuery("select t from TimeSheet t where isActive IS TRUE AND empNumber=" + id, TimeSheet.class);
		List<TimeSheet> timesheets = query.getResultList();

		return timesheets;
	}
}
