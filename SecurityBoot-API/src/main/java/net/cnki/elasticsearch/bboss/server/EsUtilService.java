package net.cnki.elasticsearch.bboss.server;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import net.cnki.elasticsearch.bboss.GenericsUtils;
import net.cnki.elasticsearch.bboss.bean.ProjectDocument;
import net.cnki.elasticsearch.bboss.bean.SingleFileDocument;
import net.cnki.elasticsearch.bboss.config.EsClientConfig;


/**
 * es service
 * */
@Service
public class EsUtilService {
	/**
	 * 根据id删除
	 * @param index：索引名称
	 * @param indexType：索引类型名称（文档）
	 * @param id：id
	 */
	 public void deleteDocumentById(String index,String indexType ,String id) {
		 ClientInterface clientUtil = EsClientConfig.restClient();
		 clientUtil.deleteDocument(index, indexType, id); 
	 }
	 /**
	 * 添加或修改文档
	 * @param index：索引名称
	 * @param indexType：索引类型名称（文档）
	 * @param list：集合
	  * */
	 public <T> void addOrUpdateDocuments(String index,String indexType,List<T> list) {
		ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
		//向固定index添加或者修改文档,id，否则做添加文档操作，返回处理结果
		//索引表 索引类型
		clientUtil.addDocuments(index,indexType,list);
	 }
	 /**
	 * 根据id删除Es文档,并返回结果
	 * @param index：索引名称
	 * @param indexType：索引类型名称（文档）
	 * @param id：id
	 * @return false：不存在；true：已经删除
	 * */
	 public String deleteDocumentByEsId(String index,String indexType ,String id) {
		 ClientInterface clientUtil = EsClientConfig.restClient();
		 String s = clientUtil.deleteDocument(index, indexType, id);
		 JSONObject object = JSONObject.parseObject(s);
		 String result = object.get("found").toString();
		 return result;
	 }
	 
	 /**
	  * 添加或修改单个文档
	  * @param index
	  * @param indexType
	  * @param bean
	  * @return
	  */
	 public String addOrUpdateDocument(String index,String indexType,Object bean) {
		ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
		//索引表 索引类型
		String result = clientUtil.addDocument(index,indexType,bean);
		return result;
	 }
	 /**
	  * 创建或者更新索引文档(实体类@ESIndex注解后才可使用)
	  * indexName,indexType索引类型和type必须通过bean对象的ESIndex来指定，否则抛出异常
	  * @param bean
	  * @return
	  */
	 public String addOrUpdateDocument(Object bean) {
			ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
			String result = clientUtil.addDocument(bean);
			return result;
		 }
	 /**
	 * 获取文档
	 */
	public String getDocumentById(String index,String type,String id){
		//获取文档的客户端对象，单实例多线程安全
		ClientInterface clientUtil = EsClientConfig.restClient();
		//索引表 索引类型 id
		String res = clientUtil.getDocument(index,type,id);
		return res;
	}
	/**
	 * 获取文档
	 */
	public <T> T getDocumentById(String index,String type,String id,Class<T> t){
		//获取文档的客户端对象，单实例多线程安全
		ClientInterface clientUtil = EsClientConfig.restClient();
		//索引表 索引类型 id 对象
		return clientUtil.getDocument(index,type,id,t);
	}
		
	 /**
	 * 通过mapper文件执行查询语句
	 * @param index 索引
	 * @param params 传递的参数
	 * @param dsl 对应mapper文件的name
	 */
	public <T> List<T> exec(String index,T params,String dsl){
		//获取索引对应的客户端
		ClientInterface clientUtil = EsClientConfig.restClient(index);
		System.out.println("index"+index+"__"+dsl);
		//设定查询条件,通过map传递变量参数值,key对于dsl中的变量名称
		//执行查询，index为索引表，_search为检索操作action
		//使用反射获取Class<T>
		Class<T> clazz = GenericsUtils.getSuperClassGenricType(params.getClass());
		ESDatas<T> esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
				clientUtil.searchList(index+"/_search",//demo为索引表，_search为检索操作action
						dsl,//esmapper/xxx.xml中定义的dsl语句的name
						params,//变量参数
						clazz);//返回的文档封装对象类型
		//获取结果对象列表，最多返回1000条记录
		List<T> list = esDatas.getDatas();
		//获取总记录数
		long totalSize = esDatas.getTotalSize();
		return list;
	}
	
