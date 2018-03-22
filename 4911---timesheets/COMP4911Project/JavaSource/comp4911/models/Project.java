package comp4911.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class Project implements Serializable{

	/**
	 * Default Serial Version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The identification number of a project.
	 * Named "ProjectId" in the "Projects" table.
	 */
	@Id
	@Column(name="ProjectId")
	private int projectId;

	/**
	 * The name of a project.
	 * Named "ProjName" in the "Projects" table.
	 */
	@Column(name="ProjName")
	private String projName;

	/**
	 * The employee number of the supervisor that is responsible for that specific
	 * project.
	 * Named "EmpNum" in the "Projects" table.
	 */
	@Column(name="EmpNum")
	private int supervisor;

	/**
	 * The issue date of a project.
	 * Named "IssueDate" in the "Projects" table.
	 */
	@Column(name="IssueDate")
	private Date issueDate;

	/**
	 * The proposed cost of the project.
	 * Named "CostingProposal" in the "Projects" table.
	 */
	@Column(name="CostingProposal")
	private double proposal;

	/**
	 * The initial budget of the project.
	 * Named "InitialBudget" in the "Projects" table.
	 */
	@Column(name="InitialBudget")
	private double initBudget;

	/**
	 * The RO1 budget.
	 * Named "RO1Budget" in the "Projects" table.
	 */
	@Column(name="RO1Budget")
	private double ro1Budget;

	/**
	 * The RO2 budget.
	 * Named "RO2Budget" in the "Projects" table.
	 */
	@Column(name="RO2Budget")
	private double ro2Budget;

	/**
	 * The final budget.
	 * Named "FinalBudget" in the "Projects" table.
	 */
	@Column(name="FinalBudget")
	private double finalBudget;

	/**
	 * The man days of P1.
	 * Named "MDP1" in the "Projects" table.
	 */
	@Column(name="MDP1")
	private int manDaysP1;

	/**
	 * The man days of P2.
	 * Named "MDP2" in the "Projects" table.
	 */
	@Column(name="MDP2")
	private int manDaysP2;

	/**
	 * The man days of P3.
	 * Named "MDP3" in the "Projects" table.
	 */
	@Column(name="MDP3")
	private int manDaysP3;

	/**
	 * The man days of P4.
	 * Named "RO1Budget" in the "Projects" table.
	 */
	@Column(name="MDP4")
	private int manDaysP4;

	/**
	 * The man days of P5.
	 * Named "RO1Budget" in the "Projects" table.
	 */
	@Column(name="MDP5")
	private int manDaysP5;

	/**
	 * The man days of DS
	 */
	@Column(name="MDDS")
	private int manDaysDS;

	/**
	 * The man days of SS
	 */
	@Column(name="MDSS")
	private int manDaysSS;

	/**
	 *
	 */
	@Lob
	@Column(name="Descript", columnDefinition = "text", length=512)
	private String desc;

//	@OneToMany(mappedBy="project", fetch=FetchType.EAGER)
//	private List<Employee> empProjList;
//
//	@OneToMany(mappedBy="head", fetch=FetchType.EAGER)
//	private List<WorkPackage> wpList;

	/**
	 * Empty constructor for Project class
	 */
	public Project(){}

	/**
	 * Get the identification number of a project
	 *
	 * @return projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * Set the project identification number.
	 *
	 * @param projectId
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the name of a project.
	 *
	 * @return projName
	 */
	public String getProjName() {
		return projName;
	}

	/**
	 * Sets the project name.
	 *
	 * @param projName
	 */
	public void setProjName(String projName) {
		this.projName = projName;
	}

	/**
	 * Gets the supervisor that is responsible for this project
	 *
	 * @return supervisor
	 */
	public int getSupervisor() {
		return supervisor;
	}

	/**
	 * Sets the name of the supervisor in charge of this project.
	 *
	 * @param supervisor
	 */
	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}

