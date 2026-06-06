package com.Practice.Serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project1 {

String projectName;
String projectStatus;
int teamSize;
List<String> teamMember;
ProjectManager projectManager;

 public Project1(String projectName, String projectStatus, int teamSize, List<String> teamMember,
		ProjectManager projectManager) {
	super();
	this.projectName = projectName;
	this.projectStatus = projectStatus;
	this.teamSize = teamSize;
	this.teamMember = teamMember;
	this.projectManager = projectManager;
}
public void setProjectName(String projectName) {
     this.projectName = projectName;
 }
 public String getProjectName() {
     return projectName;
 }
 
 public void setProjectStatus(String projectStatus) {
     this.projectStatus = projectStatus;
 }
 public String getProjectStatus() {
     return projectStatus;
 }
 
 public void setTeamSize(int teamSize) {
     this.teamSize = teamSize;
 }
 public int getTeamSize() {
     return teamSize;
 }
 
 public void setTeamMember(List<String> teamMember) {
     this.teamMember = teamMember;
 }
 public List<String> getTeamMember() {
     return teamMember;
 }
 
 public void setProjectManager(ProjectManager projectManager) {
     this.projectManager = projectManager;
 }
 public ProjectManager getProjectManager() {
     return projectManager;
 }
 
}

 class ProjectManager {
	   String name;
	   String id;   
	    public ProjectManager(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
		public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    
	    public void setId(String id) {
	        this.id = id;
	    }
	    public String getId() {
	        return id;
	    }    
	}

public class Run1_PojoClass {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {	
		List<String> li=new ArrayList<String>();
		li.add("Jhon");
		li.add("Devid");
		li.add("Stev");

	ProjectManager pManager=new ProjectManager("Sagar", "tp01");
		Project1 pObj=new Project1("NaviMumbai", "created", 10, li, pManager);
		System.out.println("Start");	
		ObjectMapper obj=new ObjectMapper();
		obj.writeValue(new File("./project.json"), pObj);
	}
}