	/**
	 * 根据ID进行获取(不如getDocumentById简单)
	 * @param <T>
	 * @param index 索引
	 * @param param 实体类
	 * @param id 数据ID
	 * @param dsl mapping中的方法名
	 * @return
	 */
	public <T> List<T> searchById(String index,T param,String id,String dsl){
		//获取索引对应的客户端
		ClientInterface clientUtil = EsClientConfig.restClient(index);
		
		//设定查询条件,通过map传递变量参数值,key对于dsl中的变量名称
		Map<String,Object> paras = new HashMap<String,Object>();
		paras.put("condition",id);

		//使用反射获取Class<T>
		Class<T> clazz = GenericsUtils.getSuperClassGenricType(param.getClass());
		
		//执行查询，index为索引表，_search为检索操作action
		ESDatas<T> esDatas =  //ESDatas包含当前检索的记录集合，最多1000条记录，由dsl中的size属性指定
				clientUtil.searchList(index+"/_search",//demo为索引表，_search为检索操作action
						dsl,//esmapper/xxx.xml中定义的dsl语句的name
						paras,//变量参数
						clazz);//返回的文档封装对象类型
		List<T> list = esDatas.getDatas();
		return list;
	}
	
	/**
	 * 比对库字段高亮检索
	 * @param index 索引
	 * @param field 指定字段，与isall搭配true使用
	 * @param content 查询内容
	 * @param isall 为false时全部字段查询高亮
	 * @return
	 * @throws ParseException
	 */
	public List<ProjectDocument> proHightLightSearch(String index,String field, String content,boolean isall) throws ParseException {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/project.xml");
        
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("coml",field);
        params.put("cont",content);
        params.put("isall",isall);
        
        ESDatas<ProjectDocument> esDatas =  
                clientUtil.searchList(index+"/_search",//demo为索引表，_search为检索操作action
                		"proHighSearch",//esmapper/demo.xml中定义的dsl语句
                        params,//变量参数
                        ProjectDocument.class);//返回的文档封装对象类型
        List<ProjectDocument> pros = esDatas.getDatas();
        pros.stream().forEach(proDocu->{//lamada
        	Map<String,List<Object>> highLights = proDocu.getHighlight();//多字段
        	highLights.forEach( (k,v)->{
                v.stream().forEach(fieldCon->{
//                	System.out.println("fieldName:"+k+",fieldCon:"+fieldCon);
                });
        	});
        });
		return pros;
    }
	
	/**
	 * 上传文档字段高亮检索
	 * @param index 索引
	 * @param field 指定字段，与isall搭配true使用
	 * @param content 查询内容
	 * @param isall 为false时全部字段查询高亮
	 * @return
	 * @throws ParseException
	 */
	public List<SingleFileDocument> singleHightLightSearch(String index,String field, String content,boolean isall) throws ParseException {
        ClientInterface clientUtil = ElasticSearchHelper.getConfigRestClientUtil("esmapper/project.xml");
        
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("coml",field);
        params.put("cont",content);
        params.put("isall",isall);
        
        ESDatas<SingleFileDocument> esDatas =  
                clientUtil.searchList(index+"/_search",//demo为索引表，_search为检索操作action
                		"proHighSearch",//esmapper/demo.xml中定义的dsl语句
                        params,//变量参数
                        SingleFileDocument.class);//返回的文档封装对象类型
        List<SingleFileDocument> pros = esDatas.getDatas();
        pros.stream().forEach(proDocu->{//lamada
        	Map<String,List<Object>> highLights = proDocu.getHighlight();//多字段
        	highLights.forEach( (k,v)->{
                v.stream().forEach(fieldCon->{
                	System.out.println("fieldName:"+k+",fieldCon:"+fieldCon);
                });
        	});
        });
		return pros;
    }

}
