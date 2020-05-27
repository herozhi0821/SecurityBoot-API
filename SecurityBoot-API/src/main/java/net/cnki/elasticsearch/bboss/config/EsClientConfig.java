package net.cnki.elasticsearch.bboss.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/***
 * 管理Es rest client组件
 * */
@Component
public class EsClientConfig {

	private static ClientInterface restClient;
	private static String basePath;
	private static String indexs;
	
	private static Map<String,ClientInterface> client = new ConcurrentHashMap<>();
	
	public static  ClientInterface restClient() {
		if (restClient == null) {
			synchronized (ClientInterface.class) {
				if (restClient == null) {
					restClient = ElasticSearchHelper.getRestClientUtil();
				}
			}
		}
		return restClient;
	}
	
	public static ClientInterface restClient(String index){
		if(client.isEmpty()){
			String[] indexArr = indexs.split(",");
			for(int i=0;i<indexArr.length;i++){
				client.put(indexArr[i],ElasticSearchHelper.getConfigRestClientUtil(basePath+indexArr[i]+".xml"));
			}
		}
		return client.get(index);
	}	
	@Value("${es.basePath}")
	public void setBasePath(String basePath) {
		EsClientConfig.basePath = basePath;
	}

	@Value("${es.indexs}")
	public void setIndexs(String indexs) {
		EsClientConfig.indexs = indexs;
	}
	
}
