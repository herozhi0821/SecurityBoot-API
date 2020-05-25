package net.cnki.elasticsearch.template.kjccone;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Date;

/**
 * elasticsearch 搜索
 */
@RestController
public class SearchController {
//    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ProService proService;

    /**
     * 新增 / 修改索引
     * @return
     */
    @RequestMapping("savepro")
    public String add() {
    	ProductDocument2 productDocument = ProductDocumentBuilder2.create()
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
    	proService.save(productDocument);
        return "success";
    }

 
}