//	public List<Employee> getEmpProjList() {
//		return empProjList;
//	}
//
//	public void setEmpProjList(List<Employee> empProjList) {
//		this.empProjList = empProjList;
//	}
//
//	public List<WorkPackage> getWpList() {
//		return wpList;
//	}
//
//	public void setWpList(List<WorkPackage> wpList) {
//		this.wpList = wpList;
//	}

	/**
	 * Gets the issued date of the project.
	 *
	 * @return issueDate
	 */
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * Sets the issue date of the project.
	 *
	 * @param issueDate
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * Gets the
	 *
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the
	 *
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Gets the proposal of a project.
	 *
	 * @return proposal
	 */
	public double getProposal() {
		return proposal;
	}

	/**
	 * Sets the proposal of a project.
	 *
	 * @param proposal
	 */
	public void setProposal(double proposal) {
		this.proposal = proposal;
	}

	/**
	 * Gets the initial budget of a project.
	 *
	 * @return initBudget
	 */
	public double getInitBudget() {
		return initBudget;
	}

	/**
	 * Sets the inital budget of a project.
	 *
	 * @param initBudget
	 */
	public void setInitBudget(double initBudget) {
		this.initBudget = initBudget;
	}

	/**
	 * Gets the RO1 budget.
	 *
	 * @return ro1Budget
	 */
	public double getRO1Budget() {
		return ro1Budget;
	}

	/**
	 * Sets the RO1 budget.
	 *
	 * @param ro1Budget
	 */
	public void setRO1Budget(double ro1Budget) {
		this.ro1Budget = ro1Budget;
	}

	/**
	 * Gets the RO2 budget.
	 *
	 * @return ro2Budget
	 */
	public double getRO2Budget() {
		return ro2Budget;
	}

	/**
	 * Sets the RO2 budget.
	 *
	 * @param ro2Budget
	 */
	public void setRO2Budget(double ro2Budget) {
		this.ro2Budget = ro2Budget;
	}

	/**
	 * Gets the final budget of this project.
	 *
	 * @return finalBudget
	 */
	public double getFinalBudget() {
		return finalBudget;
	}

	/**
	 * Sets the final budget of a project.
	 *
	 * @param finalBudget
	 */
	public void setFinalBudget(double finalBudget) {
		this.finalBudget = finalBudget;
	}

	/**
	 * Gets the man days for P1.
	 *
	 * @return manDaysP1
	 */
	public int getManDaysP1() {
		return manDaysP1;
	}

	/**
	 * Sets the man days for P1.
	 *
	 * @param manDaysP1
	 */
	public void setManDaysP1(int manDaysP1) {
		this.manDaysP1 = manDaysP1;
	}

	/**
	 * Gets the man days for P2.
	 *
	 * @return manDaysP2
	 */
	public int getManDaysP2() {
		return manDaysP2;
	}

	/**
	 * Sets the man days for P2.
	 *
	 * @param manDaysP2
	 */
	public void setManDaysP2(int manDaysP2) {
		this.manDaysP2 = manDaysP2;
	}

	/**
	 * Gets the man days for P3.
	 *
	 * @return manDaysP3
	 */
	public int getManDaysP3() {
		return manDaysP3;
	}

	/**
	 * Sets the man days for P3.
	 *
	 * @param manDaysP3
	 */
	 public void setManDaysP3(int manDaysP3) {
		this.manDaysP3 = manDaysP3;
	}

	/**
	 * Gets the man days for P4.
	 *
	 * @return manDaysP4
	 */
	public int getManDaysP4() {
		return manDaysP4;
	}

	/**
	 * Sets the man days for P4.
	 *
	 * @param manDaysP4
	 */
	public void setManDaysP4(int manDaysP4) {
		this.manDaysP4 = manDaysP4;
	}

	/**
	 * Gets the man days for P5.
	 *
	 * @return manDaysP5
	 */
	public int getManDaysP5() {
		return manDaysP5;
	}

	/**
	 * Sets the man days for P5.
	 *
	 * @param manDaysP5
	 */
	public void setManDaysP5(int manDaysP5) {
		this.manDaysP5 = manDaysP5;
	}

	/**
	 * Gets the man days for SS.
	 *
	 * @return manDaysSS
	 */
	public int getManDaysSS() {
		return manDaysSS;
	}

	/**
	 * Sets the man days for SS.
	 *
	 * @param manDaysSS
	 */
	public void setManDaysSS(int manDaysSS) {
		this.manDaysSS = manDaysSS;
	}

}
