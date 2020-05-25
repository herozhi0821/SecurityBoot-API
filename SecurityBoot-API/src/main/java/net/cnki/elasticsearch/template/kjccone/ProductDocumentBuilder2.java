package net.cnki.elasticsearch.template.kjccone;

import java.util.Date;

/**
 * 产品实体
 */
public class ProductDocumentBuilder2 {
    private static ProductDocument2 productDocument;

    // create start
    public static ProductDocumentBuilder2 create(){
        productDocument = new ProductDocument2();
        return new ProductDocumentBuilder2();
    }
    public ProductDocumentBuilder2 addPidinfo(String pidinfo) {
        productDocument.setPidinfo(pidinfo);
        return this;
    }

    public ProductDocumentBuilder2 addFilename(String filename) {
        productDocument.setFilename(filename);
        return this;
    }
    
    public ProductDocumentBuilder2 addProjectname(String projectname) {
        productDocument.setProjectname(projectname);
        return this;
    }

    public ProductDocumentBuilder2 addProjectmember(String projectmember) {
        productDocument.setProjectmember(projectmember);
        return this;
    }

    public ProductDocumentBuilder2 addProjectnum(String projectnum) {
        productDocument.setProjectnum(projectnum);
        return this;
    }
    
    public ProductDocumentBuilder2 addAllContent(String allContent) {
        productDocument.setAllContent(allContent);
        return this;
    }
    
    public ProductDocumentBuilder2 addResearchTarget(String researchTarget) {
        productDocument.setResearchTarget(researchTarget);
        return this;
    }
    
    public ProductDocumentBuilder2 addResearchContent(String ResearchContent) {
        productDocument.setResearchContent(ResearchContent);
        return this;
    }
    
    public ProductDocumentBuilder2 addResearchPlan(String researchPlan) {
        productDocument.setResearchPlan(researchPlan);
        return this;
    }
    
    public ProductDocumentBuilder2 addResearchOther(String researchOther) {
        productDocument.setResearchOther(researchOther);
        return this;
    }
    
    public ProductDocumentBuilder2 addCreateTime(Date createTime) {
        productDocument.setCreateTime(createTime);
        return this;
    }

    public ProductDocument2 builder() {
        return productDocument;
    }
}
