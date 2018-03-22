package comp4911.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;

/**
 * The credential class which represents all the
 * data that could be in a user's credential.
 * 
 * @author 
 *
 */
@Entity
@Table(name="Credentials")
public class Credential implements Serializable {

	/**
	 * Default serial version ID;
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The employee's user Id, which is named "UserId"
	 * in the database.
	 */
	@Id
	@Column(name="UserId")
	private String userId;
	
	/**
	 * The employee's password for which is also the
	 * column's name in the database.
	 */
	@Column(name="Password")
	private String password;
	
	/**
	 * An Id that represents a role, which is named
	 * "RoleId" in the database.
	 */
	@Column(name="RoleId")
	private int roleId;

	/**
	 * The role that is assigned to users, which is
	 * named "UserRole" column in the database.
	 */
	@Column(name="UserRole")
	private String role;
	
	/**
	 * A digital signiture which managers use to show
	 * that they have approved a document in the system.
	 * Named "DigiSign" column in the database.
	 */
	@Column(name="DigiSign")
	private String digiSign;
	
	/**
	 * An email which each employee has.
	 * Named "Email" column in the database.
	 */
	@Column(name="Email")
	private String email;
	
	/**
	 * The answer to the corresponding employee's first
	 * password recovery question.
	 * Named "RecoveryAnswer1" column in the "Credentials"
	 * table.
	 */
	@Column(name="RecoveryAnswer1")
	private String recovery1;
	
	/**
	 * The answer to the corresponding employee's second
	 * password recovery question.
	 * Named "RecoveryAnswer2" column in the "Credentials"
	 * table.
	 */
	@Column(name="RecoveryAnswer2")
	private String recovery2;
	
	/**
	 * The answer to the corresponding employee's third
	 * password recovery question.
	 * Named "RecoveryAnswer3" column in the "Credentials"
	 * table.
	 */
	@Column(name="RecoveryAnswer3")
	private String recovery3;
	
	/**
	 * Mapping of the relationship of an employee to a credential,
	 * which each employee has one credential.
	 */
	@OneToOne(mappedBy="credential")
	private Employee employee;
	
	/**
	 * An empty constructor of the Credential class.
	 */
	public Credential() {}
	
	/**
	 * A constructor of a Credential which requires a set of fields.
	 * 
	 * @param userId The user's Id
	 * @param password The user's password
	 * @param roleId The user's role Id
	 * @param role The name of the roles, the user is involved in
	 * @param email The user's email
	 */
	public Credential(String userId, String password, int roleId, String role, String email){
		this.setUserId(userId);
		this.setPassword(password);
		this.setRoleId(roleId);
		this.setRole(role);
		this.setEmail(email);
	}

	/**
	 * Gets the user Id.
	 * 
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user Id.
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the password of the corresponding user.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the corresponding user's password.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the role Id for the corresponding user.
	 * 
	 * @return roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role Id for each role.
	 * 
	 * @param roleId
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the role for a corresponding
	 * employee.
	 * 
	 * @return role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Set the role for a corresponding user.
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Set the digital signature for a corresponding
	 * user.
	 * 
	 * @return digiSign A digital signature.
	 */
	public String getDigiSign() {
		return digiSign;
	}

	/**
	 * Sets the digital signature for a corresponding
	 * user.
	 * 
	 * @param digiSign
	 */
	public void setDigiSign(String digiSign) {
		this.digiSign = digiSign;
	}
	
	/**
	 * Gets an email of a user.
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Set the email of a corresponding user.
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the corresponding employee.
	 * 
	 * @return employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Set a corresponding employee.
	 * 
	 * @param employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * Gets the first recovery answer for a corresponding
	 * employee.
	 * 
	 * @return recovery1
	 */
	public String getRecovery1() {
		return recovery1;
	}

	/**
	 * Sets the first recovery answer for a corresponding
	 * employee. 
	 * 
	 * @param recovery1
	 */
	public void setRecovery1(String recovery1) {
		this.recovery1 = recovery1;
	}

	/**
	 * Gets the second recovery answer for a corresponding
	 * employee.
	 * 
	 * @return recovery2
	 */
	public String getRecovery2() {
		return recovery2;
	}

	/**
	 * Sets the second recovery answer for a corresponding
	 * employee.
	 * 
	 * @param recovery2
	 */
	public void setRecovery2(String recovery2) {
		this.recovery2 = recovery2;
	}

	/**
	 * Gets the third recovery answer for a corresponding
	 * employee.
	 * 
	 * @return recovery3
	 */
	public String getRecovery3() {
		return recovery3;
	}

	/**
	 * Sets the third recovery answer for a corresponding
	 * employee.
	 * 
	 * @param recovery3
	 */
	public void setRecovery3(String recovery3) {
		this.recovery3 = recovery3;
	}

}