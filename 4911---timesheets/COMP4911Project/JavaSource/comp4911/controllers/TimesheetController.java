package comp4911.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
//import javax.transaction.Transactional;

import comp4911.managers.TimeSheetManager;
import comp4911.models.Employee;
import comp4911.models.TimeSheet;
import comp4911.models.TimeSheetRow;


@Named("test")
@SessionScoped
public class TimesheetController implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -1238841317514571931L;

	/**
	 * An instance of an employee.
	 */
	private Employee employee;

	/**
	 * Injects an instance of a timesheet.
	 */
	@Inject
	private TimeSheet timesheet;

	/**
	 * Injects an instance of a timesheetManager.
	 */
	@Inject
	private TimeSheetManager timesheetManager;

	/**
	 * A list of all the timesheets.
	 */
	private List<TimeSheet> timesheetList;

	/**
	 * An empty constructor of the TimesheetController object.
	 */
	public TimesheetController() {
	}

	/**
	 * Sets the employee for the current timesheet.
	 *
	 * @param employee
	 */
	public void SetEmployee(Employee employee) {
		this.employee = employee;
		refreshTimeSheet();
	}

	/**
	 * This function refreshes the timesheet.
	 */
	public void refreshTimeSheet() {
		timesheetList = timesheetManager.getAll(employee.getEmpNumber());
		if (timesheetList.size() > 0)
			timesheet = timesheetList.get(0);
	}

	/**
	 * Gets the list of all the timesheets.
	 *
	 * @return timesheetList
	 */
	public List<TimeSheet> getTimesheetList() {
		if (timesheetList == null) {
			refreshTimeSheet();
		}
		return timesheetList;
	}

	/**
	 * Gets a timesheetManager.
	 *
	 * @return timesheetManager
	 */
	public TimeSheetManager getTimesheetManager() {
		return timesheetManager;
	}

	/**
	 * Sets the timesheet manager.
	 *
	 * @param timesheetManager
	 */
	public void setTimesheetManager(TimeSheetManager timesheetManager) {
		this.timesheetManager = timesheetManager;
	}

	/**
	 * Gets a timesheet object. (??@Transactional)
	 *
	 * @return timesheet
	 */
	public TimeSheet getTimesheet() {
		System.out.println("Get Timesheet called");
		if(timesheet.equals(null)) {
			//System.out.println("Timesheet is null");
			timesheet = timesheetManager.getAll(employee.getEmpNumber()).get(0);
			//System.out.println(timesheet.getTimeSheetRows().size());
		}

		return timesheet;
	}

	/**
	 * Sets the timesheet object.
	 *
	 * @param timesheet
	 */
	public void setTimesheet(TimeSheet timesheet) {
		this.timesheet = timesheet;
	}

	/**
	 * This function saves the changes made to the current timesheet
	 * and refreshes the timesheet and displays the result.
	 *
	 * @return DisplayTimesheets
	 */
	public String saveChanges() {
		timesheetManager.merge(timesheet);
		refreshTimeSheet();
		return "DisplayTimesheets";
	}

	/**
	 * This function calls refreshTimeSheet.(neccessary?)
	 */
	public void timesheetInit() {
		refreshTimeSheet();
	}

	/**
	 * This function gets the corresponding row and deletes it from
	 * the current timesheet.
	 *
	 * @param tsRow outcome
	 */
	public String deleteTimesheetRow(TimeSheetRow tsRow, String outcome) {
		timesheet.getTimeSheetRows().remove(tsRow);
		return outcome;
	}

	/**
	 * This function adds a new row to the timesheet.
	 */
	public void createTimesheetRow() {
		int tsRowNum = 1;
		if (timesheet.getTimeSheetRows().size() > 0) {
			TimeSheetRow temp = timesheet.getTimeSheetRows().get(timesheet.getTimeSheetRows().size() - 1);
			tsRowNum = Integer.parseInt(temp.getTimeSheetRowId().substring(temp.getTimeSheetRowId().lastIndexOf('|') + 1));
			tsRowNum++;
		}
		String tsRowId = timesheet.getTimeSID() + "|" + tsRowNum;
		TimeSheetRow row = new TimeSheetRow();
		row.setTimeSheet(timesheet);
		row.setTimeSheetRowId(tsRowId);
		timesheet.getTimeSheetRows().add(row);
	}

	public String createRow(String outcome) {
		createTimesheetRow();
		return outcome;
	}

	/**
	 * This function removes the corresponding timesheet from
	 * the database with the timesheetManager and leads to the
	 * "DisplayTimesheets" page.
	 *
	 * @param timesheet
	 * @return DisplayTimesheets
	 */
	public String deleteTimesheet(TimeSheet timesheet) {
		timesheetManager.remove(timesheet);
		refreshTimeSheet();
		return "DisplayTimesheets";
	}

	/**
	 * This function leads to the "EditTimesheet" page.
	 *
	 * @param timesheet
	 * @return EditTimesheet
	 */
	public String editTimesheet(TimeSheet timesheet) {
		this.timesheet = timesheet;
		return "EditTimesheet";
	}

	/**
	 * This function creates a new timesheet and add its to the list with
	 * its corresponding information suchs as the Id, etc. And lead to a new
	 * page where the new timesheet is located, "CreateTimesheet" page.
	 *
	 * @return CreateTimesheet
	 */
	public String addTimesheetButton() {
		timesheet = new TimeSheet();
		int tsNum = 1;

		if (timesheetList.size() > 0) {
			TimeSheet temp = timesheetList.get(timesheetList.size() - 1);
			tsNum = Integer.parseInt(temp.getTimeSID().substring(temp.getTimeSID().lastIndexOf('|')+ 1));
			tsNum++;
		}

		String tsID = employee.getEmpNumber() + "|" + tsNum;
		System.out.println(tsID);
		timesheet.setTimeSID(tsID);
		timesheet.setEmpNumber(employee.getEmpNumber());
		timesheet.setIsActive(true);
		Calendar cal = Calendar.getInstance();
		timesheet.setWeekNumber(cal.get(Calendar.WEEK_OF_YEAR));
		//To have a row available already once a timesheet is created
		List<TimeSheetRow> tsList = new ArrayList<TimeSheetRow>();
		timesheet.setTimeSheetRows(tsList);
		createTimesheetRow();

		return "CreateTimesheet";
	}

	/**
	 * This functions uses the timesheetManager to create a new
	 * timesheet in the database and leads to the
	 * "DisplayTimesheets" page.
	 *
	 * @return DisplayTimesheets
	 */
	public String createTimesheet() {
		timesheetManager.persist(timesheet);
		timesheetList.add(timesheet);
		return "DisplayTimesheets";
	}

	/**
	 * Gets the timesheet row number.
	 *
	 * @return a string of the row number.
	 */
	public String getTimeSheetRowNumber(TimeSheetRow row) {
		return row.getTimeSheetRowId().substring(row.getTimeSheetRowId().lastIndexOf('|') + 1);
	}

	/**
	 * This function lead to the "DisplayTimesheets" page.
	 *
	 * @return DisplayTimesheets
	 */
	public String editTimeCancel(){
		return "DisplayTimesheets";
	}

	/**
	 * This function lead to the "cancelCreateTimesheet" page.
	 *
	 * @return cancelCreateTimesheet
	 */
	public String cancelCreateTimesheet(){
		return "cancelCreateTimesheet";
	}

	/**
	 * This function lead to the "cancelEditTimesheet" page.
	 *
	 * @return cancelEditTimesheet
	 */
	public String cancelEditTimesheet(){
		return "cancelEditTimesheet";
	}
}
