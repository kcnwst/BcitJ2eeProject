package comp4911.models;

import java.io.Serializable;
import java.sql.Date;
//import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Transient;

/**
 * The timesheet object.
 *
 * @author Student
 *
 */
@Entity
@Table(name="TimeSheet")
public class TimeSheet implements Serializable {

	/**
	 * Default serial version ID;
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The identification number of a timesheet.
	 * Named "TimesheetId" in the "Timesheet" table.
	 */
	@Id
	@Column(name="TimesheetId")
	private String timesheetId;

	/**
	 * The employee number of the person who made the timesheet.
	 */
	@Column(name="EmpNum")
	private int empNumber;

	/**
	 * The week number of the timesheet table when it was created.
	 */
	@Column(name="WeekNum")
	private int weekNumber;

	/**
	 * The date of the week ending when the timesheet table was created.
	 */
	@Column(name="WeekEnding")
	private Date weekEnding;

	/**
	 * Total number of hours on Saturday.
	 */
	@Column(name="SatTotalHrs")
    private double satTotalHrs;

	/**
	 * Total number of hours on Sunday.
	 */
	@Column(name="SunTotalHrs")
    private double sunTotalHrs;

	/**
	 * Total number of hours on Monday.
	 */
	@Column(name="MonTotalHrs")
    private double monTotalHrs;

	/**
	 * Total number of hours on Tuesday.
	 */
	@Column(name="TuesTotalHrs")
    private double tuesTotalHrs;

	/**
	 * Total number of hours on Wednesday.
	 */
	@Column(name="WedsTotalHrs")
    private double wedTotalHrs;

	/**
	 * Total number of hours on Thursday.
	 */
	@Column(name="ThursTotalHrs")
    private double thursTotalHrs;

	/**
	 * Total number of hours on Friday.
	 */
	@Column(name="FriTotalHrs")
    private double friTotalHrs;

	/**
	 * The total number of hours on the timesheet table.
	 */
	@Column(name="OverallTotalHrs")
    private double overallTotalHrs;

	/**
	 * The number of flexible working hours of each week.
	 */
	@Column(name="FlextimeHrs")
    private double flextimeHrs;

	/**
	 * The signature of approval for a timesheet table.
	 */
	@Column(name="Signature")
	private String Signature;

	/**
	 * The approval of the timesheet
	 */
	@Column(name="Approval")
	private String approval;

	/**
	 * The state of the timesheet is it active or not.
	 */
	@Column(name="IsActive")
	private boolean isActive;

