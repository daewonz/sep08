package com.ddww.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnnonyBoardDAO {

	List<Map<String, Object>> list(Map<String, Integer> map);

	void write(Map<String, Object> map);

	int count();

}
