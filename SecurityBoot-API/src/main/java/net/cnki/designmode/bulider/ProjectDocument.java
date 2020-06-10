package net.cnki.designmode.bulider;

import java.util.Date;

public class ProjectDocument {

    private String pidinfo;
	private String filename;
    private String projectname;
    private String projectmember;
    private String projectnum;
    private String allContent;
    private String researchTarget;
    private String researchContent;
    private String researchPlan;
    private String researchOther;
    private Date createTime;

    public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getAllContent() {
		return allContent;
	}

	public void setAllContent(String allContent) {
		this.allContent = allContent;
	}

	public String getPidinfo() {
		return pidinfo;
	}

	public void setPidinfo(String pidinfo) {
		this.pidinfo = pidinfo;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectmember() {
		return projectmember;
	}

	public void setProjectmember(String projectmember) {
		this.projectmember = projectmember;
	}

	public String getProjectnum() {
		return projectnum;
	}

	public void setProjectnum(String projectnum) {
		this.projectnum = projectnum;
	}

	public String getResearchTarget() {
		return researchTarget;
	}

	public void setResearchTarget(String researchTarget) {
		this.researchTarget = researchTarget;
	}

	public String getResearchContent() {
		return researchContent;
	}

	public void setResearchContent(String researchContent) {
		this.researchContent = researchContent;
	}

	public String getResearchPlan() {
		return researchPlan;
	}

	public void setResearchPlan(String researchPlan) {
		this.researchPlan = researchPlan;
	}

	public String getResearchOther() {
		return researchOther;
	}

	public void setResearchOther(String researchOther) {
		this.researchOther = researchOther;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