	/**
	 * The relationship of the timesheet and timesheet rows.
	 * A timesheet can have many timesheet rows.
	 */
	@OneToMany(mappedBy="timesheet", fetch = FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<TimeSheetRow> timesheetrows;

	/**
	 * An empty constructor of timesheet object.
	 */
	public TimeSheet(){}

	/**
	 * Gets the list of timesheetRows in a timesheet.
	 *
	 * @return timesheetrows
	 */
	public List<TimeSheetRow> getTimeSheetRows(){
		return timesheetrows;
	}

	/**
	 * Sets the list of timesheetRows for a timesheet.
	 *
	 * @param timesheetrows
	 */
	public void setTimeSheetRows(List<TimeSheetRow> timesheetrows){
		this.timesheetrows = timesheetrows;
	}

	/**
	 * Gets the identification number of a timesheet.
	 *
	 * @return timesheetId
	 */
	public String getTimeSID() {
		return timesheetId;
	}

	/**
	 * Sets the identification number of a timesheet.
	 *
	 * @param timesheetId
	 */
	public void setTimeSID(String timesheetId) {
		this.timesheetId = timesheetId;
	}

	/**
	 * Gets the employee number of the person who
	 * created the timesheet.
	 *
	 * @return empNumber
	 */
	public int getEmpNumber() {
		return empNumber;
	}

	/**
	 * Sets the employee number of the person who
	 * created the timesheet.
	 *
	 * @param empNumber
	 */
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	/**
	 * Get the week number when the timesheet was
	 * created.
	 *
	 * @return weekNumber
	 */
	public int getWeekNumber() {
		return weekNumber;
	}

	/**
	 * Set the week number when the timesheet was
	 * created.
	 *
	 * @param weekNumber
	 */
	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	/**
	 * Get the total number of hours on Saturday
	 * that is on the timesheet.
	 *
	 * @return satTotalHrs
	 */
	public double getSatTotalHrs() {
        return satTotalHrs;
    }

	/**
	 * Sets the total numberof hours on Saturday
	 * that is on the timesheet.
	 *
	 * @param satTotalHrs
	 */
    public void setSatTotalHrs(double satTotalHrs) {
        this.satTotalHrs = satTotalHrs;
    }

    /**
     * Gets the total number of hours on Sunday
     * thats is on the timesheet.
     *
     * @return sunTotalHrs
     */
    public double getSunTotalHrs() {
        return sunTotalHrs;
    }

    /**
     * Sets the total number of hours on Sunday
     * thats is on the timesheet.
     *
     * @param sunTotalHrs
     */
    public void setSunTotalHrs(double sunTotalHrs) {
        this.sunTotalHrs = sunTotalHrs;
    }

    /**
     * Gets the total number of hours on Monday
     * that is on the timesheet.
     *
     * @return monTotalHrs
     */
    public double getMonTotalHrs() {
        return monTotalHrs;
    }

    /**
     * Sets the total number of hours on Monday
     * that is on the timesheet.
     *
     * @param monTotalHrs
     */
    public void setMonTotalHrs(double monTotalHrs) {
        this.monTotalHrs = monTotalHrs;
    }

    /**
     * Gets the total number of hours on Tuesday
     * that is on the timesheet.
     *
     * @return tuesTotalHrs
     */
    public double getTuesTotalHrs() {
        return tuesTotalHrs;
    }

    /**
     * Sets the total number of hours on Tuesday
     * that is on the timesheet.
     *
     * @param tuesTotalHrs
     */
    public void setTuesTotalHrs(double tuesTotalHrs) {
        this.tuesTotalHrs = tuesTotalHrs;
    }

    /**
     * Gets the total number of hours on Wednesday
     * that is on the timesheet.
     *
     * @return wedTotalHrs
     */
    public double getWedTotalHrs() {
        return wedTotalHrs;
    }

    /**
     * Sets the total number of hours on Wednesday
     * that is on the timesheet.
     *
     * @param wedTotalHrs
     */
    public void setWedTotalHrs(double wedTotalHrs) {
        this.wedTotalHrs = wedTotalHrs;
    }

    /**
     * Gets the total number of hours on Thursday
     * that is on the timesheet.
     *
     * @return thursTotalHrs
     */
    public double getThursTotalHrs() {
        return thursTotalHrs;
    }

    /**
     * Sets the total number of hours on Thursday
     * that is on the timesheet.
     *
     * @param thursTotalHrs
     */
    public void setThursTotalHrs(double thursTotalHrs) {
        this.thursTotalHrs = thursTotalHrs;
    }

    /**
     * Gets the total number of hours on Friday
     * that is on the timesheet.
     *
     * @return friTotalHrs
     */
    public double getFriTotalHrs() {
        return friTotalHrs;
    }

    /**
     * Sets the total number of hours on Friday
     * that is on the timesheet.
     *
     * @param friTotalHrs
     */
    public void setFriTotalHrs(double friTotalHrs) {
        this.friTotalHrs = friTotalHrs;
    }

    /**
     * Gets the total number of hours
     * that is on the timesheet.
     *
     * @return overallTotalHrs
     */
    public double getOverallTotalHrs() {
        return overallTotalHrs;
    }

    /**
     * Sets the total number of hours
     * that is on the timesheet.
     *
     * @param overallTotalHrs
     */
    public void setOverallTotalHrs(double overallTotalHrs) {
        this.overallTotalHrs = overallTotalHrs;
    }

    /**
     * Gets the total hours of flexible working hours
     * on a timesheet.
     *
     * @return flextimeHrs
     */
    public double getFlextimeHrs() {
        return flextimeHrs;
    }

    /**
     * Gets the total hours of flexible working hours
     * on a timesheet.
     *
     * @param flextimeHrs
     */
    public void setflextimeHrs(double flextimeHrs) {
        this.flextimeHrs = flextimeHrs;
    }

    /**
     * Gets the signature that shows the timesheet is approved.
     *
     * @return
     */
	public String getSignature() {
		return Signature;
	}

	/**
	 * Sets the signature that shows the timesheet is approved.
	 *
	 * @param signature
	 */
	public void setSignature(String signature) {
		Signature = signature;
	}

	/**
	 * Gets the approval state of the current timesheet.
	 *
	 * @return approval
	 */
	public String isApproval() {
		return approval;
	}

	/**
	 * Set the approve of the current timesheet.
	 *
	 * @param approval
	 */
	public void setApproval(String approval) {
		this.approval = approval;
	}

	/**
	 * Set the activity of the current timesheet.
   *
 	 * @oaram isActive
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * Gets the activity of the current timesheet.
	 *
	 * @return isActive
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * This function return the information of a timesheet in one string.
	 *
	 * @return a string that contains the information of a timesheet.
	 */
	public String toString(){
		return "" + timesheetId + " " + empNumber + " " + weekNumber + " " + satTotalHrs + " " + sunTotalHrs
				+ " " + monTotalHrs + " " + tuesTotalHrs + " " + wedTotalHrs + " " + thursTotalHrs + " "
				+ friTotalHrs + " " + overallTotalHrs + " " + " " + flextimeHrs;
	}
}
