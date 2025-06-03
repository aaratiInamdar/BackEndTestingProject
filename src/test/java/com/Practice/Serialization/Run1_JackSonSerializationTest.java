package com.Practice.Serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


@JsonPropertyOrder(
		value= {
				"createdBy",
				"projectName",
				"status",
				"teamSize"
		}
		)

@JsonIgnoreProperties(
		value= {
				"teamSize"
		}
		)


class Project{
	
	
//	POJO CLASS 
	
	private String projectName;
	
	@JsonProperty(value="created By")
	private String createdBy;
	private int teamSize;
	private String status;
	
	private Project()
	{
//		empty constructor required for de-Serialization
	}

	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}

	public String getProjectName() {
		
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

public class Run1_JackSonSerializationTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		Project prj=new Project("Navi_Mumbai", "Aarati", 10, "Created");
		
		ObjectMapper obj=new ObjectMapper();
		obj.writeValue(new File("./project.json"), prj);
		
		System.out.println("====END =====");
	}
}
