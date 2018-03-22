package comp4911.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class represents each row in the timesheets table.
 *
 * @author Student
 *
 */
@Entity
@Table(name="TimeSheetRow")
public class TimeSheetRow implements Serializable {

    /**
     * Default serial version ID;
     */
    private static final long serialVersionUID = 1L;

    /**
     * The identification number of a row in timesheet table.
     */
    @Id
    @Column(name="TimeSheetRowID")
    private String timeSheetRowId;

    /**
     * The identification number of a project.
     */
	@Column(name="ProjectId")
    private int projectId;

	/**
	 * The identification number of a work package.
	 */
    @Column(name="WpId")
    private int workpackId;

    /**
     * The total amount of hours that is in a row.
     */
    @Column(name="WeekTotalHrs")
    private double weekTotalHrs;

    /**
     * The amount of hours on Saturday.
     */
    @Column(name="SatHrs")
    private double satHrs;

    /**
     * The amount of hours on Sunday.
     */
    @Column(name="SunHrs")
    private double sunHrs;

    /**
     * The amount of hours on Monday.
     */
    @Column(name="MonHrs")
    private double monHrs;

    /**
     * The amount of hours on Tuesday.
     */
    @Column(name="TuesHrs")
    private double tuesHrs;

    /**
     * The amount of hours on Wednesday.
     */
    @Column(name="WedHrs")
    private double wedHrs;

    /**
     * The amount of hours on Thursday.
     */
    @Column(name="ThursHrs")
    private double thursHrs;

    /**
     * The amount of hours on Friday.
     */
    @Column(name="FriHrs")
    private double friHrs;

    /**
     * The amount of vacation days in a row.
     */
    @Column(name="VacationDays")
    private int vacationDays;

    /**
     * The amount of flexible working hours in a row.
     */
    @Column(name="FlextimeHrs")
    private double flexTimeHrs;

    /**
     * Notes to provide additional information about
     * that row.
     */
    @Column(name="Notes")
    private String notes;

    /**
     * A timesheet table joints the timesheetRows at the "TimeSheetId" column
     * and a timesheet table may have multiple rows.
     */
    @ManyToOne
    @JoinColumn(name="TimeSheetId")
    private TimeSheet timesheet;

    /**
     * Empty constructor of TimesheetRow object.
     */
    public TimeSheetRow(){}

    /**
     * Gets a timesheet.
     *
     * @return timesheet
     */
    public TimeSheet getTimeSheet(){
    	return timesheet;
    }

    /**
     * Sets a timesheet.
     *
     * @param timesheet
     */
    public void setTimeSheet(TimeSheet timesheet){
    	this.timesheet = timesheet;
    }

    /**
     * Gets the timesheet row identification number.
     *
     * @return timeSheetRowId
     */
    public String getTimeSheetRowId() {
        return timeSheetRowId;
    }

    /**
     * Sets the timesheet row identification number.
     *
     * @param timeSheetRowId
     */
    public void setTimeSheetRowId(String timeSheetRowId) {
        this.timeSheetRowId = timeSheetRowId;
    }

    /**
     * Gets the project identification number.
     *
     * @return projectID
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * Sets the project identification number.
     *
     * @param projectId
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * Gets the identification number of a work package.
     *
     * @return workpackId
     */
    public int getWorkpackId() {
        return workpackId;
    }

    /**
     * Sets the identification number of a work package.
     *
     * @param workpackId
     */
    public void setWorkpackId(int workpackId) {
        this.workpackId = workpackId;
    }

    /**
     * Gets the number of hours on Saturday.
     *
     * @return satHrs
     */
    public double getSatHrs() {
        return satHrs;
    }

    /**
     * Sets the number of hours on Saturday.
     *
     * @param satHrs
     */
    public void setSatHrs(double satHrs) {
        this.satHrs = satHrs;
    }

    /**
     * Gets the number of hours on Sunday.
     *
     * @return sunHrs
     */
    public double getSunHrs() {
        return sunHrs;
    }

