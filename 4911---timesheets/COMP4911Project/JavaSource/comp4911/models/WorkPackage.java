package comp4911.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Student
 *
 */
@Entity
@Table(name="WorkPackage")
public class WorkPackage implements Serializable {

	/**
	 * Default serial version ID;
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The identification number of the work package.
	 */
	@Id
	@Column(name="WpId")
	private String wpId;
	
	/**
	 * The work package number.
	 */
	@Column(name="WpNum")
	private String wpNum;
	
	/**
	 * The work package title.
	 */
	@Column(name="WpTitle")
	private String wpTitle;
	
	/**
	 * The customer name for this work package.
	 */
	@Column(name="Customer")
	private String customer;
	
	/**
	 * The responsible engineer identification number of this work package.
	 */
	@Column(name="RespEngId")
	private String respId;
	
	/**
	 * The 
	 */
	@Column(name="MDP1")
	private int mdp1;
	
	@Column(name="MDP2")
	private int mdp2;
	
	@Column(name="MDP3")
	private int mdp3;
	
	@Column(name="MDP4")
	private int mdp4;
	
	@Column(name="MDP5")
	private int mdp5;
	
	@Column(name="MDDS")
	private int mdds;
	
	@Column(name="MDSS")
	private int mdss;
	
	/**
	 * The project identification number of this work package.
	 */
	@Column(name="ProjectId")
	private int projectId;
	
	/**
	 * Whether this workpackage is active or not.
	 */
	@Column(name="IsActive")
	private boolean isActive;

	/**
	 * An empty constructor for the workpackage object.
	 */
	public WorkPackage(){}
	
	/**
	 * Gets the workpackage identification number.
	 * 
	 * @return wpId
	 */
	public String getWpId() {
		return wpId;
	}

	/**
	 * Sets the workpackage identification number.
	 * 
	 * @param wpId
	 */
	public void setWpId(String wpId) {
		this.wpId = wpId;
	}

	/**
	 * Gets the workpackage number.
	 * 
	 * @return wpNum
	 */
	public String getWpNum() {
		return wpNum;
	}

	/**
	 * Sets the workpackage number.
	 * 
	 * @param wpNum
	 */
	public void setWpNum(String wpNum) {
		this.wpNum = wpNum;
	}

	/**
	 * Gets the workpackage title.
	 * 
	 * @return wpTitle
	 */
	public String getWpTitle() {
		return wpTitle;
	}

	/**
	 * Sets the workpackage title.
	 * 
	 * @param wpTitle
	 */
	public void setWpTitle(String wpTitle) {
		this.wpTitle = wpTitle;
	}

	/**
	 * Gets the customer name for this work package. 
	 * 
	 * @return customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer name for this work package.
	 * 
	 * @param customer
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * Gets the responsible engineer identification number 
	 * of this work package.
	 * 
	 * @return respId
	 */
	public String getRespId() {
		return respId;
	}

	/**
	 * Sets the responsible engineer identification number 
	 * of this work package.
	 * 
	 * @param respId
	 */
	public void setRespId(String respId) {
		this.respId = respId;
	}

	public int getMdp1() {
		return mdp1;
	}

	public void setMdp1(int mdp1) {
		this.mdp1 = mdp1;
	}

	public int getMdp2() {
		return mdp2;
	}

	public void setMdp2(int mdp2) {
		this.mdp2 = mdp2;
	}

	public int getMdp3() {
		return mdp3;
	}

	public void setMdp3(int mdp3) {
		this.mdp3 = mdp3;
	}

	public int getMdp4() {
		return mdp4;
	}

	public void setMdp4(int mdp4) {
		this.mdp4 = mdp4;
	}

	public int getMdp5() {
		return mdp5;
	}

	public void setMdp5(int mdp5) {
		this.mdp5 = mdp5;
	}

	public int getMdds() {
		return mdds;
	}

	public void setMdds(int mdds) {
		this.mdds = mdds;
	}

	public int getMdss() {
		return mdss;
	}

	public void setMdss(int mdss) {
		this.mdss = mdss;
	}

	/**
	 * Gets the project identification number.
	 * 
	 * @return projectId
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
	 * Gets activity of the current workpackage.
	 * 
	 * @return isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * Sets the activity of the current workpackage.
	 * 
	 * @param isActive
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}