package net.cnki.elasticsearch.bboss.bean;

import org.frameworkset.elasticsearch.entity.ESBaseData;

import com.frameworkset.orm.annotation.ESId;
import com.frameworkset.orm.annotation.ESIndex;

import java.util.Date;

//@ESIndex(name = "singlefile",type = "singlefile")
public class SingleFileDocument extends ESBaseData {

	@ESId
    private String pidinfo;
	private String filename;
    private String projectname;
    private String projectmember;
    private String projectnum;
    private String projectType;//项目分类
    private String company;//承办单位
    private String allContent;
    private String researchOne;
    private String researchTwo;
    private String researchThree;
    private String researchFour;
    private String researchFive;
    private Date createTime;


    
    public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getResearchOne() {
		return researchOne;
	}

	public void setResearchOne(String researchOne) {
		this.researchOne = researchOne;
	}

	public String getResearchTwo() {
		return researchTwo;
	}

	public void setResearchTwo(String researchTwo) {
		this.researchTwo = researchTwo;
	}

	public String getResearchThree() {
		return researchThree;
	}

	public void setResearchThree(String researchThree) {
		this.researchThree = researchThree;
	}

	public String getResearchFour() {
		return researchFour;
	}

	public void setResearchFour(String researchFour) {
		this.researchFour = researchFour;
	}

	public String getResearchFive() {
		return researchFive;
	}

	public void setResearchFive(String researchFive) {
		this.researchFive = researchFive;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public SingleFileDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SingleFileDocument(String pidinfo, String filename, String projectname, String projectmember,
			String projectnum, String projectType, String company, String allContent, String researchOne,
			String researchTwo, String researchThree, String researchFour, String researchFive, Date createTime) {
		super();
		this.pidinfo = pidinfo;
		this.filename = filename;
		this.projectname = projectname;
		this.projectmember = projectmember;
		this.projectnum = projectnum;
		this.projectType = projectType;
		this.company = company;
		this.allContent = allContent;
		this.researchOne = researchOne;
		this.researchTwo = researchTwo;
		this.researchThree = researchThree;
		this.researchFour = researchFour;
		this.researchFive = researchFive;
		this.createTime = createTime;
	}

}
