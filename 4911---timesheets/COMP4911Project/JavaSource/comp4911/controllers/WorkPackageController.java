package comp4911.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import comp4911.managers.WorkPackageManager;
import comp4911.models.WorkPackage;

@Named("workPackControl")
@SessionScoped
public class WorkPackageController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Injects an instance of a work package.
	 */
	@Inject
	private WorkPackage workPack;

	/**
	 * Injects an instance of a workpackage manager.
	 */
	@Inject
	private WorkPackageManager workPackManager;

	/**
	 * The list of all the workpackages.
	 */
	private List<WorkPackage> workPackList;

	/**
	 * The Constructor of the WorkPackageController class,
	 * which creates a list of workpackages.
	 */
	public WorkPackageController() {
		System.out.println("Constructor called");
		workPackList = new ArrayList<WorkPackage>();
	}

	/**
	 * Gets the workpackage object.
	 *
	 * @return workPack
	 */
	public WorkPackage getWorkPackage() {
		System.out.println("getWorkPackage() called");
		workPackList = workPackManager.getAll();
		System.out.println(workPackList.size() + " size");
		return workPack;
	}

	/**
	 * This function refreshes the list of all the workpackages.
	 */
	public void refreshList(){
		workPackList = workPackManager.getAll();
	}

	/**
	 * Gets the list of workpackages.
	 *
	 * @return workPackList
	 */
	public List<WorkPackage> getWorkPackList() {
		System.out.println("getWorkPackList");
		refreshList();
		return workPackList;
	}

	/**
	 * Sets the list of workpackages.
	 *
	 * @param workPack
	 */
	public void setWorkPackList(List<WorkPackage> workPackList) {
		this.workPackList = workPackList;
	}

}
