package net.cnki.elasticsearch.template.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import net.cnki.elasticsearch.template.document.ProductDocument;

/**
 * 
 */
@Component
public interface ProductDocumentRepository extends ElasticsearchRepository<ProductDocument,String> {
	
}
