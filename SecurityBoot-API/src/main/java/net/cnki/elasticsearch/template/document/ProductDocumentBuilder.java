package net.cnki.elasticsearch.template.document;

import java.util.Date;

/**
 * 产品实体
 */
public class ProductDocumentBuilder {
    private static ProductDocument productDocument;

    // create start
    public static ProductDocumentBuilder create(){
        productDocument = new ProductDocument();
        return new ProductDocumentBuilder();
    }
    public ProductDocumentBuilder addPidinfo(String pidinfo) {
        productDocument.setPidinfo(pidinfo);
        return this;
    }

    public ProductDocumentBuilder addFilename(String filename) {
        productDocument.setFilename(filename);
        return this;
    }
    
    public ProductDocumentBuilder addProjectname(String projectname) {
        productDocument.setProjectname(projectname);
        return this;
    }

    public ProductDocumentBuilder addProjectmember(String projectmember) {
        productDocument.setProjectmember(projectmember);
        return this;
    }

    public ProductDocumentBuilder addProjectnum(String projectnum) {
        productDocument.setProjectnum(projectnum);
        return this;
    }
    
    public ProductDocumentBuilder addAllContent(String allContent) {
        productDocument.setAllContent(allContent);
        return this;
    }
    
    public ProductDocumentBuilder addResearchTarget(String researchTarget) {
        productDocument.setResearchTarget(researchTarget);
        return this;
    }
    
    public ProductDocumentBuilder addResearchContent(String ResearchContent) {
        productDocument.setResearchContent(ResearchContent);
        return this;
    }
    
    public ProductDocumentBuilder addResearchPlan(String researchPlan) {
        productDocument.setResearchPlan(researchPlan);
        return this;
    }
    
    public ProductDocumentBuilder addResearchOther(String researchOther) {
        productDocument.setResearchOther(researchOther);
        return this;
    }
    
    public ProductDocumentBuilder addCreateTime(Date createTime) {
        productDocument.setCreateTime(createTime);
        return this;
    }

    public ProductDocument builder() {
        return productDocument;
    }
}
