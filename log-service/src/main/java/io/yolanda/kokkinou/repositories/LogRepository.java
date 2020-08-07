package io.yolanda.kokkinou.repositories;

import io.yolanda.kokkinou.dto.LogMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends ElasticsearchRepository<LogMessage, String> {

}
