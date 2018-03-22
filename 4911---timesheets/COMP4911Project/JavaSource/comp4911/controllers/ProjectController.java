package comp4911.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import comp4911.managers.ProjectManager;
import comp4911.models.Project;

@Named("projectControl")
@SessionScoped
public class ProjectController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Injects an instance of a project.
	 */
	@Inject
	private Project project;

	/**
	 * Injects an instance of a project manager.
	 */
	@Inject
	private ProjectManager projectManager;

	/**
	 * A list of all the projects in the database.
	 */
	private List<Project> projectList;

	/**
	 * A Constructor of the ProjectController class which instansiates a
	 * list of all the projects at the beginning.
	 */
	public ProjectController() {
		System.out.println("Constructor called");
		projectList = new ArrayList<Project>();
	}

	/**
	 * Gets a project object.
	 *
	 * @return project
	 */
	public Project getProject() {
		System.out.println("getProject() called");
		projectList = projectManager.getAll();
		System.out.println(projectList.size() + " size");
		return project;
	}

	/**
	 * Sets a project object.
	 *
	 * @param project
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * Gets a project manager object.
	 *
	 * @return projectManager
	 */
	public ProjectManager getProjectManager() {
		return projectManager;
	}

	/**
	 * Sets a project manager object.
	 *
	 * @param project
	 */
	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	/**
	 * This function refreshes the list of all the projects.
	 */
	public void refreshList(){
		projectList = projectManager.getAll();
	}

	/**
	 * Gets list of all the projects.
	 *
	 * @return projectList
 	 */
	public List<Project> getProjectList() {
		System.out.println("WTF getProjectList");
		refreshList();
		return projectList;
	}

	/**
	 * Sets the list of all the projects.
	 *
	 * @param projectList
 	 */
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	/**
	 * This function creates a new project and gives it an
	 * identification number and the corresponding information
	 * and saves it with the project manager.
	 *
	 * @return projects
	 */
	public String addProject(){
		Project temp = new Project();
		int id = projectList.size() + 1;

		temp.setProjectId(id);
		temp.setProjName(project.getProjName());
		temp.setSupervisor(project.getSupervisor());
		temp.setDesc(project.getDesc());

		projectManager.persist(temp);
		refreshList();

		return "projects";
	}

	/**
	 * This function cancels the new project by
	 * navigating into a another page called "reloadProjects".
	 *
	 * @return reloadProjects
	 */
	public String cancelNewProject(){
		return "reloadProjects";
	}
}
