package net.cnki.elasticsearch.template.kjccone;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public interface ProjectRepository extends ElasticsearchRepository<ProductDocument2,String> {
	
}
