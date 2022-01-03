package com.example.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DemoRepository extends ElasticsearchRepository<DemoEvent, String> {

	List<DemoEvent> findByTimestampAfter(Date timestampAfter);
}
