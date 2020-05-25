package net.cnki.elasticsearch.template.controller;

import org.springframework.web.bind.annotation.*;

import net.cnki.elasticsearch.template.document.ProductDocument;
import net.cnki.elasticsearch.template.document.ProductDocumentBuilder;
import net.cnki.elasticsearch.template.page.Page;
import net.cnki.elasticsearch.template.service.EsSearchService;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * elasticsearch 搜索
 */
@RestController
public class EsSearchController {
//    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private EsSearchService esSearchService;
    
    @RequestMapping("gaol_page")
    public Page<Map<String,Object>> queryByPage(int pageNo,int indexName,int fieldNames,String keyword){
        
        //处理索引
    	String indexString = "";
    	if (indexName == 1) {
    		indexString = "kjcc";
		}else if (indexName == 2) {
			indexString = "kjcc";
		}
    	String field = "";
    	if (fieldNames == 1) {
    		field = "researchPlan,researchContent,researchTarget";
		}else if (fieldNames == 2) {
			field = "researchPlan";
		}else if (fieldNames == 3) {
			field = "researchContent";
		}else if (fieldNames == 3) {
			field = "researchresearchTarget";
		}
    	String[] fieldNamesq = field.split(",");
    	return esSearchService.queryHitByPage(pageNo,1,keyword,indexString,fieldNamesq);
    }

    /**
     * 新增 / 修改索引
     * @return
     */
    @RequestMapping("save")
    public String add() {
    	ProductDocument productDocument = ProductDocumentBuilder.create()
                .addPidinfo("2")
                .addFilename("2222部分更新")
                .addProjectname("高精度导管架平台结构安全监测系统应用研究")
                .addProjectmember("张良;吴尊;sd")
                .addProjectnum("10010")
                .addAllContent("高精度导管架平台结构安全监测系统应用研究-报告书")
                .addResearchTarget("海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。")
                .addResearchContent("海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。")
                .addResearchPlan("海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。")
                .addResearchOther("海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。")
                .addCreateTime(new Date())
                .builder();
    	esSearchService.save(productDocument);
        return "success";
    }

    /**
     * 删除索引
     * @return
     */
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable String id) {
        esSearchService.delete(id);
        return "success";
    }
    /**
     * 清空索引
     * @return
     */
    @RequestMapping("delete_all")
    public String deleteAll(@PathVariable String id) {
        esSearchService.deleteAll();
        return "success";
    }

    /**
     * 根据ID获取
     * @return
     */
    @RequestMapping("get/{id}")
    public ProductDocument getById(@PathVariable String id){
        return esSearchService.getById(id);
    }

    /**
     * 根据获取全部
     * @return
     */
    @RequestMapping("get_all")
    public List<ProductDocument> getAll(){
        return esSearchService.getAll();
    }

    /**
     * 搜索
     * @param keyword
     * @return
     */
    @RequestMapping("query")
    public List<ProductDocument> query(String keyword){
        return esSearchService.query(keyword,ProductDocument.class);
    }

    /**
     * 搜索，命中关键字高亮
     * http://localhost:8080/query_hit?keyword=无印良品荣耀&indexName=orders&fields=productName,productDesc
     * @param keyword   关键字
     * @param indexName 索引库名称
     * @param fields    搜索字段名称，多个以“，”分割
     * @return
     */
    @RequestMapping("query_hit")
    public List<Map<String,Object>> queryHit(String keyword,String indexName,String fields){
        String[] fieldNames = {};
        if(fields.contains(",")) fieldNames = fields.split(",");
        else fieldNames[0] = fields;
        return esSearchService.queryHit(keyword,indexName,fieldNames);
    }

    /**
     * 搜索，命中关键字高亮
     * http://localhost:8080/query_hit_page?keyword=无印良品荣耀&indexName=orders&fields=productName,productDesc&pageNo=1&pageSize=1
     * @param pageNo    当前页
     * @param pageSize  每页显示的数据条数
     * @param keyword   关键字
     * @param indexName 索引库名称
     * @param fields    搜索字段名称，多个以“，”分割
     * @return
     */
    @RequestMapping("query_hit_page")
    public Page<Map<String,Object>> queryHitByPage(int pageNo,int pageSize
                                                    ,String keyword,String indexName, String fields){
        String[] fieldNames = {};
        if(fields.contains(",")) {
        	fieldNames = fields.split(",");
        }else{
        	fieldNames[0] = fields;
        }
        return esSearchService.queryHitByPage(pageNo,pageSize,keyword,indexName,fieldNames);
    }

    /**
     * 删除索引库
     * @param indexName
     * @return
     */
    @RequestMapping("delete_index/{indexName}")
    public String deleteIndex(@PathVariable String indexName){
        esSearchService.deleteIndex(indexName);
        return "success";
    }
}
