package comp4911.models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The employee class which represents all the
 * data that is being used to describe an employee that
 * is stored in the database.
 * 
 * @author 
 *
 */
@Entity
@Table(name="Employees")
public class Employee implements Serializable {

	/**
	 * Default serial version ID;
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The corresponding employee's number in the system.
	 * Which is named "EmpNum" in the "Employee" table.
	 */
	@Id
	@Column(name="EmpNum")
	private int empNumber;
	
	/**
	 * The relationship of the Employee table verses the Credential table,
	 * which a one to one relationship, joint column at the field "UserId"
	 */
	@OneToOne
	@JoinColumn(name="UserId")
	private Credential credential;
	
	/**
	 * The user's first name, named the "EmpFname" column
	 * in the "Employee" table.
	 */
	@Column(name="EmpFname")
	private String firstName;
	
	/**
	 * The user's last name, named the "EmpLname" column
	 * in the "Employee" table.
	 */
	@Column(name="EmpLname")
	private String lastName;	
	
	/**
	 * The supervisor's employee number, name the "SupervisorEmpNum"
	 * column in the "Employee" table.
	 */
	@Column(name="SupervisorEmpNum")
	private int supNum;
	
	/**
	 * The number of vacation days for each employee, named
	 * the "VacationDays" column in the "Employee" table.
	 */
	@Column(name="VacationDays")
	private int vacDays;

	/**
	 * The date that the employee was hired, named "HireDate"
	 * column in the "Employee" table.
	 */
	@Column(name="HireDate")
	private Date hireDate;
	
	/**
	 * The email that each employee own's.
	 */
	@Column(name="Email")
	private String email;
	
	/**
	 * The id that identifies which pay rate each employee
	 * is assigned to.
	 */
	@Column(name="PayRateId")
	private String payRateId;

	/**
	 * Shows whether a user in the system is active or not.
	 */
	@Transient
	private boolean active;
	
	/**
	 * Empty constructor of the Employee class.
	 */
	public Employee() {}

	/**
	 * Gets the corresponding employee number.
	 * 
	 * @return empNumber
	 */
	public int getEmpNumber() {
		return empNumber;
	}

	/**
	 * Sets the employee number.
	 * 
	 * @param empNumber
	 */
	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	/**
	 * Gets the credentials for an employee.
	 * 
	 * @return credential
	 */
	public Credential getCredential() {
		return credential;
	}

	/**
	 * Sets the credential for a corresponding employee.
	 * 
	 * @param credential
	 */
	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	/**
	 * Gets the first name of an employee.
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of an employee.
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of an employee.
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of an employee.
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the status of an employee, if he is active or not.
	 * 
	 * @return active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the activity statues of an employee.
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Gets the hired date that was recorded.
	 * 
	 * @return hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * Sets the hired date of an employee.
	 * 
	 * @param hireDate
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * Gets the pay rate id for an employee.
	 * 
	 * @return payRateId
	 */
	public String getPayRateId() {
		return payRateId;
	}

	/**
	 * Sets the pay rate Id of an employee.
	 * 
	 * @param payRateId
	 */
	public void setPayRateId(String payRateId) {
		this.payRateId = payRateId;
	}

	/**
	 * Gets the email of an employee.
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address for an employee.
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the corresponding employee's supervisor's employee number.
	 * 
	 * @return supNum
	 */
	public int getSupNum() {
		return supNum;
	}

	/**
	 * Sets the corresponding employee's supervisor's employee number.
	 * 
	 * @param supNum
	 */
	public void setSupNum(int supNum) {
		this.supNum = supNum;
	}
	
	/**
	 * Gets the vacations days for an employee. 
	 * 
	 * @return vacDays
	 */
	public int getVacDays() {
		return vacDays;
	}

	/**
	 * Sets the vacation days of an employee.
	 * 
	 * @param vacDays
	 */
	public void setVacDays(int vacDays) {
		this.vacDays = vacDays;
	}	
}

