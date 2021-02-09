package com.avensys.model;

public class JobPostingRequestModel {
	private String jobID;
	private String title;
	private String description;
	private String company;
	private String companyAddress;
	private String reportingDateTime;
	private String pay;
	private String status;
	
	private String jobReqID;
	private String jobSeekerID;
	private String jobReqStatus;
	
	
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getReportingDateTime() {
		return reportingDateTime;
	}
	public void setReportingDateTime(String reportingDateTime) {
		this.reportingDateTime = reportingDateTime;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJobReqID() {
		return jobReqID;
	}
	public void setJobReqID(String jobReqID) {
		this.jobReqID = jobReqID;
	}
	public String getJobSeekerID() {
		return jobSeekerID;
	}
	public void setJobSeekerID(String jobSeekerID) {
		this.jobSeekerID = jobSeekerID;
	}
	public String getJobReqStatus() {
		return jobReqStatus;
	}
	public void setJobReqStatus(String jobReqStatus) {
		this.jobReqStatus = jobReqStatus;
	}
}
