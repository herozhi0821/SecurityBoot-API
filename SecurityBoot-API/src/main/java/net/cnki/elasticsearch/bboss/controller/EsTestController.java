package net.cnki.elasticsearch.bboss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.cnki.elasticsearch.bboss.bean.ProjectDocument;
import net.cnki.elasticsearch.bboss.bean.Teacher;
import net.cnki.elasticsearch.bboss.server.ESUtil;
import net.cnki.elasticsearch.bboss.server.EsUtilService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class EsTestController {
    @Autowired
    private ESUtil esUtil;
    @Autowired
	EsUtilService esUtilService;

    @GetMapping("add")
    public String add(){
        Teacher teacher = new Teacher();
        teacher.setTeacherId("2");
        teacher.setName("吴老师");
        teacher.setSex("男");
        teacher.setAge(50);
        Teacher teacher1 = new Teacher();
        teacher1.setTeacherId("1");
        teacher1.setName("王老师");
        teacher1.setSex("女");
        teacher1.setAge(20);
        List<Teacher> list = new ArrayList<>();
        list.add(teacher);
        list.add(teacher1);
        esUtil.addOrUpdateDocuments("teacher","teacher",list);
        return "ok";
    }

    @GetMapping("delete")
    public String delete(){
        esUtil.deleteDocumentById("teacher","teacher","1");
        return "ok";
    }

    @GetMapping("get")
    public List<Teacher> get(){
        Teacher teacher = new Teacher();
        teacher.setTeacherId("2");
        List<Teacher> t = esUtil.exec("teacher",teacher,"searchTeacher");
        return t;
    }
    
 // 标题查重项目详情-采用原有页面
 	@RequestMapping(value = "testes")
 	public String testes() {

 		String allContent = "海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。";
 		String researchTarget = "海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。";
 		String researchContent = "海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。";
 		String researchPlan = "海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。";
 		String researchOther = "海洋平台结构长期服役在恶劣的海洋环境中，并受到各种载荷的交互作用，如风载荷、海流、波浪载荷、冰载荷等，有时还要遭受到地震、台风、海啸、船碰撞等意外灾害，结构本身还要遭受环境腐蚀、海洋生物附着、海底冲刷等的影响。在这些恶劣的环境载荷的长期作用下，容易产生各种形式的损伤，使结构的承载能力下降，对平台构成潜在威胁，严重的还会导致平台失效。如1980年3月27日，挪威“亚历山大·基兰”号钻井平台在9级海风作用下一根支柱发生断裂，平台15分钟后沉入海底，123人遇难。";
 		ProjectDocument projectMateDocu1 = new ProjectDocument("1", "测试文件名001", "测试项目名001", "测试项目参与人员001", "测试项目编号001","科技类","科研诚信", allContent, researchTarget, researchContent, researchPlan, researchOther,"", new Date());
 		ProjectDocument projectMateDocu2 = new ProjectDocument("2", "测试文件名002", "测试项目名002", "测试项目参与人员002", "测试项目编号002","科技类","科研诚信", allContent, researchTarget, researchContent, researchPlan, researchOther,"", new Date());
 		List<ProjectDocument> list = new ArrayList<>();
 		list.add(projectMateDocu1);
 		list.add(projectMateDocu2);
 		esUtilService.addOrUpdateDocuments("testes", "project", list);
 		return "ok";
 	}
 	
 	@RequestMapping(value = "testesget")
 	public String testesget() {
 		return esUtilService.getDocumentById("testes", "project", "1");
 	}
 	
 	@RequestMapping(value = "testesgethight")
 	public List<ProjectDocument> testesgethight() throws ParseException {
 		return esUtilService.proHightLightSearch("testes", "allContent", "在这些恶劣的环境载荷的长期作用下", false);
 	}
}
