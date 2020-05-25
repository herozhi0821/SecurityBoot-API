package net.cnki.elasticsearch.template.kjccone;


import java.util.List;

import net.cnki.elasticsearch.template.service.BaseSearchService;

/**
 *
 */
public interface ProService extends BaseSearchService<ProductDocument2> {
    /**
     * 保存
     */
    void save(ProductDocument2... productDocuments);

}
