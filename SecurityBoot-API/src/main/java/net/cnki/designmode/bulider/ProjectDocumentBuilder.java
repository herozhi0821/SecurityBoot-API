package net.cnki.designmode.bulider;

import java.util.Date;

/**
 * 产品实体
 */
public class ProjectDocumentBuilder {
    private static ProjectDocument projectDocument;

    // create start
    public static ProjectDocumentBuilder create(){
    	projectDocument = new ProjectDocument();
        return new ProjectDocumentBuilder();
    }
    public ProjectDocumentBuilder addPidinfo(String pidinfo) {
    	projectDocument.setPidinfo(pidinfo);
        return this;
    }

    public ProjectDocumentBuilder addFilename(String filename) {
    	projectDocument.setFilename(filename);
        return this;
    }
    
    public ProjectDocumentBuilder addProjectname(String projectname) {
    	projectDocument.setProjectname(projectname);
        return this;
    }

    public ProjectDocumentBuilder addProjectmember(String projectmember) {
    	projectDocument.setProjectmember(projectmember);
        return this;
    }

    public ProjectDocumentBuilder addProjectnum(String projectnum) {
    	projectDocument.setProjectnum(projectnum);
        return this;
    }
    
    public ProjectDocumentBuilder addAllContent(String allContent) {
    	projectDocument.setAllContent(allContent);
        return this;
    }
    
    public ProjectDocumentBuilder addResearchTarget(String researchTarget) {
    	projectDocument.setResearchTarget(researchTarget);
        return this;
    }
    
    public ProjectDocumentBuilder addResearchContent(String ResearchContent) {
    	projectDocument.setResearchContent(ResearchContent);
        return this;
    }
    
    public ProjectDocumentBuilder addResearchPlan(String researchPlan) {
    	projectDocument.setResearchPlan(researchPlan);
        return this;
    }
    
    public ProjectDocumentBuilder addResearchOther(String researchOther) {
    	projectDocument.setResearchOther(researchOther);
        return this;
    }
    
    public ProjectDocumentBuilder addCreateTime(Date createTime) {
    	projectDocument.setCreateTime(createTime);
        return this;
    }

    public ProjectDocument builder() {
        return projectDocument;
    }
}
