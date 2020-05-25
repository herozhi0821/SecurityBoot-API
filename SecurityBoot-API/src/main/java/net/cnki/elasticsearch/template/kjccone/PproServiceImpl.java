package net.cnki.elasticsearch.template.kjccone;

import com.alibaba.fastjson.JSON;

import net.cnki.elasticsearch.template.service.impl.BaseSearchServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * elasticsearch 搜索引擎 service实现
 */
@Service
public class PproServiceImpl extends BaseSearchServiceImpl<ProductDocument2> implements ProService {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;
    @Resource
    private ProjectRepository projectRepository;

    @Override
    public void save(ProductDocument2 ... productDocuments) {
        elasticsearchTemplate.putMapping(ProductDocument2.class);
        if(productDocuments.length > 0){
            /*Arrays.asList(productDocuments).parallelStream()
                    .map(productDocumentRepository::save)
                    .forEach(productDocument -> log.info("【保存数据】：{}", JSON.toJSONString(productDocument)));*/
            log.info("【保存索引】：{}",JSON.toJSONString(projectRepository.saveAll(Arrays.asList(productDocuments))));
        }
    }


}