    /**
     * Sets the number of hours on Sunday.
     *
     * @param sunHrs
     */
    public void setSunHrs(double sunHrs) {
        this.sunHrs = sunHrs;
    }

    /**
     * Get the number of hours on Monday.
     *
     * @return monHrs
     */
    public double getMonHrs() {
        return monHrs;
    }

    /**
     * Sets the number of hours on Monday.
     *
     * @param monHrs
     */
    public void setMonHrs(double monHrs) {
        this.monHrs = monHrs;
    }

    /**
     * Gets the number of hours on Tuesday.
     *
     * @return tuesHrs
     */
    public double getTuesHrs() {
        return tuesHrs;
    }

    /**
     * Sets the number of hours on Tuesday.
     *
     * @param tuesHrs
     */
    public void setTuesHrs(double tuesHrs) {
        this.tuesHrs = tuesHrs;
    }

    /**
     * Gets the number of hours on Wednesday.
     *
     * @return wedHrs
     */
    public double getWedHrs() {
        return wedHrs;
    }

    /**
     * Sets the number of hours on Wednesday.
     *
     * @param wedHrs
     */
    public void setWedHrs(double wedHrs) {
        this.wedHrs = wedHrs;
    }

    /**
     * Gets the number of hours on Thursday.
     *
     * @return thursHrs
     */
    public double getThursHrs() {
        return thursHrs;
    }

    /**
     * Sets the number of hours on Thursday.
     *
     * @param thursHrs
     */
    public void setThursHrs(double thursHrs) {
        this.thursHrs = thursHrs;
    }

    /**
     * Gets the number of hours on Friday.
     *
     * @return friHrs
     */
    public double getFriHrs() {
        return friHrs;
    }

    /**
     * Sets the number of hours on Friday.
     *
     * @param friHrs
     */
    public void setFriHrs(double friHrs) {
        this.friHrs = friHrs;
    }

    /**
     * Gets the total amount of hours in that row.
     *
     * @return weekTotalHrs
     */
    public double getWeekTotalHrs() {
        return weekTotalHrs;
    }

    /**
     * Sets the total amount of hours in that row.
     *
     * @param weekTotalHrs
     */
    public void setWeekTotalHrs(double weekTotalHrs) {
        this.weekTotalHrs = weekTotalHrs;
    }

    /**
     * Gets the notes for the row.
     *
     * @return notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes for the row.
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * This creates a string of all the information in a row.
     *
     * @return returns a string of the combined information of the row.
     */
	public String toString(){
		return "" + timeSheetRowId + " " + timesheet.getTimeSID() + " " + projectId + " " + workpackId + " " + weekTotalHrs + " "
				+ sunHrs + " " + monHrs + " " + tuesHrs + " " + wedHrs + " " + thursHrs + " "
				+ friHrs + " " + notes;
	}

	/**
   * Gets the number of vaction days for that row in the timesheet.
	 *
	 * @return vacationDays
	 */
	public int getVacationDays() {
		return vacationDays;
	}

  /**
   * Sets the number of vaction days for that row in the timesheet.
	 *
	 * @param vacationDays
	 */
	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

  /**
   * Gets the number of flexible working hours of this row
   * in the timesheet.
   *
   * @return flexTimeHrs
   */
	public double getFlexTimeHrs() {
		return flexTimeHrs;
	}

  /**
   * Sets the number of flexible working hours of this row
   * in the timesheet.
   *
   * @param flexTimeHrs
   */
	public void setFlexTimeHrs(double flexTimeHrs) {
		this.flexTimeHrs = flexTimeHrs;
	}

  /**
   * Gets a timesheet object.
   *
   * @return timesheet
   */
	public TimeSheet getTimesheet() {
		return timesheet;
	}

  /**
   * Sets a timesheet object.
   *
   * @param timesheet
   */
	public void setTimesheet(TimeSheet timesheet) {
		this.timesheet = timesheet;
	}


}
